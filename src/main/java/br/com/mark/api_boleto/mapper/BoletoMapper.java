package br.com.mark.api_boleto.mapper;

import br.com.mark.api_boleto.dto.BoletoDTO;
import br.com.mark.api_boleto.entity.BoletoEntity;
import org.springframework.stereotype.Component;


@Component
public class BoletoMapper {

    public static BoletoEntity boletoToEntity(BoletoDTO boletoDTO) {
        return BoletoEntity.builder()
                .codigoBarras(boletoDTO.getCodigoBarras())
                .situacaoBoleto(boletoDTO.getSituacaoBoleto())
                .dataCriacao(boletoDTO.getDataCriacao())
                .dataAtualizacao(boletoDTO.getDataAtualizacao())
                .build();
    }

    public static BoletoDTO toDTO(BoletoEntity boletoEntity){
        return BoletoDTO.builder()
                .codigoBarras(boletoEntity.getCodigoBarras())
                .situacaoBoleto(boletoEntity.getSituacaoBoleto())
                .dataCriacao(boletoEntity.getDataCriacao())
                .dataAtualizacao(boletoEntity.getDataAtualizacao())
                .build();
    }
}
