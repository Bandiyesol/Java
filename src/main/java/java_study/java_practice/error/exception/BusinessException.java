package java_study.java_practice.error.exception;

import java_study.java_practice.error.ErrorCode;
import lombok.Getter;

@Getter

public class BusinessException extends RuntimeException {

    private final ErrorCode errorCode;

    public BusinessException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
