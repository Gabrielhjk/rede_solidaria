package rede_solidaria.service;

import java.util.ArrayList;
import java.util.List;

import rede_solidaria.database.model.ItemDoacaoEfetivada;
import rede_solidaria.dto.itemDoacaoEfetivadaDto.ItemDoacaoEfetivadaCreatedDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemDoacaoService {
    private static final List<ItemDoacaoEfetivada> itensDoacao = new ArrayList<>();

    public List<ItemDoacaoEfetivada> listarItensDoacao() {
        return new ArrayList<>(itensDoacao);
    }

    public ItemDoacaoEfetivada cadastrarItemDoacao(ItemDoacaoEfetivadaCreatedDto itemDoacaoCreatedDto) {
        
        Integer id = itensDoacao.stream()
            .mapToInt(ItemDoacaoEfetivada::getId)
            .max()
            .orElse(0) + 1;

        ItemDoacaoEfetivada novoItem = ItemDoacaoEfetivada.builder()
            .id(id)
            .nomeItem(itemDoacaoCreatedDto.getNomeItem())
            .categoria(itemDoacaoCreatedDto.getCategoria())
            .descricao(itemDoacaoCreatedDto.getDescricao())
            .quantidade(itemDoacaoCreatedDto.getQuantidade())
            .estadoDeConversao(itemDoacaoCreatedDto.getEstadoDeConversao())
            .statusItem(itemDoacaoCreatedDto.getStatusItem())
            // .dataDoacao(itemDoacaoCreatedDto.getDataDoacao())
            .build();

            itensDoacao.add(novoItem);
            return novoItem;
    }

    public ItemDoacaoEfetivada atualizarDadosItem(Integer id, ItemDoacaoEfetivadaCreatedDto itemDoacaoCreatedDto) {
        ItemDoacaoEfetivada itemId = itensDoacao.stream()
            .filter(i -> i.getId().equals(id))
            .findAny()
            .orElseThrow(null);

        itemId.setNomeItem(itemDoacaoCreatedDto.getNomeItem());
        itemId.setCategoria(itemDoacaoCreatedDto.getCategoria());
        itemId.setDescricao(itemDoacaoCreatedDto.getDescricao());
        itemId.setQuantidade(itemDoacaoCreatedDto.getQuantidade());
        itemId.setEstadoDeConversao(itemDoacaoCreatedDto.getEstadoDeConversao());
        itemId.setStatusItem(itemDoacaoCreatedDto.getStatusItem());
        // itemId.setDataDoacao(itemDoacaoCreatedDto.getDataDoacao());

        return itemId;
    }

    public void deletarItemDoacao(Integer id) {
        itensDoacao.removeIf(i -> i.getId().equals(id));
    }
}