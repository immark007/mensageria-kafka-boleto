package br.com.mark.api_boleto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErroCampo {
    private String campo;
    private String erro;

}
