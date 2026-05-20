package rede_solidaria.dto.itemDoacaoDto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rede_solidaria.database.model.enums.StatusItem;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ItemDoacaoResponseDto {
    private Integer id;
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
    private LocalDateTime dataDoacao;   
}
