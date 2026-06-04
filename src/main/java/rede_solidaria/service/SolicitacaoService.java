package rede_solidaria.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rede_solidaria.database.model.Solicitacao;
import rede_solidaria.dto.SolicitacaoDto.SolicitacaoResponseDto;

// + validarSolicitação()
// + aprovar()
// + rejeitar()

@Service
@RequiredArgsConstructor
public class SolicitacaoService {
    
    // conversao do model para Dto
    public SolicitacaoResponseDto converterParaDto(Solicitacao solicitacao) {
        return SolicitacaoResponseDto.builder()
            .id(solicitacao.getId())
            .quantidadeSolicitada(solicitacao.getQuantidadeSolicitada())
            .justificativa(solicitacao.getJustificativa())
            .beneficiario(solicitacao.getBeneficiario().getId())
            .itemDoacao(solicitacao.getItemDoacao().getId())
            .statusSolicitacao(solicitacao.getStatusSolicitacao())
            .build();
    }
}
