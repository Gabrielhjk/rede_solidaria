package rede_solidaria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rede_solidaria.database.model.Beneficiario;
import rede_solidaria.database.model.Doador;
import rede_solidaria.database.model.ItemDoacao;
import rede_solidaria.database.model.Solicitacao;
import rede_solidaria.database.model.enums.StatusItem;
import rede_solidaria.database.model.enums.StatusSolicitacao;
import rede_solidaria.database.repository.BeneficiarioRepository;
import rede_solidaria.database.repository.DoadorRepository;
import rede_solidaria.database.repository.ItemDoacaoRepository;
import rede_solidaria.database.repository.SolicitacaoRepository;
import rede_solidaria.dto.loginDto.LoginDto;
import rede_solidaria.handler.BusinessException;
import rede_solidaria.dto.SolicitacaoDto.SolicitacaoCreatedDto;
import rede_solidaria.dto.SolicitacaoDto.SolicitacaoResponseDto;
import rede_solidaria.dto.doadorDto.DoadorResponseDto;
import rede_solidaria.dto.itemDoacaoDto.ItemDoacaoResponseDto;

// services para beneficiarios
// + atualizarDadosBeneficiario()
// + listarDoadores() - feito
// + listarItens() - feito
// + buscarItensDisponiveis() filtrar por status do item - feito
// + solicitarItem() - feito
// + listarSolicitacoes() - feito
// + logar() - feito


@Service
@RequiredArgsConstructor
public class BeneficiarioService {
    private final AdministradorDoadorService administradorDoadorService;
    private final DoadorService doadorService;
    private final SolicitacaoService solicitacaoService;
    private final BeneficiarioRepository beneficiarioRepository;
    private final ItemDoacaoRepository itemDoacaoRepository;
    private final SolicitacaoRepository solicitacaoRepository;
    private final DoadorRepository doadorRepository;

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

    // realiza o login do beneficiario
    public void logar(LoginDto loginDto) {
        if (!beneficiarioRepository.existsByEmailAndSenha(loginDto.getEmail(), loginDto.getSenha())) {
            throw new BusinessException("Email ou senha inválidos ou não existe");
        }   
    }

    public List<DoadorResponseDto> listarDoadores() {
        return administradorDoadorService.listarDoadores();
    }

    public DoadorResponseDto listarDoador(Integer id) {
        Doador doador = doadorRepository.findById(id)
            .orElseThrow(() -> new BusinessException("Doador não encontarado"));

        return administradorDoadorService.converterParaDto(doador);
    }

    public List<ItemDoacaoResponseDto> listarItensDoacao() {
        return doadorService.listarItensDoacao();
    }

    public ItemDoacaoResponseDto listarItem(Integer id) {
        return doadorService.listarItem(id);
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
                                    .map(solicitacaoService::converterParaDto)
                                    .toList();
    }

    public void solicitarItem (SolicitacaoCreatedDto solicitacaoCreatedDto) {
        Beneficiario beneficiario = beneficiarioRepository.findById(solicitacaoCreatedDto.getBeneficiarioId())
            .orElseThrow(() -> new BusinessException("Beneficiario não existe"));
            

        ItemDoacao itemDoacao = itemDoacaoRepository.findById(solicitacaoCreatedDto.getItemDoacaoId())
            .orElseThrow(() -> new BusinessException("Item não existe"));
        
        if (solicitacaoCreatedDto.getQuantidadeSolicitada() < 1) {
            throw new BusinessException("Quantidade Inválida");
        }

        if (solicitacaoCreatedDto.getQuantidadeSolicitada() > itemDoacao.getQuantidade()) {
            throw new BusinessException("Quantidade Inválida");
        }

        // conversao do dto para model
        Solicitacao solicitacao = Solicitacao.builder()
            .quantidadeSolicitada(solicitacaoCreatedDto.getQuantidadeSolicitada())
            .justificativa(solicitacaoCreatedDto.getJustificativa())
            .statusSolicitacao(StatusSolicitacao.PENDENTE)
            .beneficiario(beneficiario)
            .itemDoacao(itemDoacao)
            .build();

        // salva no banco 
        solicitacaoRepository.save(solicitacao);
    }
}
