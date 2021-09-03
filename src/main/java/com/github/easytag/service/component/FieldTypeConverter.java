package com.github.easytag.service.component;

import com.github.easytag.service.dto.FieldLogicDataDTO;

/**
 * 类型转换器
 */
public interface FieldTypeConverter {

    /**
     * 转换数据类型
     * @param targetValue
     * @return
     */
    FieldLogicDataDTO convert(Object targetValue);
}
