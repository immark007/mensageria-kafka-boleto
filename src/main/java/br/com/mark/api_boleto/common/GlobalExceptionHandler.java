package br.com.mark.api_boleto.common;

import br.com.mark.api_boleto.dto.ErroCampo;
import br.com.mark.api_boleto.dto.ErroResposta;
import br.com.mark.api_boleto.exception.ApplicationException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
@Hidden
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResposta handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<ErroCampo> listaErros = fieldErrors.stream()
                .map(fe -> new ErroCampo(fe.getField(), fe.getDefaultMessage()))
                .toList();

        return new ErroResposta(HttpStatus.UNPROCESSABLE_ENTITY.name(),
                HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", listaErros, LocalDateTime.now()
        );
    }

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResposta handleApplicationException(ApplicationException ex){
        return ErroResposta.conflito(ex.getMessage());
    }
}
