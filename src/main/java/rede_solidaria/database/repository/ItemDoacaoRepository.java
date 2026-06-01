package rede_solidaria.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rede_solidaria.database.model.ItemDoacao;

public interface ItemDoacaoRepository extends JpaRepository<ItemDoacao, Integer>{
    boolean existsById(Integer id);
}
