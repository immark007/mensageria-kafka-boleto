package br.com.mark.api_boleto.controller;

import br.com.mark.api_boleto.dto.BoletoDTO;
import br.com.mark.api_boleto.dto.BoletoRequestDTO;
import br.com.mark.api_boleto.service.BoletoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boletos")
@RequiredArgsConstructor
public class BoletoController {
    private final BoletoService boletoService;

    @PostMapping
    public ResponseEntity<BoletoDTO> salvar(@RequestBody @Valid BoletoRequestDTO boletoRequestDTO){
        var boleto = boletoService.salvar(boletoRequestDTO.getCodigoBarras());
        return new ResponseEntity<>(boleto, HttpStatus.CREATED);
    }
}
