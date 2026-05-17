package rede_solidaria.dto.itemDoacaoDto;

import rede_solidaria.database.model.enums.StatusItem;

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
public class ItemDoacaoCreatedDto {
    private String nomeItem;
    private String categoria;
    private String descricao;
    private Integer quantidade;
    private String estadoDeConversao;
    private StatusItem statusItem;
}
