package me.helioalbano.university.library.domain.service;

import java.time.Clock;

import me.helioalbano.university.library.domain.model.Loan;
import me.helioalbano.university.library.domain.repository.CopyRepository;
import me.helioalbano.university.library.domain.repository.LoanRepository;
import me.helioalbano.university.library.domain.repository.UserRepository;
import me.helioalbano.university.shared.result.Result;

public class LoanService {
    private final UserRepository userRepository;
    private final CopyRepository copyRepository;
    private final LoanRepository loanRepository;
    private final Clock clock;

    public LoanService(
        final UserRepository userRepository,
        final CopyRepository copyRepository,
        final LoanRepository loanRepository
    ) {
        this(
            userRepository,
            copyRepository,
            loanRepository,
            Clock.systemDefaultZone()
        );
    }

    public LoanService(
        final UserRepository userRepository,
        final CopyRepository copyRepository,
        final LoanRepository loanRepository,
        final Clock clock
    ) {
        this.userRepository = userRepository;
        this.copyRepository = copyRepository;
        this.loanRepository = loanRepository;
        this.clock = clock;
    }

    public Result<Loan> createLoan(final String userId, final String copyCode) {
        var userResult = userRepository.findById(userId);
        if (!userResult.isSuccess()) {
            return Result.failure(userResult.getError());
        }
        var user = userResult.getValue();

        var copyResult = copyRepository.findByCode(copyCode);
        if (!copyResult.isSuccess()) {
            return Result.failure(copyResult.getError());
        }
        var copy = copyResult.getValue();

        var activeLoansResult = loanRepository.countActiveLoansByUserId(userId);
        if (!activeLoansResult.isSuccess()) {
            return Result.failure(activeLoansResult.getError());
        }

        if (user.hasReachedLoanLimit(activeLoansResult.getValue())) {
            return Result.failure("O usuário atingiu o limite de empréstimos ativos.");
        }

        var loanResult = Loan.create(user, copy, clock);

        if (!loanResult.isSuccess()) {
            return Result.failure(loanResult.getError());
        }

        var saveResult = loanRepository.save(loanResult.getValue());

        if (!saveResult.isSuccess()) {
            return Result.failure(saveResult.getError());
        }

        return Result.success(saveResult.getValue());
    }
}
