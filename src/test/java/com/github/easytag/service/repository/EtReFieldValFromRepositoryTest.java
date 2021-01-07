package com.github.easytag.service.repository;

import com.github.easytag.service.EasyTagServiceApplication;
import com.github.easytag.service.entity.EtReFieldValFrom;
import com.github.easytag.service.enums.FromTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EasyTagServiceApplication.class)
public class EtReFieldValFromRepositoryTest {

    @Autowired
    private EtReFieldValFromRepository etReFieldValFromRepository;

    @Test
    public void testSave() {
        EtReFieldValFrom etReFieldValFrom = new EtReFieldValFrom();
        etReFieldValFrom.setFromType(FromTypeEnum.SQL_VALUE.getCode());
        etReFieldValFrom.setSqlId(1L);
        etReFieldValFrom.setDeleted(false);
        etReFieldValFrom.setCreateTime(new Date());
        etReFieldValFrom.setUpdateTime(new Date());
        etReFieldValFrom.setCreatedBy("828");
        etReFieldValFrom.setUpdatedBy("828");
        etReFieldValFromRepository.save(etReFieldValFrom);
    }

    @Test
    public void testSave2() {
        EtReFieldValFrom etReFieldValFrom = new EtReFieldValFrom();
        etReFieldValFrom.setFromType(FromTypeEnum.FIXED_VALUE.getCode());
        etReFieldValFrom.setFixVal("testV");
        etReFieldValFrom.setDeleted(false);
        etReFieldValFrom.setCreateTime(new Date());
        etReFieldValFrom.setUpdateTime(new Date());
        etReFieldValFrom.setCreatedBy("828");
        etReFieldValFrom.setUpdatedBy("828");
        etReFieldValFromRepository.save(etReFieldValFrom);
    }

}
