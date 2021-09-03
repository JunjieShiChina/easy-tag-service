package com.github.easytag.service.service;

import com.github.easytag.service.dto.AddEtReTagDTO;
import com.github.easytag.service.entity.EtReTag;

import java.util.Map;

public interface EtReTagService {

    /**
     * 保存标签
     * @param addEtReTagDTO 标签相关信息
     * @return 标签
     */
    EtReTag addEtReTag(AddEtReTagDTO addEtReTagDTO);

    /**
     * 执行标签
     * @param tagId 标签id
     * @param vars 传入的变量
     * @return
     */
    boolean exec(Long tagId, Map<String, Object> vars);

}
