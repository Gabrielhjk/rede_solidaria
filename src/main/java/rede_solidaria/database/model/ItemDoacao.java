package rede_solidaria.database.model;

// lib para usar tipo de dado de data e hora
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
public class ItemDoacao {
    private Integer id;
    private String nomeItem;
    private String categoria;
    private String descricao;
    private Integer quantidade;
    private String estadoDeConversao;
    private StatusItem statusItem;
    private LocalDateTime dataDoacao;
}
