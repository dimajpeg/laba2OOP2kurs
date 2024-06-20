package com.java.test.project.services;

import com.java.test.project.models.User;

public interface UserService {
    void saveUser(User user);
    User findUserById(Long id); // Adjusted to Long based on previous corrections
    void updateUser(User user);
    void deleteUser(User user);
}
