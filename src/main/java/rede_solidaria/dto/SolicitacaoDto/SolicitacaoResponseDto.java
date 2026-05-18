package rede_solidaria.dto.SolicitacaoDto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    private Integer quantidadeSolicitada;
    @Size(max = 255)
    private String justificativa;
    @NotBlank
    private StatusSolicitacao statusSolicitacao;    
}
