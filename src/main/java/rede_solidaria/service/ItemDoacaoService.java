package rede_solidaria.service;

import java.util.ArrayList;
import java.util.List;

import rede_solidaria.database.model.ItemDoacaoEfetivada;
import rede_solidaria.dto.itemDoacaoEfetivadaDto.ItemDoacaoEfetivadaCreatedDto;
import rede_solidaria.handler.BusinessException;
import rede_solidaria.database.repository.ItemDoacaoEfetivadaRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemDoacaoService {

    private final ItemDoacaoEfetivadaRepository itemDoacaoEfetivadaRepository;

    public List<ItemDoacaoEfetivada> listarItensDoacao() {
        return itemDoacaoEfetivadaRepository.findAll();
    }

    public void cadastrarItemDoacao(ItemDoacaoEfetivadaCreatedDto itemDoacaoEfetivadaCreatedDto) {
        ItemDoacaoEfetivada novoItem = ItemDoacaoEfetivada.builder()
            .nomeItem(itemDoacaoEfetivadaCreatedDto.getNomeItem())
            .categoria(itemDoacaoEfetivadaCreatedDto.getCategoria())
            .descricao(itemDoacaoEfetivadaCreatedDto.getDescricao())
            .quantidade(itemDoacaoEfetivadaCreatedDto.getQuantidade())
            .estadoDeConversao(itemDoacaoEfetivadaCreatedDto.getEstadoDeConversao())
            .statusItem(itemDoacaoEfetivadaCreatedDto.getStatusItem())
            .build();

            if (itemDoacaoEfetivadaCreatedDto.getQuantidade() <= 0) {
                throw new BusinessException("Quantidade do item tem que ser maior do que 0");
            }

            itemDoacaoEfetivadaRepository.save(novoItem);
    }

    // public ItemDoacaoEfetivada atualizarDadosItem(Integer id, ItemDoacaoEfetivadaCreatedDto itemDoacaoCreatedDto) {
    //     ItemDoacaoEfetivada itemId = itensDoacao.stream()
    //         .filter(i -> i.getId().equals(id))
    //         .findAny()
    //         .orElseThrow(null);

    //     itemId.setNomeItem(itemDoacaoCreatedDto.getNomeItem());
    //     itemId.setCategoria(itemDoacaoCreatedDto.getCategoria());
    //     itemId.setDescricao(itemDoacaoCreatedDto.getDescricao());
    //     itemId.setQuantidade(itemDoacaoCreatedDto.getQuantidade());
    //     itemId.setEstadoDeConversao(itemDoacaoCreatedDto.getEstadoDeConversao());
    //     itemId.setStatusItem(itemDoacaoCreatedDto.getStatusItem());
    //     // itemId.setDataDoacao(itemDoacaoCreatedDto.getDataDoacao());

    //     return itemId;
    // }

    public void deletarItemDoacao(Integer id) {
        if (!itemDoacaoEfetivadaRepository.existsById(id)) {
            throw new BusinessException("Item não encontrado");
        }

        itemDoacaoEfetivadaRepository.deleteById(id);
    }
}