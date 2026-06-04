package rede_solidaria.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import rede_solidaria.database.model.Beneficiario;
import rede_solidaria.database.model.enums.NivelPrioridade;

public interface AdministradorBeneficiarioRepository extends JpaRepository<Beneficiario, Integer>{
    boolean existsByEmail(String email);
    List<Beneficiario> findByNivelPrioridade(NivelPrioridade nivelPrioridade);

}