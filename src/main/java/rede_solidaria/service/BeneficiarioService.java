package rede_solidaria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rede_solidaria.database.model.ItemDoacao;
import rede_solidaria.database.model.enums.StatusItem;
import rede_solidaria.database.repository.BeneficiarioRepository;
import rede_solidaria.database.repository.ItemDoacaoRepository;
import rede_solidaria.database.repository.SolicitacaoRepository;
import rede_solidaria.dto.loginDto.LoginDto;
import rede_solidaria.handler.BusinessException;
import rede_solidaria.dto.SolicitacaoDto.SolicitacaoResponseDto;
import rede_solidaria.dto.doadorDto.DoadorResponseDto;
import rede_solidaria.dto.itemDoacaoDto.ItemDoacaoResponseDto;

// services para beneficiarios
// + atualizarDadosBeneficiario()
// + listarDoadores() - feito
// + listarItens() - feito
// + buscarItensDisponiveis() filtrar por status do item - feito
// + obterNivelPrioridade() filtar por prioridade - feito
// + solicitarItem() 
// + listarSolicitacoes() filtrar por status de solicitacao
// + logar() - feito


@Service
@RequiredArgsConstructor
public class BeneficiarioService {
    private final AdministradorDoadorService administradorDoadorService;
    private final DoadorService doadorService;
    private final BeneficiarioRepository beneficiarioRepository;
    private final ItemDoacaoRepository itemDoacaoRepository;
    private final SolicitacaoRepository solicitacaoRepository;

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
    }


    public void logar(LoginDto loginDto) {
        if (!beneficiarioRepository.existsByEmailAndSenha(loginDto.getEmail(), loginDto.getSenha())) {
            throw new BusinessException("Email ou senha inválidos ou não existe");
        }   
    }

    public List<DoadorResponseDto> listarDoadores() {
        return administradorDoadorService.listarDoadores();
    }

    public List<ItemDoacaoResponseDto> listarItens() {
        return doadorService.listarItensDoacao();
    }

    public List<ItemDoacaoResponseDto> buscarItensPorStatus (StatusItem statusItem) {
        return itemDoacaoRepository.findByStatusItem(statusItem)
                                   .stream()
                                   .map(this::converterParaDto)
                                   .toList();
    }

    public List<SolicitacaoResponseDto> listarSolicitacoes() {
        return solicitacaoRepository.findAll()
                                    .stream()
                                    .map(this)
    }
}
