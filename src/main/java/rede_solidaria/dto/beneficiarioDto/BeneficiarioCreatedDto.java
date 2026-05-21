package rede_solidaria.dto.beneficiarioDto;

import rede_solidaria.database.model.enums.NivelPrioridade;
import rede_solidaria.database.model.enums.TipoBeneficiario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class BeneficiarioCreatedDto {
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
    @NotNull(message = "O tipo de beneficiário é obrigatório")
    private TipoBeneficiario tipoBeneficiario;
    @NotNull(message = "O nível de prioridade é obrigatório")
    private NivelPrioridade nivelPrioridade;
}
