package com.github.easytag.service.dto;

import lombok.Data;

@Data
public class EtReFieldDTO {
    private Long id;
    private String name;
    private Integer dataType;
    private Integer fromType;
    private String fixVal;
    private Long sqlId;
    private String modifier;
}
