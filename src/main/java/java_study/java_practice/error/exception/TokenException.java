package java_study.java_practice.error.exception;

import java_study.java_practice.error.ErrorCode;

public class TokenException extends BusinessException {
    public TokenException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}