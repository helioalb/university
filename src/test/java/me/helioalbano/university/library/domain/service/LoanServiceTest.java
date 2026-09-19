package me.helioalbano.university.library.domain.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoanServiceTest {
    @Test
    @DisplayName("should create a loan for an existing user and copy")
    public void shouldCreateALoanForAnExistingUserAndCopy() {
        var userRepository = new InMemoryUserRepository();
        var copyRepository = new InMemoryCopyRepository();
        var loanRepository = new InMemoryLoanRepository();

        var fixedClock = Clock.fixed(
            Instant.parse( "2026-01-01T08:00:00Z"),
            ZoneOffset.UTC
        );

        var loanService = new LoanService(
            userRepository,
            copyRepository,
            loanRepository,
            fixedClock
        );

        var userId = "20090560022";
        var copyCode = "CC-001-1";

        var loanResult = loanService.createLoan(userId, copyCode);

        assertTrue(loanResult.isSuccess());
        assertTrue(loanResult.getValue().getId().equals("2026-01-01-08-00-00-20090560022-CC-001-1"));
    }

}
