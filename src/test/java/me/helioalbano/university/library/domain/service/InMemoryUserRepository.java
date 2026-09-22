package me.helioalbano.university.library.domain.service;

import java.util.Map;

import me.helioalbano.university.library.domain.model.Student;
import me.helioalbano.university.library.domain.model.Teacher;
import me.helioalbano.university.library.domain.model.User;
import me.helioalbano.university.library.domain.repository.UserRepository;
import me.helioalbano.university.shared.result.Result;

public class InMemoryUserRepository implements UserRepository {
    private Map<String, User> users = Map.of(
        "20090560022", new Student("20090560022"),
        "99990000001", new Teacher("99990000001")
    );

    @Override
    public Result<User> findById(String userId) {
        var user = users.get(userId);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.failure("User not found");
        }
    }

}
