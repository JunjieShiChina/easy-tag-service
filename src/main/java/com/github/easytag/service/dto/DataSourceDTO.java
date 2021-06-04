package com.github.easytag.service.dto;

import lombok.Data;

@Data
public class DataSourceDTO {
    private Long id;
    private String name;
    private String url;
    private String driverType;
    private String userName;
    private String password;
    private String modifier;
}
