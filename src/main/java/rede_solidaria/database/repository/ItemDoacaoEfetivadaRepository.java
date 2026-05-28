package rede_solidaria.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rede_solidaria.database.model.ItemDoacaoEfetivada;

public interface ItemDoacaoEfetivadaRepository extends JpaRepository<ItemDoacaoEfetivada, Integer>{
    boolean existsById(Integer id);
}
