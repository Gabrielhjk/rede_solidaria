package rede_solidaria.dto.SolicitacaoDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "O nome do item é obrigatório")
    @Min(value = 1, message = "A quantidade deve ser maior ou igual a 1")
    private Integer quantidadeSolicitada;
    @Size(max = 255, message = "A justificativa deve conter no máximo 255 caracteres")
    private String justificativa;
    @NotNull
    private Integer beneficiarioId;
    @NotNull
    private Integer itemDoacaoId;
}
