package java_study.java_practice.error.exception;

import java_study.java_practice.error.ErrorCode;

public class NotFoundException extends BusinessException {
    public NotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
