package com.simulador.simulador_bolsa_backend.domain.user.service;

import com.simulador.simulador_bolsa_backend.domain.user.model.User;
import com.simulador.simulador_bolsa_backend.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

public class UserDomainService {

    private final UserRepository userRepository;

    public UserDomainService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean canInvest(User user, double amount) {
        return user.hasSufficientBalance(amount) && !user.isSuspended();
    }
}