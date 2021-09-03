package com.github.easytag.service.component;

import com.github.easytag.core.enums.DataTypeEnum;
import com.github.easytag.core.enums.ExpressionMarkEnum;
import com.github.easytag.core.exception.ExpressRevertException;
import com.github.easytag.core.exception.UnSupportDataTypeException;
import com.github.easytag.service.dto.*;
import com.github.easytag.service.enums.FieldDataTypeEnum;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefaultFieldExpressionParser implements FieldExpressionParser {

    private static final String EXPRESSION_REGEX = " ";

    @Override
    public FieldExpressionContextDTO parseExpression(FieldExpressConditionDTO fieldExpressConditionDTO) {
        return doParseExpression(fieldExpressConditionDTO);
    }

    private FieldExpressionContextDTO doParseExpression(FieldExpressConditionDTO fieldExpressConditionDTO) {
        FieldExpressionContextDTO fieldExpressionContextDTO = new FieldExpressionContextDTO();
        // 变量抽取
        Map<String, FieldLogicDataDTO> variables = new HashMap<>();
        String expression = revertExpress(fieldExpressConditionDTO, variables);
        fieldExpressionContextDTO.setVariables(variables);
        fieldExpressionContextDTO.setExpression(expression);
        return fieldExpressionContextDTO;
    }

    private String revertExpress(FieldExpressConditionDTO fieldExpressConditionDTO, Map<String, FieldLogicDataDTO> variables) {
        StringBuffer expression = new StringBuffer();
        List<FieldExpressBranchDTO> expressBranches = fieldExpressConditionDTO.getFieldExpressBranches();
        for (FieldExpressBranchDTO expressBranch : expressBranches) {
            String judgeType = expressBranch.getJudgeType();
            FieldExpressItemDTO expressItem = expressBranch.getFieldExpressItem();
            FieldExpressConditionDTO childrenCondition = expressBranch.getFieldExpressCondition();
            if(expressItem != null) {
                expression.append(EXPRESSION_REGEX).append(judgeType).append(EXPRESSION_REGEX).append(revertItem(expressItem, variables));
            } else if(childrenCondition != null) {
                expression.append(EXPRESSION_REGEX).append(judgeType).append(EXPRESSION_REGEX).append(revertCondition(childrenCondition, variables));
            } else {
                throw new ExpressRevertException("生成表达式异常,连接符后面不能为空");
            }
        }

        return expression.toString().trim();
    }

    private String revertItem(FieldExpressItemDTO expressItem, Map<String, FieldLogicDataDTO> variables) {
        StringBuffer itemExpress = new StringBuffer();

        String sourceDataType = expressItem.getSourceDataType();
        FieldDataTypeEnum sourceDataTypeEnum = FieldDataTypeEnum.findByName(sourceDataType);
        if(sourceDataTypeEnum == null) {
            throw new UnSupportDataTypeException("不支持的数据类型");
        }
        FieldTypeConverter sourceConverter = FieldTypeConverterFactory.getConverter(sourceDataTypeEnum);
        FieldLogicDataDTO logicDataSource = sourceConverter.convert(expressItem.getSourceData());

        String targetDataType = expressItem.getTargetDataType();
        FieldDataTypeEnum targetDataTypeEnum = FieldDataTypeEnum.findByName(targetDataType);
        if(targetDataTypeEnum == null) {
            throw new UnSupportDataTypeException("不支持的数据类型");
        }
        FieldTypeConverter targetConverter = FieldTypeConverterFactory.getConverter(targetDataTypeEnum);
        FieldLogicDataDTO logicDataTarget = targetConverter.convert(expressItem.getTargetData());
        // 生成变量名
        String varNameSource = FieldVarNameGenerator.generateVarName(variables);
        variables.put(varNameSource, logicDataSource);
        String varNameTarget = FieldVarNameGenerator.generateVarName(variables);
        variables.put(varNameTarget, logicDataTarget);

        itemExpress.append(varNameSource).append(EXPRESSION_REGEX).append(expressItem.getLogicalOperator()).append(EXPRESSION_REGEX).append(varNameTarget);
        return itemExpress.toString().trim();
    }

    private String revertCondition(FieldExpressConditionDTO childrenCondition, Map<String, FieldLogicDataDTO> variables) {
        StringBuffer conditionExpress = new StringBuffer();
        conditionExpress.append(ExpressionMarkEnum.LEFT_CONDITION_MARK.getDesc()).append(EXPRESSION_REGEX);

        List<FieldExpressBranchDTO> expressBranches = childrenCondition.getFieldExpressBranches();
        for (FieldExpressBranchDTO expressBranch : expressBranches) {
            conditionExpress.append(expressBranch.getJudgeType()).append(EXPRESSION_REGEX);
            if(expressBranch.getFieldExpressItem() != null) {
                conditionExpress.append(revertItem(expressBranch.getFieldExpressItem(), variables));
            } else if(expressBranch.getFieldExpressCondition() != null) {
                conditionExpress.append(revertCondition(expressBranch.getFieldExpressCondition(), variables));
            } else {
                throw new ExpressRevertException("生成表达式异常,连接符后面不能为空");
            }
        }

        conditionExpress.append(EXPRESSION_REGEX).append(ExpressionMarkEnum.RIGHT_CONDITION_MARK.getDesc());
        return conditionExpress.toString().trim();
    }
}
