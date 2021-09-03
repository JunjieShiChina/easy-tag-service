package com.github.easytag.service.service;

import com.github.easytag.core.dto.express.ExpressBranch;
import com.github.easytag.core.dto.express.ExpressCondition;
import com.github.easytag.core.dto.express.ExpressItem;
import com.github.easytag.core.enums.DataTypeEnum;
import com.github.easytag.core.enums.LogicalOperatorEnum;
import com.github.easytag.service.EasyTagServiceApplication;
import com.github.easytag.service.dto.AddEtReTagDTO;
import com.github.easytag.service.dto.FieldExpressBranchDTO;
import com.github.easytag.service.dto.FieldExpressConditionDTO;
import com.github.easytag.service.dto.FieldExpressItemDTO;
import com.github.easytag.service.entity.EtReTag;
import com.github.easytag.service.enums.FieldDataTypeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EasyTagServiceApplication.class)
public class EtReTagServiceTest {

    @Autowired
    private EtReTagService etReTagService;

    @Test
    public void testAddEtReTag() {
        AddEtReTagDTO addEtReTagDTO = new AddEtReTagDTO();
        addEtReTagDTO.setName("测试标签");
        addEtReTagDTO.setModifier("828");
        FieldExpressConditionDTO expressCondition = new FieldExpressConditionDTO();
        FieldExpressBranchDTO expressBranch = new FieldExpressBranchDTO();
        FieldExpressItemDTO expressItem = new FieldExpressItemDTO();
        expressItem.setSourceData(DataTypeEnum.INTEGER.name());
        expressItem.setLogicalOperator(LogicalOperatorEnum.LESS.name());
        expressItem.setSourceData(2);
        expressItem.setTargetData(DataTypeEnum.INTEGER.name());
        expressItem.setTargetData(1);
        expressBranch.setFieldExpressItem(expressItem);
        expressCondition.setFieldExpressBranches(Arrays.asList(expressBranch));
        addEtReTagDTO.setFieldExpressConditionDTO(expressCondition);
        EtReTag etReTag = etReTagService.addEtReTag(addEtReTagDTO);
        Assert.assertNotNull(etReTag);
    }

    @Test
    public void testAddEtReTag2() {
        AddEtReTagDTO addEtReTagDTO = new AddEtReTagDTO();
        addEtReTagDTO.setName("测试标签");
        addEtReTagDTO.setModifier("828");
        FieldExpressConditionDTO expressCondition = new FieldExpressConditionDTO();
        FieldExpressBranchDTO expressBranch = new FieldExpressBranchDTO();
        FieldExpressItemDTO expressItem = new FieldExpressItemDTO();
        expressItem.setSourceDataType(FieldDataTypeEnum.FIELD.name());
        expressItem.setLogicalOperator(LogicalOperatorEnum.EQUALS.name());
        expressItem.setSourceData("1");
        expressItem.setTargetDataType(FieldDataTypeEnum.STRING.name());
        expressItem.setTargetData(">LDAP账号=junjie.shi/kLOR2mx2rP \\n\\n >db地址=http://dba.zmops.cc \\n\\n >db账密=shijunjie/XHd5KNvAmjcjkRqW \\n\\n >招师线上账号=17621401924/Yrl123456789 \\n\\n >波哥审批账号=18217371537/woai0520 \\n\\n >confluence密码=junjie.shi/Aa123456 \\n\\n >VPN服务器地址=https://vpn.zmaxis.com \\n\\n >1=VPN密码请使用公司电脑的开机密码 \\n\\n >guide=http://guide.zmops.cc/tech/#/link \\n\\n >邮箱账密=junjie.shi@zhangmen.com/Wssjj12345678 \\n\\n >贺老板开机账密=Hesheng0523 \\n\\n >修改老师角色(users_groups)=https://www.zmlearn.com/api/teachers-mp/api/writeBoard/modifyTeaClient?userId&role(teacher)(POST请求) \\n\\n >lastDay=5.8 \\n\\n ");
        expressBranch.setFieldExpressItem(expressItem);
        expressCondition.setFieldExpressBranches(Arrays.asList(expressBranch));
        addEtReTagDTO.setFieldExpressConditionDTO(expressCondition);
        EtReTag etReTag = etReTagService.addEtReTag(addEtReTagDTO);
        Assert.assertNotNull(etReTag);

    }

    @Test
    public void testAddEtReTag3() {
        AddEtReTagDTO addEtReTagDTO = new AddEtReTagDTO();
        addEtReTagDTO.setName("测试标签");
        addEtReTagDTO.setModifier("828");
        FieldExpressConditionDTO expressCondition = new FieldExpressConditionDTO();
        FieldExpressBranchDTO expressBranch = new FieldExpressBranchDTO();
        FieldExpressItemDTO expressItem = new FieldExpressItemDTO();
        expressItem.setSourceDataType(FieldDataTypeEnum.FIELD.name());
        expressItem.setLogicalOperator(LogicalOperatorEnum.EQUALS.name());
        expressItem.setSourceData("1");
        expressItem.setTargetDataType(FieldDataTypeEnum.STRING.name());
        expressItem.setTargetData(">LDAP账号=junjie.shi/kLOR2mx2rP  \\n\\n >db地址=http://dba.zmops.cc \\n\\n >db账密=shijunjie/XHd5KNvAmjcjkRqW \\n\\n >招师线上账号=17621401924/Yrl123456789 \\n\\n >波哥审批账号=18217371537/woai0520 \\n\\n >confluence密码=junjie.shi/Aa123456 \\n\\n >VPN服务器地址=https://vpn.zmaxis.com \\n\\n >1=VPN密码请使用公司电脑的开机密码 \\n\\n >guide=http://guide.zmops.cc/tech/#/link \\n\\n >邮箱账密=junjie.shi@zhangmen.com/Wssjj12345678 \\n\\n >贺老板开机账密=Hesheng0523 \\n\\n >修改老师角色(users_groups)=https://www.zmlearn.com/api/teachers-mp/api/writeBoard/modifyTeaClient?userId&role(teacher)(POST请求) \\n\\n >lastDay=5.8 \\n\\n ");
        expressBranch.setFieldExpressItem(expressItem);
        expressCondition.setFieldExpressBranches(Arrays.asList(expressBranch));
        addEtReTagDTO.setFieldExpressConditionDTO(expressCondition);
        EtReTag etReTag = etReTagService.addEtReTag(addEtReTagDTO);
        Assert.assertNotNull(etReTag);
    }

    @Test
    public void testExec() {
        Map<String, Object> vars = new HashMap<>();
        vars.put("id", -1);
        boolean exec = etReTagService.exec(1L, vars);
        System.out.println(exec);
        exec = etReTagService.exec(2L, vars);
        System.out.println(exec);
    }


}
