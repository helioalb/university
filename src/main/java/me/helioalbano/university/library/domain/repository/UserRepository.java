package me.helioalbano.university.library.domain.repository;

import java.util.Optional;

import me.helioalbano.university.library.domain.model.User;

public interface UserRepository {
    public Optional<User> findById(final String userId);
}
