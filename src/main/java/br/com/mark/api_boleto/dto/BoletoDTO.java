package br.com.mark.api_boleto.dto;

import br.com.mark.api_boleto.entity.enums.SituacaoBoleto;
import lombok.*;


import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoletoDTO {
    private String codigoBarras;

    private SituacaoBoleto situacaoBoleto;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;
}
