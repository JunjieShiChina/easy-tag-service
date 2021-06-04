package com.github.easytag.service.dto;

import lombok.Data;

@Data
public class ReSqlDTO {
    private Long id;
    private String name;
    private String exeSql;
    private Long dataSourceId;
    private String modifier;
}
