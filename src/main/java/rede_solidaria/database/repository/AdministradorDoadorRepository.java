package rede_solidaria.database.repository; 

import org.springframework.data.jpa.repository.JpaRepository;
import rede_solidaria.database.model.Doador;

public interface AdministradorDoadorRepository extends JpaRepository<Doador, Integer>{
    boolean existsByEmail(String email);
    boolean existsById(Integer id);
}