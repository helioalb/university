package me.helioalbano.university.library.domain.repository;

import me.helioalbano.university.library.domain.model.User;
import me.helioalbano.university.shared.result.Result;

public interface UserRepository {
    public Result<User> findById(final String userId);
}
