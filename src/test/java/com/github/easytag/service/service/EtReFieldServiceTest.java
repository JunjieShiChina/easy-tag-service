package com.github.easytag.service.service;

import com.github.easytag.service.EasyTagServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EasyTagServiceApplication.class)
public class EtReFieldServiceTest {

    @Autowired
    private EtReFieldService etReFieldService;

    @Test
    public void testGetValById() {
        Map<String,Object> vars = new HashMap<>();
        vars.put("id", 2);
        String val = etReFieldService.getValById(1L, vars);
        System.out.println(val);
    }

    @Test
    public void testGetValById2() {
        Map<String,Object> vars = new HashMap<>();
//        vars.put("id", 2);
        String val = etReFieldService.getValById(2L, vars);
        System.out.println(val);
    }

}
