package com.github.easytag.service.service;

import com.github.easytag.service.EasyTagServiceApplication;
import com.github.easytag.service.dto.DataSourceDTO;
import com.github.easytag.service.entity.EtReSqlDataSource;
import com.github.easytag.service.enums.DriverTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EasyTagServiceApplication.class)
public class EtReSqlDataSourceServiceTest {

    @Autowired
    private EtReSqlDataSourceService etReSqlDataSourceService;

    @Test
    public void testSaveDataSource() {
        DataSourceDTO dataSourceDTO = new DataSourceDTO();
        dataSourceDTO.setId(1L);
        dataSourceDTO.setName("testMysql");
        dataSourceDTO.setDriverType(DriverTypeEnum.MYSQL.getDriverClassName());
        dataSourceDTO.setUrl("jdbc:mysql://49.234.98.166:3306/tag_test?useUnicode=true&characterEncoding=utf8");
        dataSourceDTO.setUserName("junjie");
        dataSourceDTO.setPassword("wssjj123");
        dataSourceDTO.setModifier("828");
        EtReSqlDataSource save = etReSqlDataSourceService.saveDataSource(dataSourceDTO);
        System.out.println(save);
    }

}
