package com.atul.prod_ready_features.configs;

import com.atul.prod_ready_features.auditing.AuditorImplementation;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorImplementation")
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    @Bean(name = "auditorImplementation")
    public AuditorAware<String> getAuditAwareImplementation(){
           return new AuditorImplementation();
    }
}
