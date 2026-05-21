package rede_solidaria.dto.itemDoacaoEfetivadaDto;

import rede_solidaria.database.model.enums.StatusItem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ItemDoacaoEfetivadaCreatedDto {
    @NotBlank(message = "O nome do item é obrigatório")
    private String nomeItem;
    @NotBlank(message = "A categoria é obrigatória")
    private String categoria;
    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 255, message = "A descrição deve conter no máximo 255 caracteres")
    private String descricao;
    @NotBlank(message = "A quantidade é obrigatória")
    private Integer quantidade;
    @NotBlank(message = "O estado de conversão é obrigatório")
    private String estadoDeConversao;
    @NotNull(message = "O status do item é obrigatório")
    private StatusItem statusItem;
}
