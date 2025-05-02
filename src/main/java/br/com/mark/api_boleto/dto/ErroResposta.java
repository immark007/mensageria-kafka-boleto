package br.com.mark.api_boleto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErroResposta {
    private String status;
    private int statusCode;
    private String message;
    private List<ErroCampo> erros;
    private LocalDateTime timestamp;

    public static ErroResposta conflito(String mensagem) {
        return new ErroResposta(HttpStatus.CONFLICT.name(), HttpStatus.CONFLICT.value(), mensagem, List.of(),LocalDateTime.now());
    }

    public static ErroResposta badRequest(String mensagem) {
        return new ErroResposta(HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.value(), mensagem, List.of(),LocalDateTime.now());
    }
}
