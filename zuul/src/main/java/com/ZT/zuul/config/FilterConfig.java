package com.ZT.zuul.config;

import com.ZT.zuul.filter.IPFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public IPFilter ipFilter(){
        return new IPFilter();
    }

}
