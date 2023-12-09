package com.github.gustavoflor.aed.core;

public class MailService {

    private static final String PASSWORD_RESET_ATTEMPT_FAIL_MESSAGE = "Password reset attempt for unknown user with ID = %s%n";

    private final UserService userService;

    public MailService(final UserService userService) {
        this.userService = userService;
    }

    public void sendPasswordReset(final Long id) {
        userService.findById(id)
            .ifPresentOrElse(this::sendPasswordReset, this::handleNotFoundUser);
    }

    public void sendPasswordResetWithCatch(final Long id) {
        try {
            final var user = userService.findByIdOrElseThrowNotFoundException(id);
            send(Mail.passwordReset(user));
        } catch (NotFoundException e) {
            handleNotFoundUser();
        }
    }

    public void sendPasswordResetWithCatchAndTrace(final Long id) {
        try {
            final var user = userService.findByIdOrElseThrowNotFoundExceptionWithTrace(id);
            send(Mail.passwordReset(user));
        } catch (NotFoundException e) {
            handleNotFoundUser();
        }
    }

    private void sendPasswordReset(final User user) {
        send(Mail.passwordReset(user));
    }

    private void send(final Mail mail) {
        System.out.printf("Mail sent to %s with subject equals to %s%n", mail.email(), mail.subject());
    }

    private void handleNotFoundUser() {
        // DO NOTHING
    }

}
