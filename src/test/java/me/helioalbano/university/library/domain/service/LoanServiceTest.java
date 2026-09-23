package me.helioalbano.university.library.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.helioalbano.university.library.domain.repository.LoanRepository;

public class LoanServiceTest {
    @Test
    @DisplayName("should create a loan for an existing user and copy")
    public void shouldCreateALoanForAnExistingUserAndCopy() {
        var loanRepository = new InMemoryLoanRepository();
        var loanService = createLoanServiceWithFixedClock(loanRepository);

        var userId = "20090560022";
        var copyCode = "CC-001-1";

        var loanResult = loanService.createLoan(userId, copyCode);

        assertTrue(loanResult.isSuccess());

        var loan = loanResult.getValue();
        var expectedId = "2026-01-01-20090560022-CC-001-1";
        assertEquals(expectedId, loan.getId());

        var persistedLoanResult = loanRepository.findById(expectedId);

        assertTrue(persistedLoanResult.isSuccess());
        assertEquals(loan, persistedLoanResult.getValue());
    }

    private LoanService createLoanServiceWithFixedClock(LoanRepository loanRepository) {
        var userRepository = new InMemoryUserRepository();
        var copyRepository = new InMemoryCopyRepository();

        var fixedClock = Clock.fixed(
            Instant.parse( "2026-01-01T08:00:00Z"),
            ZoneOffset.UTC
        );

        return new LoanService(
            userRepository,
            copyRepository,
            loanRepository,
            fixedClock
        );
    }
}
