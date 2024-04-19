package com.azship.api.infra.repository;

import com.azship.api.domain.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findUserById(String id);
}
