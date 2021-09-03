package com.github.easytag.service.service.impl;

import com.github.easytag.core.dto.express.ExpressionContext;
import com.github.easytag.core.dto.logic.LogicData;
import com.github.easytag.core.enums.DataTypeEnum;
import com.github.easytag.core.executors.expression.impl.DefaultExpressionExecutor;
import com.github.easytag.service.component.FieldExpressionParser;
import com.github.easytag.service.dto.AddEtReTagDTO;
import com.github.easytag.service.dto.FieldExpressionContextDTO;
import com.github.easytag.service.dto.FieldLogicDataDTO;
import com.github.easytag.service.entity.EtReField;
import com.github.easytag.service.entity.EtReTag;
import com.github.easytag.service.entity.EtReTagVal;
import com.github.easytag.service.enums.FieldDataTypeEnum;
import com.github.easytag.service.exception.BizException;
import com.github.easytag.service.repository.EtReTagRepository;
import com.github.easytag.service.repository.EtReTagValRepository;
import com.github.easytag.service.service.EtReFieldService;
import com.github.easytag.service.service.EtReTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
public class EtReTagServiceImpl implements EtReTagService {

    @Autowired
    private FieldExpressionParser fieldExpressionParser;

    @Autowired
    private EtReTagRepository etReTagRepository;

    @Autowired
    private EtReTagValRepository etReTagValRepository;

    @Autowired
    private EtReFieldService etReFieldService;

    @Transactional
    @Override
    public EtReTag addEtReTag(AddEtReTagDTO addEtReTagDTO) {
        Date curDate = new Date();
        // 转成表达式
        FieldExpressionContextDTO fieldExpressionContext = fieldExpressionParser.parseExpression(addEtReTagDTO.getFieldExpressConditionDTO());
        // 存储表达式
        EtReTag etReTag = new EtReTag();
        etReTag.setName(addEtReTagDTO.getName());
        etReTag.setExpression(fieldExpressionContext.getExpression());
        etReTag.setDeleted(false);
        etReTag.setCreatedBy(addEtReTagDTO.getModifier());
        etReTag.setUpdatedBy(addEtReTagDTO.getModifier());
        etReTag.setCreateTime(curDate);
        etReTag.setUpdateTime(curDate);
        EtReTag savedEtReTag = etReTagRepository.save(etReTag);
        // 存储变量
        Map<String, FieldLogicDataDTO> variables = fieldExpressionContext.getVariables();
        List<EtReTagVal> etReTagVals = convert2EtReTagVals(savedEtReTag.getId(), addEtReTagDTO.getModifier(), variables);
        if (!CollectionUtils.isEmpty(etReTagVals)) {
            etReTagValRepository.saveAll(etReTagVals);
        }
        return savedEtReTag;
    }

    /**
     * 执行标签
     * @param tagId 标签id
     * @return
     */
    @Override
    public boolean exec(Long tagId, Map<String, Object> vars) {

        /**
         * 根据标签获取表达式
         */
        ExpressionContext expressionContext = parseTagToExpression(tagId, vars);

        /**
         * 执行表达式
         */
        return DefaultExpressionExecutor.getInstance().execute(expressionContext);
    }

    /**
     * 根据标签获取表达式
     * @param tagId
     * @return
     */
    private ExpressionContext parseTagToExpression(Long tagId, Map<String, Object> vars) {
        // 查询标签
        EtReTag etReTag = etReTagRepository.getOne(tagId);
        if (etReTag == null) {
            throw new BizException("未查询到该标签");
        }

        // 查询标签变量
        Map<String, LogicData> variables = new HashMap<>();
        List<EtReTagVal> etReTagValList = etReTagValRepository.queryByTagIdAndDeletedIsFalse(tagId);
        if (!CollectionUtils.isEmpty(etReTagValList)) {
            variables = etReTagValList.stream().collect(Collectors.toMap(EtReTagVal::getValName, etReTagVal -> {
                Integer valDataType = etReTagVal.getValDataType();
                FieldDataTypeEnum fieldDataTypeEnum = FieldDataTypeEnum.findByCode(valDataType);
                if (fieldDataTypeEnum == null) {
                    throw new RuntimeException("不存在的数据类型");
                }
                if (FieldDataTypeEnum.FIELD.equals(fieldDataTypeEnum)) {
                    String fieldId = etReTagVal.getValValue();
                    EtReField field = etReFieldService.getFieldById(Long.valueOf(fieldId));
                    if (field == null) {
                        throw new RuntimeException("不存在的字段");
                    }
                    String valValue = etReFieldService.getValById(Long.valueOf(fieldId), vars);
                    return new LogicData(DataTypeEnum.findByCode(field.getDataType()).convertValue(valValue, "yyyy-MM-dd HH:mm:ss"), DataTypeEnum.findByCode(field.getDataType()));
                } else {
                    return new LogicData(DataTypeEnum.findByName(fieldDataTypeEnum.name()).convertValue(etReTagVal.getValValue(), "yyyy-MM-dd HH:mm:ss"), DataTypeEnum.findByName(fieldDataTypeEnum.name()));
                }
            }));
        }
        ExpressionContext expressionContext = new ExpressionContext();
        expressionContext.setExpression(etReTag.getExpression());
        expressionContext.setVariables(variables);

        return expressionContext;
    }

    private List<EtReTagVal> convert2EtReTagVals(Long etReTagId, String modifier, Map<String, FieldLogicDataDTO> variables) {
        Date curDate = new Date();
        Set<Map.Entry<String, FieldLogicDataDTO>> entries = variables.entrySet();
        if (CollectionUtils.isEmpty(entries)) {
            return new ArrayList<>();
        }
        List<EtReTagVal> etReTagValList = new ArrayList<>();
        for (Map.Entry<String, FieldLogicDataDTO> entry : entries) {
            EtReTagVal etReTagVal = new EtReTagVal();
            etReTagVal.setTagId(etReTagId);
            etReTagVal.setValName(entry.getKey());
            etReTagVal.setValDataType(entry.getValue().getFieldDataType().getCode());
            etReTagVal.setValValue(String.valueOf(entry.getValue().getValue()));
            etReTagVal.setDeleted(false);
            etReTagVal.setCreateTime(curDate);
            etReTagVal.setUpdateTime(curDate);
            etReTagVal.setCreatedBy(modifier);
            etReTagVal.setUpdatedBy(modifier);
            etReTagValList.add(etReTagVal);
        }
        return etReTagValList;
    }
}
