package java_study.java_practice.error.exception;

import java_study.java_practice.error.ErrorCode;

public class BadRequestException extends BusinessException {
  public BadRequestException(String message, ErrorCode errorCode) {
    super(message, errorCode);
  }
}
