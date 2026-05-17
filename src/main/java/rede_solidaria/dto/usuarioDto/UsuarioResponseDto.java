package rede_solidaria.dto.usuarioDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
public class UsuarioResponseDto {
    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;   
}
