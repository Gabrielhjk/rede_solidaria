package rede_solidaria.dto.itemDoacaoDto;

import java.time.LocalDateTime;

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
    private String nomeItem;
    private String categoria;
    private String descricao;
    private Integer quantidade;
    private String estadoDeConversao;
    private StatusItem statusItem;
    private LocalDateTime dataDoacao;   
}
