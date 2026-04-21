package rede_solidaria.database.model;

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
public class Solicitacao {
    private Integer id;
    private Integer quantidadeSolicitada;
    private String justificativa;
    private StatusSolicitacao statusSolicitacao;
}
