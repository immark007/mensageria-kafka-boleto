package br.com.mark.api_boleto.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoletoRequestDTO {

    @NotNull(message = "o boleto não pode ser nullo")
    @NotEmpty(message = "não pode ser vázio")
    private String codigoBarras;
}
