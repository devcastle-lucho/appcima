package pe.edu.colegiocima.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pe.edu.colegiocima.app.exception.domain.ApiError;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    //Sucede cuando el MediaType json, xml no es compatible al enviar
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
                                                                     HttpHeaders headers,
                                                                     HttpStatus status,
                                                                     WebRequest request) {
        StringBuilder builder= new StringBuilder();
        builder.append(ex.getContentType());
        builder.append(" El media type no es compatible. Los media type admitidos son:");
        ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));
        return buildResponseEntity(new ApiError(
                HttpStatus.UNSUPPORTED_MEDIA_TYPE,
                builder.substring(0,builder.length()-2),
                ex
        ));
    }
    // Sucede cuando la solicitud JSON tiene un formato incorrecto
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ServletWebRequest servletWebRequest= (ServletWebRequest)request;
        log.info("{} a {}",
                servletWebRequest.getHttpMethod(),
                servletWebRequest.getRequest().getServletPath()
                );
        String error="Petición JSON malformado";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST,error,ex));
    }

    // Manejo de la excepcion del tipo incorrecto del parametro del metodo/operacion
    // http://localhost:8085/api/v1/grado/listar-nivelcolegio/a
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
                                                                      WebRequest webRequest){
        ApiError apiError= new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(String.format("El parametro '%s' del valor '%s' no se pudo convertir al tipo '%s'",
                            ex.getName(),
                            ex.getValue(),
                            ex.getRequiredType().getSimpleName()
                            ));
        return buildResponseEntity(apiError);
    }
    //org.springframework.security.access.AccessDeniedException
    //Manejo de excepcion de acceso denegado - 403
    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<Object> handleAccessDeniedException(
            AccessDeniedException ex,WebRequest request){
        ApiError apiError= new ApiError(HttpStatus.FORBIDDEN);
        apiError.setMessage("Acceso denegado");
        apiError.setDebugMessage(ex.getLocalizedMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleRuntime(RuntimeException ex) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage("Error interno del servidor");
        apiError.setDebugMessage(ex.getMessage());
        log.error("Exception: ",ex);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception ex) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage("Error interno del servidor");
        apiError.setDebugMessage(ex.getMessage());
        log.error("Exception: ",ex);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(AuthAppException.class)
    protected ResponseEntity<Object> handleAuthAppException(Exception ex) {
        ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED);
        apiError.setMessage("No autenticado");
        apiError.setDebugMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError,apiError.getStatus());
    }
}
