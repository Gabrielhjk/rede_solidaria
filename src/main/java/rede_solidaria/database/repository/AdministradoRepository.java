package rede_solidaria.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rede_solidaria.database.model.Administrador;


public interface AdministradoRepository extends JpaRepository<Administrador, Integer> {
    boolean existsByEmailAndSenha(String email, String senha);
}
