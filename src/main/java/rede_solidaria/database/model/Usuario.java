package rede_solidaria.database.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
public class Usuario {
    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private String endereco;
}