package com.books.app.services;

import com.books.app.models.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}