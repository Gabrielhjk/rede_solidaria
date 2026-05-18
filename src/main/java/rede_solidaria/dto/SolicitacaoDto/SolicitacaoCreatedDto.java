package rede_solidaria.dto.SolicitacaoDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    private Integer quantidadeSolicitada;
    @Size(max = 255)
    private String justificativa;
}
