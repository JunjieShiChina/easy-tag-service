package com.github.easytag.service.service.impl;

import com.github.easytag.service.entity.EtReSql;
import com.github.easytag.service.entity.EtReSqlDataSource;
import com.github.easytag.service.repository.EtReSqlRepository;
import com.github.easytag.service.resolver.PlaceholderResolver;
import com.github.easytag.service.service.EtReSqlDataSourceService;
import com.github.easytag.service.service.EtReSqlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Map;

@Service
@Slf4j
public class EtReSqlServiceImpl implements EtReSqlService {

    @Autowired
    private EtReSqlDataSourceService etReSqlDataSourceService;

    @Autowired
    private EtReSqlRepository etReSqlRepository;

    @Override
    public String getValFromSql(Long etReSqlId, Map<String, Object> vars) {
        EtReSql etReSql = etReSqlRepository.getFirstByIdAndDeletedFalse(etReSqlId);
        if (etReSql == null) {
            return null;
        }

        EtReSqlDataSource etReSqlDataSource = etReSqlDataSourceService.getById(etReSql.getDataSourceId());
        if (etReSqlDataSource == null) {
            return null;
        }

        return execute(etReSql, etReSqlDataSource, vars);
    }

    private String execute(EtReSql etReSql, EtReSqlDataSource etReSqlDataSource, Map<String, Object> vars) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(etReSqlDataSource.getDriverType());
            connection = DriverManager.getConnection(etReSqlDataSource.getUrl(), etReSqlDataSource.getUserName(), etReSqlDataSource.getPassword());
            String executeSql = PlaceholderResolver.getDefaultResolver().resolveByMap(etReSql.getExeSql(), vars);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(executeSql);
            while(resultSet.next()) {
                return resultSet.getString(1);
            }
            return null;
        } catch (Exception e) {
            log.error("execute sql error, e:{}", e);
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                log.error("execute sql finally error:{}", e);
            }
        }
        return null;
    }
}
