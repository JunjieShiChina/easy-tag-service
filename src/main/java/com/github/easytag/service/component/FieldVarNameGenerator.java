package com.github.easytag.service.component;

import com.github.easytag.service.dto.FieldLogicDataDTO;

import java.util.Map;

public class FieldVarNameGenerator {
    // 生成变量名称
    public static String generateVarName(Map<String, FieldLogicDataDTO> variables) {
        int size = variables.size();
        return "var_" + size;
    }
}
