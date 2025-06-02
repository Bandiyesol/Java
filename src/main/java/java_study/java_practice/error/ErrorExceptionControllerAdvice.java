package java_study.java_practice.error;

import java_study.java_practice.error.exception.BadRequestException;
import java_study.java_practice.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice

public class ErrorExceptionControllerAdvice {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorEntity> exceptionHandler(final NotFoundException exception) {
        return ResponseEntity.status(exception.getErrorCode().getStatus())
                .body(new ErrorEntity(
                                exception.getErrorCode().getCode(),
                                exception.getMessage()
                        )
                );
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ErrorEntity> exceptionHandler(final BadRequestException exception) {
        return ResponseEntity.status(exception.getErrorCode().getStatus())
                .body(new ErrorEntity(
                                exception.getErrorCode().getCode(),
                                exception.getMessage()
                        )
                );
    }
}
