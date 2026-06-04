package rede_solidaria.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import rede_solidaria.database.model.ItemDoacao;
import rede_solidaria.database.model.Solicitacao;
import rede_solidaria.database.model.enums.StatusSolicitacao;
import rede_solidaria.database.repository.ItemDoacaoRepository;
import rede_solidaria.database.repository.SolicitacaoRepository;
import rede_solidaria.handler.BusinessException;

// + efetivarDoacao() - feito

@Service
@AllArgsConstructor
public class DoacaoEfetivadaService {

    private final SolicitacaoRepository solicitacaoRepository;
    private final ItemDoacaoRepository itemDoacaoRepository;
    
    public void aprovarSolicitacao (Integer id) {
        Solicitacao solicitacao = solicitacaoRepository.findById(id)
            .orElseThrow(() -> new BusinessException("Solicitação não encontrada"));
    
        Integer quantidadeSolicitada = solicitacao.getQuantidadeSolicitada();

        ItemDoacao item = solicitacao.getItemDoacao();

        if (quantidadeSolicitada > item.getQuantidade()) {
            throw new BusinessException("Quantidade Inválida");
        }

        item.setQuantidade(item.getQuantidade() - quantidadeSolicitada);

        solicitacao.setStatusSolicitacao(StatusSolicitacao.APROVADA);

        itemDoacaoRepository.save(item);
        solicitacaoRepository.save(solicitacao);
    }

    public void rejeitarSolicitacao (Integer id) {
        Solicitacao solicitacao = solicitacaoRepository.findById(id) 
            .orElseThrow(() -> new BusinessException("Solicitação não encontrada"));

        solicitacao.setStatusSolicitacao(StatusSolicitacao.REJEITADA);

        solicitacaoRepository.save(solicitacao);
        }

}
