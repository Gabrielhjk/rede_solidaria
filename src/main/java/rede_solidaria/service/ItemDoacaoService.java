package rede_solidaria.service;

import java.util.ArrayList;
import java.util.List;

import rede_solidaria.database.model.ItemDoacao;
import rede_solidaria.dto.itemDoacaoDto.ItemDoacaoCreatedDto;

import org.springframework.stereotype.Service;

@Service
public class ItemDoacaoService {
    private static final List<ItemDoacao> itensDoacao = new ArrayList<>();

    public List<ItemDoacao> listarItensDoacao() {
        return new ArrayList<>(itensDoacao);
    }

    public ItemDoacao cadastrarItemDoacao(ItemDoacaoCreatedDto itemDoacaoCreatedDto) {
        
        Integer id = itensDoacao.stream()
            .mapToInt(ItemDoacao::getId)
            .max()
            .orElse(0) + 1;

        ItemDoacao novoItem = ItemDoacao.builder()
            .id(id)
            .nomeItem(itemDoacaoCreatedDto.getNomeItem())
            .categoria(itemDoacaoCreatedDto.getCategoria())
            .descricao(itemDoacaoCreatedDto.getDescricao())
            .quantidade(itemDoacaoCreatedDto.getQuantidade())
            .estadoDeConversao(itemDoacaoCreatedDto.getEstadoDeConversao())
            .statusItem(itemDoacaoCreatedDto.getStatusItem())
            .dataDoacao(itemDoacaoCreatedDto.getDataDoacao())
            .build();

            itensDoacao.add(novoItem);
            return novoItem;
    }

    public ItemDoacao atualizarDadosItem(Integer id, ItemDoacaoCreatedDto itemDoacaoCreatedDto) {
        ItemDoacao itemId = itensDoacao.stream()
            .filter(i -> i.getId().equals(id))
            .findAny()
            .orElseThrow(null);

        itemId.setNomeItem(itemDoacaoCreatedDto.getNomeItem());
        itemId.setCategoria(itemDoacaoCreatedDto.getCategoria());
        itemId.setDescricao(itemDoacaoCreatedDto.getDescricao());
        itemId.setQuantidade(itemDoacaoCreatedDto.getQuantidade());
        itemId.setEstadoDeConversao(itemDoacaoCreatedDto.getEstadoDeConversao());
        itemId.setStatusItem(itemDoacaoCreatedDto.getStatusItem());
        itemId.setDataDoacao(itemDoacaoCreatedDto.getDataDoacao());

        return itemId;
    }

    public void deletarItemDoacao(Integer id) {
        itensDoacao.removeIf(i -> i.getId().equals(id));
    }
}