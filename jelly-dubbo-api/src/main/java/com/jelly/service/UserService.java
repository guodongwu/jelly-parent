package com.jelly.service;

import com.jelly.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers(User user);
}
