package com.github.gustavoflor.aed.core;

public record Mail(String email, String subject) {

    public static Mail passwordReset(final User user) {
        return new Mail(user.email(), "Password reset");
    }

}
