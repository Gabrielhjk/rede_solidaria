package rede_solidaria.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rede_solidaria.database.model.Doador;

public interface DoadorRepository extends JpaRepository<Doador, Integer>{
    boolean existsByEmailAndSenha(String email, String senha);
    
}
