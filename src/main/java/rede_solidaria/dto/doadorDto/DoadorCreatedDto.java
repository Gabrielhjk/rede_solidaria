package rede_solidaria.dto.doadorDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class DoadorCreatedDto{
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email não é válido")
    private String email;
    @NotBlank(message = "A senha é obrigatória")
    private String senha;
    private String endereco;
}
