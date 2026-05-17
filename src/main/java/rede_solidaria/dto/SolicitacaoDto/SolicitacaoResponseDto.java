package rede_solidaria.dto.SolicitacaoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rede_solidaria.database.model.enums.StatusSolicitacao;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SolicitacaoResponseDto {
    private Integer id;
    private Integer quantidadeSolicitada;
    private String justificativa;
    private StatusSolicitacao statusSolicitacao;    
}
