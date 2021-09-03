package com.github.easytag.service.component;

import com.github.easytag.service.dto.FieldExpressConditionDTO;
import com.github.easytag.service.dto.FieldExpressionContextDTO;

public interface FieldExpressionParser {
    /**
     * 解析对象，转成表达式和变量
     * @param fieldExpressConditionDTO
     * @return
     */
    FieldExpressionContextDTO parseExpression(FieldExpressConditionDTO fieldExpressConditionDTO);
}
