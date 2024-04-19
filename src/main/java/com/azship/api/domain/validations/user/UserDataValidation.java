package com.azship.api.domain.validations.user;

import jakarta.xml.bind.ValidationException;

public interface UserDataValidation {

    void validate(String userID) throws ValidationException;
}
