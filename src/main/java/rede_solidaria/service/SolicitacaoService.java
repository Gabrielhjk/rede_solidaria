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
    
    public SolicitacaoResponseDto converterParaDto(Solicitacao solicitacao) {
        return SolicitacaoResponseDto.builder()
            .id(solicitacao.getId())
            .beneficiario(solicitacao.getBeneficiario().getNome())
            .itemDoacao(solicitacao.getItemDoacao().getNomeItem())
            .status(solicitacao.getStatusSolicitacao())
            .build();
        
    }
}
