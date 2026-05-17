package rede_solidaria.dto.usuarioDto;

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
public class UsuarioCreatedDto {
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private String endereco;
}