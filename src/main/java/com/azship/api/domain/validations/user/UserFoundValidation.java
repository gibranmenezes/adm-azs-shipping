package com.azship.api.domain.validations.user;

import com.azship.api.infra.exception.ValidationException;
import com.azship.api.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFoundValidation implements UserDataValidation{

    private final UserRepository repository;
    @Override
    public void validate(String userID) {
       if (repository.existsById(userID)){
            throw new ValidationException("User not found");
        }

    }
}
