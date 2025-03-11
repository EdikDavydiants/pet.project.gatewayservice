package pet.project.gatewayservice.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pet.project.gatewayservice.exception.GeneralExceptionResponse;
import pet.project.gatewayservice.exception.InvalidTokenException;
import pet.project.gatewayservice.exception.TokenNotFoundException;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TokenNotFoundException.class)
    public Mono<ResponseEntity<GeneralExceptionResponse>> handleTokenNotFoundException(TokenNotFoundException exception) {
        return Mono.just(
                ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new GeneralExceptionResponse(
                                HttpStatus.UNAUTHORIZED.value(),
                                "TokenNotFoundError",
                                exception.getMessage(),
                                null)));
    }

    @ExceptionHandler(InvalidTokenException.class)
    public Mono<ResponseEntity<GeneralExceptionResponse>> handleInvalidTokenException(InvalidTokenException exception) {
        return Mono.just(
                ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new GeneralExceptionResponse(
                                HttpStatus.UNAUTHORIZED.value(),
                                "InvalidTokenError",
                                exception.getMessage(),
                                null)));
    }
}
