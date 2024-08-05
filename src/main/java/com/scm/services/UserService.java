package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entities.User;

public interface UserService {

    User saveUser(User user);

    Optional<User> getUserById(String id);

    Optional<User> updateUser(User user);

    void deleteUSer(String id);

    boolean isUserExist(String userId);

    boolean isUSerExistByEmail(String email);

    List<User> getAllUsers();
}
