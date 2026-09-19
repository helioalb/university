package me.helioalbano.university.library.domain.repository;

import me.helioalbano.university.library.domain.model.Loan;
import me.helioalbano.university.shared.result.Result;

public interface LoanRepository {
    public Result<Loan> findById(String loanId);
    public Result<Loan> save(Loan loan);
}
