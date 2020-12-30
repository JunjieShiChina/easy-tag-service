package com.github.easytag.service.service.impl;

import com.github.easytag.service.entity.EtReFieldValFrom;
import com.github.easytag.service.enums.FromTypeEnum;
import com.github.easytag.service.repository.EtReFieldValFromRepository;
import com.github.easytag.service.service.EtReFieldValFromService;
import com.github.easytag.service.service.EtReSqlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class EtReFieldValFromServiceImpl implements EtReFieldValFromService {

    @Autowired
    private EtReFieldValFromRepository etReFieldValFromRepository;

    @Autowired
    private EtReSqlService etReSqlService;

    @Override
    public String getValById(Long valFromId, Map<String, Object> vars) {
        EtReFieldValFrom etReFieldValFrom = etReFieldValFromRepository.getFirstByIdAndDeletedFalse(valFromId);
        if(etReFieldValFrom == null) {
            return null;
        }
        Integer fromType = etReFieldValFrom.getFromType();
        if(FromTypeEnum.FIXED_VALUE.getCode().equals(fromType)) {
            return etReFieldValFrom.getFixVal();
        }
        if(FromTypeEnum.SQL_VALUE.getCode().equals(fromType)) {
            return etReSqlService.getValFromSql(etReFieldValFrom.getSqlId(), vars);
        }

        return null;
    }
}
