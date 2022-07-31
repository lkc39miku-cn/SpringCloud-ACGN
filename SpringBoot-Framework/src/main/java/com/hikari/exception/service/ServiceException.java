package com.hikari.exception.service;

import com.hikari.exception.SimpleException;

/**
 * ServiceException
 *
 * @author lkc39miku_cn
 */
public class ServiceException extends SimpleException {
    public ServiceException(String code, String message) {
        super(code, message, "service");
    }
}
