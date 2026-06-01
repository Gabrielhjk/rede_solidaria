package rede_solidaria.service;

import java.util.ArrayList;
import java.util.List;

import rede_solidaria.database.model.Doador;
import rede_solidaria.database.model.ItemDoacaoEfetivada;
import rede_solidaria.dto.beneficiarioDto.BeneficiarioResponseDto;
import rede_solidaria.dto.itemDoacaoEfetivadaDto.ItemDoacaoEfetivadaCreatedDto;
import rede_solidaria.dto.itemDoacaoEfetivadaDto.ItemDoacaoEfetivadaResponseDto;
import rede_solidaria.handler.BusinessException;
import rede_solidaria.database.repository.AdministradorDoadorRepository;
import rede_solidaria.database.repository.ItemDoacaoEfetivadaRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemDoacaoService {

    private final ItemDoacaoEfetivadaRepository itemDoacaoEfetivadaRepository;
    private final AdministradorDoadorRepository administradorDoadorRepository;


    // conversao do model para Dto
    private ItemDoacaoEfetivadaResponseDto converterParaDto(ItemDoacaoEfetivada itemDoacaoEfetivada) {
            return ItemDoacaoEfetivadaResponseDto.builder()
                .id(itemDoacaoEfetivada.getId())
                .nomeItem(itemDoacaoEfetivada.getNomeItem())
                .categoria(itemDoacaoEfetivada.getCategoria())
                .descricao(itemDoacaoEfetivada.getDescricao())
                .quantidade(itemDoacaoEfetivada.getQuantidade())
                .estadoDeConversao(itemDoacaoEfetivada.getEstadoDeConversao())
                .statusItem(itemDoacaoEfetivada.getStatusItem())
                .dataDoacao(itemDoacaoEfetivada.getDataDoacao())
                .doadorId(itemDoacaoEfetivada.getDoador().getId())
                .build();
        };

    public List<ItemDoacaoEfetivadaResponseDto> listarItensDoacao() {
        return itemDoacaoEfetivadaRepository.findAll()
                                            .stream()
                                            .map(this::converterParaDto)
                                            .toList();
    }

    public void cadastrarItemDoacao(ItemDoacaoEfetivadaCreatedDto itemDoacaoEfetivadaCreatedDto) {

        Doador doador = administradorDoadorRepository.findById(itemDoacaoEfetivadaCreatedDto.getDoadorId())
        .orElseThrow(() -> new BusinessException("Doador não encontrado"));

        ItemDoacaoEfetivada novoItem = ItemDoacaoEfetivada.builder()
            .nomeItem(itemDoacaoEfetivadaCreatedDto.getNomeItem())
            .categoria(itemDoacaoEfetivadaCreatedDto.getCategoria())
            .descricao(itemDoacaoEfetivadaCreatedDto.getDescricao())
            .quantidade(itemDoacaoEfetivadaCreatedDto.getQuantidade())
            .estadoDeConversao(itemDoacaoEfetivadaCreatedDto.getEstadoDeConversao())
            .statusItem(itemDoacaoEfetivadaCreatedDto.getStatusItem())
            .doador(doador)
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