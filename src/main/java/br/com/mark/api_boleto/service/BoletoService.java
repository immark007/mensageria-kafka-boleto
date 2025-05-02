package br.com.mark.api_boleto.service;

import br.com.mark.api_boleto.dto.BoletoDTO;
import br.com.mark.api_boleto.entity.BoletoEntity;
import br.com.mark.api_boleto.entity.enums.SituacaoBoleto;
import br.com.mark.api_boleto.exception.ApplicationException;
import br.com.mark.api_boleto.mapper.BoletoMapper;
import br.com.mark.api_boleto.repository.BoletoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoletoService {
    private final BoletoRepository boletoRepository;
    private final BoletoMapper boletoMapper;

    public BoletoDTO salvar(String codigoBarras){
        Optional boletoOptioanl = boletoRepository.findByCodigoBarras(codigoBarras);
        if(boletoOptioanl.isPresent()){
            throw new ApplicationException("Erro ao salvar boleto");
        }

        var boletoEntity = BoletoEntity.builder().codigoBarras(codigoBarras)
                .situacaoBoleto(SituacaoBoleto.INICIALIZADO)
                .dataCriacao(LocalDateTime.now())
                .dataAtualizacao(LocalDateTime.now())
                .build();

        boletoRepository.save(boletoEntity);

        return boletoMapper.toDTO(boletoEntity);

    }
}
