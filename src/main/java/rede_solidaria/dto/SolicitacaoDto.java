package rede_solidaria.dto;

import rede_solidaria.database.model.enums.StatusSolicitacao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SolicitacaoDto {
    private Integer quantidadeSolicitada;
    private String justificativa;
    private StatusSolicitacao statusSolicitacao;
}
