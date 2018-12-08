package com.itrjp.common.exception;

/**
 * Created by ren on 2018/10/19.
 */
public class CheckException extends RuntimeException {
    public CheckException() {
    }

    public CheckException(String message) {
        super(message);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

}
