package com.github.gustavoflor.aed.core;

public class NotFoundException extends RuntimeException {

    public NotFoundException(final boolean writableStackTrace) {
        super(null, null, false, writableStackTrace);
    }
//
//    @Override
//    public synchronized Throwable fillInStackTrace() {
//        return this;
//    }

}
