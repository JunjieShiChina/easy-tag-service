package com.github.easytag.service.service.impl;

import com.github.easytag.service.dto.EtReFieldDTO;
import com.github.easytag.service.entity.EtReField;
import com.github.easytag.service.entity.EtReFieldValFrom;
import com.github.easytag.service.entity.EtReSql;
import com.github.easytag.service.repository.EtReFieldRepository;
import com.github.easytag.service.service.EtReFieldService;
import com.github.easytag.service.service.EtReFieldValFromService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Map;

@Service
@Slf4j
public class EtReFieldServiceImpl implements EtReFieldService {

    @Autowired
    private EtReFieldRepository etReFieldRepository;

    @Autowired
    private EtReFieldValFromService etReFieldValFromService;

    @Override
    public String getValById(Long id, Map<String, Object> vars) {
        EtReField etReField = etReFieldRepository.getFirstByIdAndDeletedFalse(id);
        if(etReField == null) {
            return null;
        }

        return etReFieldValFromService.getValById(etReField.getValFromId(), vars);
    }

    @Transactional
    @Override
    public EtReField addEtReField(EtReFieldDTO etReFieldDTO) {
        Date curDate = new Date();
        EtReField etReField;
        EtReFieldValFrom etReFieldValFrom;
        Boolean isEdit = !ObjectUtils.isEmpty(etReFieldDTO.getId());
        if(isEdit) {
            etReField = getFieldById(etReFieldDTO.getId());
            etReFieldValFrom = etReFieldValFromService.getFieldValFromById(etReField.getValFromId());
        } else {
            etReField = new EtReField();
            etReFieldValFrom = new EtReFieldValFrom();
            etReField.setCreatedBy(etReFieldDTO.getModifier());
            etReField.setCreateTime(curDate);
            etReField.setDeleted(false);

            etReFieldValFrom.setCreatedBy(etReFieldDTO.getModifier());
            etReFieldValFrom.setCreateTime(curDate);
            etReFieldValFrom.setDeleted(false);
        }

        BeanUtils.copyProperties(etReFieldDTO, etReField);
        BeanUtils.copyProperties(etReFieldDTO, etReFieldValFrom);
        if(isEdit) {
            etReFieldValFrom.setId(etReField.getValFromId());
        }

        etReField.setUpdatedBy(etReFieldDTO.getModifier());
        etReField.setUpdateTime(curDate);

        etReFieldValFrom.setUpdatedBy(etReFieldDTO.getModifier());
        etReFieldValFrom.setUpdateTime(curDate);

        EtReFieldValFrom updatedEtReFieldValFrom = etReFieldValFromService.save(etReFieldValFrom);
        etReField.setValFromId(updatedEtReFieldValFrom.getId());
        return etReFieldRepository.save(etReField);
    }

    @Override
    public EtReField getFieldById(Long id) {
        return etReFieldRepository.getFirstByIdAndDeletedFalse(id);
    }
}
