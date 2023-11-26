package com.sbs.repositories;

import com.sbs.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User addUser(User user);
    void removeUser(Long id);
    List<User> getUsers();
    Optional<User> findById(Long id);
}
