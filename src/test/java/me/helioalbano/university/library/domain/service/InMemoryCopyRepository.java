package me.helioalbano.university.library.domain.service;

import java.util.Map;

import me.helioalbano.university.library.domain.model.Book;
import me.helioalbano.university.library.domain.model.Copy;
import me.helioalbano.university.library.domain.repository.CopyRepository;
import me.helioalbano.university.shared.result.Result;

public class InMemoryCopyRepository implements CopyRepository {

    private final Map<String, Copy> copies = Map.of(
        "CC-001-1", new Copy(
            "CC-001-1",
            new Book(
                "Implementando o Domain-Driven Design",
                "Vaughn Vernon"
            ),
            true
        ),
        "CC-002-1", new Copy(
            "CC-002-1",
            new Book(
                "Código Limpo : habilidades práticas do agile",
                "Robert C. Martin"
            ),
            true
        )
    );

    @Override
    public Result<Copy> findByCode(String copyCode) {
        var copy = copies.get(copyCode);
        if (copy != null) {
            return Result.success(copy);
        } else {
            return Result.failure("Copy not found");
        }
    }
}
