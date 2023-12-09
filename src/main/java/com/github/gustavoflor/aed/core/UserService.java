package com.github.gustavoflor.aed.core;

import java.util.Optional;

public class UserService {

    public Optional<User> findById(final Long id) {
        return Optional.empty();
    }

    public User findByIdOrElseThrowNotFoundException(final Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(false));
    }

    public User findByIdOrElseThrowNotFoundExceptionWithTrace(final Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(true));
    }

}
