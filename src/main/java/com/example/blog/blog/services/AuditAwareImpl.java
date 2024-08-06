package com.example.blog.blog.services;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditAwareImpl implements AuditorAware<String>{

    @Override
    public Optional<String> getCurrentAuditor() {
        // TODO Auto-generated method stub
        return Optional.of("Huzaifa Khan");
    }

}
