package me.helioalbano.university.library.domain.service;

import java.util.HashMap;
import java.util.Map;

import me.helioalbano.university.library.domain.model.Loan;
import me.helioalbano.university.library.domain.repository.LoanRepository;
import me.helioalbano.university.shared.result.Result;

public class InMemoryLoanRepository implements LoanRepository {
    private final Map<String, Loan> loans = new HashMap<>();

    @Override
    public Result<Loan> save(Loan loan) {
        loans.put(loan.getId(), loan);
        return Result.success(loan);
    }
}
