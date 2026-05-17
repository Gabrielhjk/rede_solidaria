package rede_solidaria.dto.administradorDto;

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
@ToString(callSuper = true)
@SuperBuilder
public class AdministradoResponseDto {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;   
}
