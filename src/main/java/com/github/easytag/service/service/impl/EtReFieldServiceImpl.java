package com.github.easytag.service.service.impl;

import com.github.easytag.service.entity.EtReField;
import com.github.easytag.service.entity.EtReFieldValFrom;
import com.github.easytag.service.repository.EtReFieldRepository;
import com.github.easytag.service.service.EtReFieldService;
import com.github.easytag.service.service.EtReFieldValFromService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
