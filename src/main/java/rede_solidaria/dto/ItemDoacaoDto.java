package rede_solidaria.dto;

import java.time.LocalDateTime;

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
public class ItemDoacaoDto {
    private String nomeItem;
    private String categoria;
    private String descricao;
    private Integer quantidade;
    private String estadoDeConversao;
    private StatusItem statusItem;
    private LocalDateTime dataDoacao;
}
