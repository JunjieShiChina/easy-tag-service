package com.github.easytag.service.dto;

import lombok.Data;

@Data
public class AddEtReTagDTO {

    /**
     * 标签名
     */
    private String name;

    /**
     * 操作人
     */
    private String modifier;

    /**
     * 标签逻辑数据
     */
    private FieldExpressConditionDTO fieldExpressConditionDTO;

}
