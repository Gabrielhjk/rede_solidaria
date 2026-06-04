package rede_solidaria.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import rede_solidaria.database.model.ItemDoacao;
import rede_solidaria.database.model.Solicitacao;
import rede_solidaria.database.model.enums.StatusSolicitacao;
import rede_solidaria.database.repository.ItemDoacaoRepository;
import rede_solidaria.database.repository.SolicitacaoRepository;
import rede_solidaria.handler.BusinessException;

@Service
@AllArgsConstructor
public class DoacaoEfetivadaService {

    private final SolicitacaoRepository solicitacaoRepository;
    private final ItemDoacaoRepository itemDoacaoRepository;
    
    public void aprovarSolicitacao (Integer id) {
        Solicitacao solicitacao = solicitacaoRepository.findById(id)
            .orElseThrow(() -> new BusinessException("Solicitação não encontrada"));
    
        // pega a quantidade solicitada pelo benficiario no post
        Integer quantidadeSolicitada = solicitacao.getQuantidadeSolicitada();

        // acessa o item que estava como coluna estrangeira no model de solicitacao
        ItemDoacao item = solicitacao.getItemDoacao();

        // valida se a quantidade da requisicao post e maior do que a quantidade do item no model
        if (quantidadeSolicitada > item.getQuantidade()) {
            throw new BusinessException("Quantidade Inválida");
        }
        
        // diminui a quantidade que veio na requisicao post da quantidade que esta no model
        item.setQuantidade(item.getQuantidade() - quantidadeSolicitada);

        // muda o status da solicitacao para aprovada
        solicitacao.setStatusSolicitacao(StatusSolicitacao.APROVADA);

        // salva o novo status no banco
        itemDoacaoRepository.save(item);
        solicitacaoRepository.save(solicitacao);
    }

    public void rejeitarSolicitacao (Integer id) {
        Solicitacao solicitacao = solicitacaoRepository.findById(id) 
            .orElseThrow(() -> new BusinessException("Solicitação não encontrada"));

        // muda o status para rejeitada
        solicitacao.setStatusSolicitacao(StatusSolicitacao.REJEITADA);

         // salva no banco 
        solicitacaoRepository.save(solicitacao);
        }

}
