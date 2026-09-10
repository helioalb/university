package me.helioalbano.university.library.domain.service;

import java.util.Objects;

import me.helioalbano.university.library.domain.model.Copy;
import me.helioalbano.university.library.domain.model.Loan;
import me.helioalbano.university.library.domain.model.User;
import me.helioalbano.university.library.domain.repository.CopyRepository;
import me.helioalbano.university.library.domain.repository.LoanRepository;
import me.helioalbano.university.library.domain.repository.UserRepository;

public class LoanService {
    private final UserRepository userRepository;
    private final CopyRepository copyRepository;
    private final LoanRepository loanRepository;

    public LoanService(
        final UserRepository userRepository,
        final CopyRepository copyRepository,
        final LoanRepository loanRepository
    ) {
        this.userRepository = Objects.requireNonNull(userRepository, "userRepository não pode ser nulo");
        this.copyRepository = Objects.requireNonNull(copyRepository, "copyRepository não pode ser nulo");
        this.loanRepository = Objects.requireNonNull(loanRepository, "loanRepository não pode ser nulo");
    }

    public Loan createLoan(final String userId, final String copyCode) {
        Objects.requireNonNull(userId, "userId não pode ser nulo");
        Objects.requireNonNull(copyCode, "copyCode não pode ser nulo");

        if (loanRepository.countPastDueLoansByUserId(userId) > 0) {
            throw new IllegalStateException("Usuário possui empréstimos em atraso");
        }

        final User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        if (loanRepository.countActiveLoansByUserId(userId) >= user.getMaxActiveLoans()) {
            throw new IllegalStateException("Usuário atingiu o número máximo de empréstimos ativos");
        }

        if (loanRepository.existsByCopyCode(copyCode)) {
            throw new IllegalStateException("Exemplar já está emprestado");
        }

        final Copy copy = copyRepository.findByCode(copyCode)
            .orElseThrow(() -> new IllegalArgumentException("Exemplar não encontrado"));

        final Loan loan = new Loan(user, copy);

        return loanRepository.save(loan)
            .orElseThrow(() -> new IllegalStateException("Não foi possível salvar o empréstimo"));
    }
}
