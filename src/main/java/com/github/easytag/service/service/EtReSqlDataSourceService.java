package com.github.easytag.service.service;

import com.github.easytag.service.dto.DataSourceDTO;
import com.github.easytag.service.entity.EtReSqlDataSource;

public interface EtReSqlDataSourceService {

    EtReSqlDataSource getById(Long etReSqlDataSourceId);

    EtReSqlDataSource saveDataSource(DataSourceDTO dataSource);
}
