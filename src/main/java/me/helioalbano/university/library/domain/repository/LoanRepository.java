package me.helioalbano.university.library.domain.repository;

import java.util.Optional;

import me.helioalbano.university.library.domain.model.Loan;

public interface LoanRepository {
    public int countActiveLoansByUserId(String userId);

    public int countPastDueLoansByUserId(String userId);

    public Optional<Loan> save(Loan loan);

    public boolean existsByCopyCode(String copyCode);
}
