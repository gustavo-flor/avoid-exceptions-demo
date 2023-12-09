package com.github.gustavoflor.aed;

import com.github.gustavoflor.aed.core.MailService;
import com.github.gustavoflor.aed.core.UserService;

public class Application {

    private static final long TRIAL = 100000;

    public static void main(final String[] args) {
        final var userService = new UserService();
        final var mailService = new MailService(userService);

        for (int i = 1; i <= 5; i++) {
            System.out.printf("- Run %s %n", i);
            benchmark("No Exception", () -> mailService.sendPasswordReset(1L));
            benchmark("Exception", () -> mailService.sendPasswordResetWithCatch(1L));
            benchmark("Exception & Trace", () -> mailService.sendPasswordResetWithCatchAndTrace(1L));
        }
    }

    private static void benchmark(final String name, final Runnable runnable) {
        final var startTime = System.currentTimeMillis();
        for (int i = 0; i < TRIAL; i++) {
            runnable.run();
        }
        final var endTime = System.currentTimeMillis();
        final var duration = endTime - startTime;
        System.out.printf("Duration: %sms [%s]%n", duration, name);
    }

}
