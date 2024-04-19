package com.azship.api.service;

import com.azship.api.domain.user.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
}
