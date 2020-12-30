package com.github.easytag.service.repository;

import com.github.easytag.service.EasyTagServiceApplication;
import com.github.easytag.service.entity.EtReSql;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EasyTagServiceApplication.class)
public class EtReSqlRepositoryTest {

    @Autowired
    private EtReSqlRepository etReSqlRepository;

    @Test
    public void testSave() {
        EtReSql etReSql = new EtReSql();
        etReSql.setName("postCode");
        etReSql.setDataSourceId(1L);
        etReSql.setExeSql("select postCode from t_teacher_post_record where id=#{id}");
        etReSql.setDeleted(false);
        etReSql.setCreateTime(new Date());
        etReSql.setUpdateTime(new Date());
        etReSql.setCreatedBy("828");
        etReSql.setUpdatedBy("828");
        EtReSql save = etReSqlRepository.save(etReSql);
        System.out.println(save);
    }

}
