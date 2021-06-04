package com.github.easytag.service.service.impl;

import com.github.easytag.service.dto.DataSourceDTO;
import com.github.easytag.service.entity.EtReSqlDataSource;
import com.github.easytag.service.repository.EtReSqlDataSourceRepository;
import com.github.easytag.service.service.EtReSqlDataSourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;

@Service
public class EtReSqlDataSourceServiceImpl implements EtReSqlDataSourceService {

    @Autowired
    private EtReSqlDataSourceRepository etReSqlDataSourceRepository;

    @Override
    public EtReSqlDataSource getById(Long etReSqlDataSourceId) {
        return etReSqlDataSourceRepository.getFirstByIdAndDeletedFalse(etReSqlDataSourceId);
    }

    /**
     * 保存数据源
     * @param dataSource 数据源
     * @return
     */
    @Override
    public EtReSqlDataSource saveDataSource(DataSourceDTO dataSource) {
        Date curDate = new Date();
        EtReSqlDataSource etReSqlDataSource;
        if(!ObjectUtils.isEmpty(dataSource.getId())) {
            etReSqlDataSource = getById(dataSource.getId());
        } else {
            etReSqlDataSource = new EtReSqlDataSource();
            etReSqlDataSource.setCreatedBy(dataSource.getModifier());
            etReSqlDataSource.setCreateTime(curDate);
            etReSqlDataSource.setDeleted(false);
        }
        BeanUtils.copyProperties(dataSource, etReSqlDataSource);
        etReSqlDataSource.setUpdatedBy(dataSource.getModifier());
        etReSqlDataSource.setUpdateTime(curDate);
        return etReSqlDataSourceRepository.save(etReSqlDataSource);
    }
}
