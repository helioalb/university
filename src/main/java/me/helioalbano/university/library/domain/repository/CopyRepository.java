package me.helioalbano.university.library.domain.repository;

import java.util.Optional;

import me.helioalbano.university.library.domain.model.Copy;

public interface CopyRepository {
    public Optional<Copy> findByCode(final String copyCode);
}
