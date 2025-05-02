package br.com.mark.api_boleto.repository;

import br.com.mark.api_boleto.entity.BoletoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoletoRepository extends JpaRepository<BoletoEntity, Long> {
    Optional<BoletoEntity> findByCodigoBarras(String codigoBarras);
}
