package rede_solidaria.service;

import java.util.List;

import rede_solidaria.database.model.Doador;
import rede_solidaria.database.model.ItemDoacao;
import rede_solidaria.database.model.enums.StatusItem;
import rede_solidaria.dto.itemDoacaoDto.ItemDoacaoCreatedDto;
import rede_solidaria.dto.itemDoacaoDto.ItemDoacaoResponseDto;
import rede_solidaria.dto.loginDto.LoginDto;
import rede_solidaria.handler.BusinessException;
import rede_solidaria.database.repository.AdministradorDoadorRepository;
import rede_solidaria.database.repository.DoadorRepository;
import rede_solidaria.database.repository.ItemDoacaoRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

// + cadastrarItem() feito
// + atualizarDadosItem()  
// + removerItem() feito
// + listarItems() feito
// + buscarItem() buscar por id do item - feito
// + atualizarStatus() - feito
// + atualizarEstoque()
// + logar() feito


@Service
@RequiredArgsConstructor
public class DoadorService {

    private final DoadorRepository doadorRepository;
    private final ItemDoacaoRepository itemDoacaoRepository;
    private final AdministradorDoadorRepository administradorDoadorRepository;

    
    public void logar(LoginDto loginDto) {
        if (!doadorRepository.existsByEmailAndSenha(loginDto.getEmail(), loginDto.getSenha())) {
            throw new BusinessException("Email ou senha inválidos ou não existe");
        }
    }

    // conversao do model para Dto
    private ItemDoacaoResponseDto converterParaDto(ItemDoacao itemDoacao) {
            return ItemDoacaoResponseDto.builder()
                .id(itemDoacao.getId())
                .nomeItem(itemDoacao.getNomeItem())
                .categoria(itemDoacao.getCategoria())
                .descricao(itemDoacao.getDescricao())
                .quantidade(itemDoacao.getQuantidade())
                .estadoDeConversao(itemDoacao.getEstadoDeConversao())
                .statusItem(itemDoacao.getStatusItem())
                .dataDoacao(itemDoacao.getDataDoacao())
                .doadorId(itemDoacao.getDoador().getId())
                .build();
        };

    public List<ItemDoacaoResponseDto> listarItensDoacao() {
        return itemDoacaoRepository.findAll()
                                   .stream()
                                   .map(this::converterParaDto)
                                   .toList();
    }

    public ItemDoacaoResponseDto listarItem(Integer id) {
        ItemDoacao item = itemDoacaoRepository.findById(id)
        .orElseThrow(() -> new BusinessException("Item não encontrado"));

        return converterParaDto(item);
    }

    public void cadastrarItemDoacao(ItemDoacaoCreatedDto itemDoacaoCreatedDto) {
        Doador doador = administradorDoadorRepository.findById(itemDoacaoCreatedDto.getDoadorId())
        .orElseThrow(() -> new BusinessException("Doador não encontrado"));

        ItemDoacao novoItem = ItemDoacao.builder()
            .nomeItem(itemDoacaoCreatedDto.getNomeItem())
            .categoria(itemDoacaoCreatedDto.getCategoria())
            .descricao(itemDoacaoCreatedDto.getDescricao())
            .quantidade(itemDoacaoCreatedDto.getQuantidade())
            .estadoDeConversao(itemDoacaoCreatedDto.getEstadoDeConversao())
            .statusItem(StatusItem.DISPONIVEL)
            .doador(doador)
            .build();

            if (itemDoacaoCreatedDto.getQuantidade() <= 0) {
                throw new BusinessException("Quantidade do item tem que ser maior do que 0");
            }

            itemDoacaoRepository.save(novoItem);
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
        if (!itemDoacaoRepository.existsById(id)) {
            throw new BusinessException("Item não encontrado");
        }

        itemDoacaoRepository.deleteById(id);
    }

    public void atualizarStatus (Integer id, StatusItem statusItem) {
        ItemDoacao item = itemDoacaoRepository.findById(id)
        .orElseThrow(() -> new BusinessException("Item não encontrado"));

        item.setStatusItem(statusItem);

        itemDoacaoRepository.save(item);
    }
}