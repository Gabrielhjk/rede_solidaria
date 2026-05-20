package rede_solidaria.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rede_solidaria.database.model.Solicitacao;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Integer>{
    
}
