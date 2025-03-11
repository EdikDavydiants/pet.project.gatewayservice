package pet.project.gatewayservice.exception;

public record GeneralExceptionResponse (
    int status,
    String error,
    String message,
    String details
){
}
