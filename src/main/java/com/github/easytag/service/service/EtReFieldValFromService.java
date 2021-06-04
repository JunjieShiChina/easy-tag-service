package com.github.easytag.service.service;

import com.github.easytag.service.entity.EtReFieldValFrom;

import java.util.Map;

public interface EtReFieldValFromService {
    String getValById(Long valFromId, Map<String, Object> vars);

    EtReFieldValFrom getFieldValFromById(Long id);

    EtReFieldValFrom save(EtReFieldValFrom etReFieldValFrom);
}
