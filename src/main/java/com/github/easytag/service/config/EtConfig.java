package com.github.easytag.service.config;

import com.github.easytag.core.resolver.ExpressionParser;
import com.github.easytag.core.resolver.impl.DefaultExpressionParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EtConfig {

    @Bean
    public ExpressionParser defaultExpressionParser () {
        return DefaultExpressionParser.getInstance();
    }

}
