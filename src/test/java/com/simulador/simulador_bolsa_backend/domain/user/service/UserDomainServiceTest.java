package com.simulador.simulador_bolsa_backend.domain.user.service;

import com.simulador.simulador_bolsa_backend.domain.user.repository.UserRepository;
import com.simulador.simulador_bolsa_backend.domain.user.model.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
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
        User user = User.createForTest(new BigDecimal("1000.00"), null);
        boolean result = userDomainService.canInvest(user, new BigDecimal("500.00"));
        assertTrue(result);
    }

    @Test
    void canInvest_ShouldReturnFalse_WhenUserIsSuspended() {
        User user = User.createForTest(
                new BigDecimal("1000.00"),
                LocalDateTime.now().plusDays(1)
        );

        boolean result = userDomainService.canInvest(user, new BigDecimal("500.00"));

        assertFalse(result);
    }

    @Test
    void canInvest_ShouldReturnFalse_WhenInsufficientBalance() {
        User user = User.createForTest(
                new BigDecimal("300.00"),
                null
        );

        boolean result = userDomainService.canInvest(user, new BigDecimal("500.00"));

        assertFalse(result);
    }

    @Test
    void canInvest_ShouldReturnFalse_WhenAmountIsZero() {
        User user = User.createForTest(
                new BigDecimal("1000.00"),
                null
        );

        boolean result = userDomainService.canInvest(user, BigDecimal.ZERO);

        assertFalse(result);
    }

    @Test
    void canInvest_ShouldReturnFalse_WhenAmountIsNegative() {
        User user = User.createForTest(
                new BigDecimal("1000.00"),
                null
        );

        boolean result = userDomainService.canInvest(user, new BigDecimal("-500.00"));

        assertFalse(result);
    }
}