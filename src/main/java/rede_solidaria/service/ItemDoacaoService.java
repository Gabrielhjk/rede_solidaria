package rede_solidaria.service;

import java.util.ArrayList;
import java.util.List;

import rede_solidaria.database.model.ItemDoacao;
import rede_solidaria.dto.ItemDoacaoDto;

import org.springframework.stereotype.Service;

@Service
public class ItemDoacaoService {
    private static final List<ItemDoacao> itensDoacao = new ArrayList<>();

    public ItemDoacao cadastrarItemDoacao(ItemDoacaoDto itemDoacaoDto) {
        ItemDoacao novoItem = ItemDoacao.builder()
            .nomeItem(itemDoacaoDto.getNomeItem())
            .categoria(itemDoacaoDto.getCategoria())
            .descricao(itemDoacaoDto.getDescricao())
            .quantidade(itemDoacaoDto.getQuantidade())
            .estadoDeConversao(itemDoacaoDto.getEstadoDeConversao())
            .statusItem(itemDoacaoDto.getStatusItem())
            .dataDoacao(itemDoacaoDto.getDataDoacao())
            .build();

            itensDoacao.add(novoItem);
            return novoItem;
    }

    public ItemDoacao atualizarDadosItem(Integer id, ItemDoacaoDto itemDoacaoDto) {
        ItemDoacao itemId = itensDoacao.stream()
            .filter(i -> i.getId().equals(id))
            .findAny()
            .orElseThrow(null);

        itemId.setNomeItem(itemDoacaoDto.getNomeItem());
        itemId.setCategoria(itemDoacaoDto.getCategoria());
        itemId.setDescricao(itemDoacaoDto.getDescricao());
        itemId.setQuantidade(itemDoacaoDto.getQuantidade());
        itemId.setEstadoDeConversao(itemDoacaoDto.getEstadoDeConversao());
        itemId.setStatusItem(itemDoacaoDto.getStatusItem());
        itemId.setDataDoacao(itemDoacaoDto.getDataDoacao());

        return itemId;
    }

    public void deletarItemDoacao(Integer id) {
        itensDoacao.removeIf(i -> i.getId().equals(id));
    }
}
