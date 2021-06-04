package com.github.easytag.service.service;

import com.github.easytag.service.EasyTagServiceApplication;
import com.github.easytag.service.dto.ReSqlDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EasyTagServiceApplication.class)
public class EtReSqlServiceTest {

    @Autowired
    private EtReSqlService etReSqlService;

    @Test
    public void testGetValFromSql() {
        Map<String,Object> vars = new HashMap<>();
        vars.put("id", 2);
        String valFromSql = etReSqlService.getValFromSql(1L, vars);
        System.out.println(valFromSql);
    }

    @Test
    public void testSaveSql() {
        ReSqlDTO reSqlDTO = new ReSqlDTO();
        reSqlDTO.setDataSourceId(1L);
        reSqlDTO.setModifier("828");
        reSqlDTO.setName("测试sql");
        reSqlDTO.setExeSql("select note_content from t_note where id = -1");
        etReSqlService.saveSql(reSqlDTO);
    }

}
