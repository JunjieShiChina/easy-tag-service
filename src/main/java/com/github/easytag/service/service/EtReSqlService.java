package com.github.easytag.service.service;

import com.github.easytag.service.dto.ReSqlDTO;
import com.github.easytag.service.entity.EtReSql;

import java.util.Map;

public interface EtReSqlService {

    String getValFromSql(Long etReSqlId, Map<String,Object> vars);

    /**
     * 保存执行sql
     * @param reSqlDTO
     * @return
     */
    EtReSql saveSql(ReSqlDTO reSqlDTO);

    /**
     * 通过id查询数据
     * @param etReSqlId
     * @return
     */
    EtReSql getById(Long etReSqlId);

}
