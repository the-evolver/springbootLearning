package com.atul.prod_ready_features.auditing;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorImplementation implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // in future use spring security to get the current user ...
        return Optional.of("Atul sharma");
    }
}
