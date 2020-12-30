package com.github.easytag.service.service.impl;

import com.github.easytag.service.entity.EtReSqlDataSource;
import com.github.easytag.service.repository.EtReSqlDataSourceRepository;
import com.github.easytag.service.service.EtReSqlDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtReSqlDataSourceServiceImpl implements EtReSqlDataSourceService {

    @Autowired
    private EtReSqlDataSourceRepository etReSqlDataSourceRepository;

    @Override
    public EtReSqlDataSource getById(Long etReSqlDataSourceId) {
        return etReSqlDataSourceRepository.getFirstByIdAndDeletedFalse(etReSqlDataSourceId);
    }
}
