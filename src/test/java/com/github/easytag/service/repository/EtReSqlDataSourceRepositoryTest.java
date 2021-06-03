package com.github.easytag.service.repository;

import com.github.easytag.service.EasyTagServiceApplication;
import com.github.easytag.service.entity.EtReSqlDataSource;
import com.github.easytag.service.enums.DriverTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EasyTagServiceApplication.class)
public class EtReSqlDataSourceRepositoryTest {

    @Autowired
    private EtReSqlDataSourceRepository etReSqlDataSourceRepository;

    @Test
    public void testSave() {
        EtReSqlDataSource etReSqlDataSource = new EtReSqlDataSource();
        etReSqlDataSource.setName("testMysql");
        etReSqlDataSource.setDriverType(DriverTypeEnum.MYSQL.getDriverClassName());
        etReSqlDataSource.setUrl("jdbc:mysql://49.234.98.166:3306/tag_test?useUnicode=true&characterEncoding=utf8");
        etReSqlDataSource.setUserName("junjie");
        etReSqlDataSource.setPassword("wssjj123");
        etReSqlDataSource.setDeleted(false);
        etReSqlDataSource.setCreatedBy("828");
        etReSqlDataSource.setCreateTime(new Date());
        etReSqlDataSource.setUpdatedBy("828");
        etReSqlDataSource.setUpdateTime(new Date());
        EtReSqlDataSource save = etReSqlDataSourceRepository.save(etReSqlDataSource);
        System.out.println(save);
    }

    @Test
    public void testGetFirstByIdAndDeletedFalse() {
        EtReSqlDataSource firstByIdAnddeAndDeletedFalse = etReSqlDataSourceRepository.getFirstByIdAndDeletedFalse(1L);
        System.out.println(firstByIdAnddeAndDeletedFalse);
    }

}
