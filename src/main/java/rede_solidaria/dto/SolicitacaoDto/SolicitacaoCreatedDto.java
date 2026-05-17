package rede_solidaria.dto.SolicitacaoDto;

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
public class SolicitacaoCreatedDto {
    private Integer quantidadeSolicitada;
    private String justificativa;
}
