package com.github.easytag.service.service;

import com.github.easytag.service.dto.EtReFieldDTO;
import com.github.easytag.service.entity.EtReField;

import java.util.Map;

public interface EtReFieldService {

    String getValById(Long id, Map<String, Object> vars);

    EtReField addEtReField(EtReFieldDTO etReFieldDTO);

    EtReField getFieldById(Long id);
}
