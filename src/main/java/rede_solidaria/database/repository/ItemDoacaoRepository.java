package rede_solidaria.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rede_solidaria.database.model.ItemDoacao;
import rede_solidaria.database.model.enums.StatusItem;

public interface ItemDoacaoRepository extends JpaRepository<ItemDoacao, Integer>{
    boolean existsById(Integer id);
    List<ItemDoacao> findByStatusItem(StatusItem statusItem);
}
