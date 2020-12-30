package com.github.easytag.service.repository;

import com.github.easytag.service.EasyTagServiceApplication;
import com.github.easytag.service.entity.EtReSqlDataSource;
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

    }

    @Test
    public void testGetFirstByIdAndDeletedFalse() {
        EtReSqlDataSource firstByIdAnddeAndDeletedFalse = etReSqlDataSourceRepository.getFirstByIdAndDeletedFalse(1L);
        System.out.println(firstByIdAnddeAndDeletedFalse);
    }

}
