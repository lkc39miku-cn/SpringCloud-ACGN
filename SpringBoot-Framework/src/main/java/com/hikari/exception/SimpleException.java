package com.hikari.exception;

/**
 * SimpleException
 *
 * @author lkc39miku_cn
 */
public class SimpleException {
    private final String code;
    private final String message;
    private final String module;

    public SimpleException(String code, String message, String module) {
        this.code = code;
        this.message = message;
        this.module = module;
    }
}
