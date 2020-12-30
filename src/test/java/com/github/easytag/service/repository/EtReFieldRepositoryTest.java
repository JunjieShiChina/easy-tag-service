package com.github.easytag.service.repository;

import com.github.easytag.core.enums.DataTypeEnum;
import com.github.easytag.service.EasyTagServiceApplication;
import com.github.easytag.service.entity.EtReField;
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
public class EtReFieldRepositoryTest {

    @Autowired
    private EtReFieldRepository etReFieldRepository;

    @Test
    public void testSave() {
        EtReField etReField = new EtReField();
        etReField.setName("岗位编号");
        etReField.setValFromId(1L);
        etReField.setDataType(DataTypeEnum.STRING.getCode());
        etReField.setDeleted(false);
        etReField.setCreateTime(new Date());
        etReField.setUpdateTime(new Date());
        etReField.setCreatedBy("828");
        etReField.setUpdatedBy("828");
        etReFieldRepository.save(etReField);
    }

}
