package rede_solidaria.dto.itemDoacaoEfetivadaDto;

import rede_solidaria.database.model.enums.StatusItem;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String nomeItem;
    @NotBlank
    private String categoria;
    @NotBlank
    @Size(max = 255)
    private String descricao;
    @NotBlank
    private Integer quantidade;
    @NotBlank
    private String estadoDeConversao;
    @NotBlank
    private StatusItem statusItem;
}
