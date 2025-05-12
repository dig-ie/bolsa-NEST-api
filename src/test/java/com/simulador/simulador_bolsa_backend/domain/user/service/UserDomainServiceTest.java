package com.simulador.simulador_bolsa_backend.domain.user.service;

import com.simulador.simulador_bolsa_backend.domain.user.repository.UserRepository;
import com.simulador.simulador_bolsa_backend.domain.user.model.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class UserDomainServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserDomainService userDomainService;

    @Test
    void canInvest_ShouldReturnTrue_WhenUserHasBalanceAndIsNotSuspended() {
        User user = User.createForTest(1000.0, null);
        boolean result = userDomainService.canInvest(user, 500.0);
        assertTrue(result);
    }

    @Test
    void canInvest_ShouldReturnFalse_WhenUserIsSuspended() {
        User user = User.createForTest(
                1000.0,
                LocalDateTime.now().plusDays(1)
        );

        boolean result = userDomainService.canInvest(user, 500.0);

        assertFalse(result);
    }

    @Test
    void canInvest_ShouldReturnFalse_WhenInsufficientBalance() {
        User user = User.createForTest(
                300.0,
                null
        );

        boolean result = userDomainService.canInvest(user, 500.0);

        assertFalse(result);
    }
}