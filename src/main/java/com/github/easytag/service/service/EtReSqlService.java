package com.github.easytag.service.service;

import java.util.Map;

public interface EtReSqlService {

    String getValFromSql(Long etReSqlId, Map<String,Object> vars);

}
