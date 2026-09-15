package me.helioalbano.university.library.domain.repository;

import me.helioalbano.university.library.domain.model.Copy;
import me.helioalbano.university.shared.result.Result;

public interface CopyRepository {
    public Result<Copy> findByCode(final String copyCode);
}
