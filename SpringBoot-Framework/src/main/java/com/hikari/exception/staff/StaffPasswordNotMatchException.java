package com.hikari.exception.staff;

/**
 * StaffPasswordNotMatchException
 *
 * @author lkc39miku_cn
 */
public class StaffPasswordNotMatchException extends StaffException {
    public StaffPasswordNotMatchException() {
        super("Staff.A10001", "staff.password.not.match");
    }
}
