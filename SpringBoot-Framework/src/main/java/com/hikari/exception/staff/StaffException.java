package com.hikari.exception.staff;

import com.hikari.exception.SimpleException;

/**
 * StaffException
 *
 * @author lkc39miku_cn
 */
public class StaffException extends SimpleException {
    public StaffException(String code, String message) {
        super(code, message, "staff");
    }
}
