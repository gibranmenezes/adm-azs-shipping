package com.azship.api.service.imp;

import com.azship.api.domain.user.User;
import com.azship.api.infra.repository.UserRepository;
import com.azship.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository repository;
    @Override
    public List<User> getAll() {
       return repository.findAll();
    }
}
