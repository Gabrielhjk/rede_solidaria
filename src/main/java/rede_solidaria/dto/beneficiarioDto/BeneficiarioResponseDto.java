package rede_solidaria.dto.beneficiarioDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import rede_solidaria.database.model.enums.NivelPrioridade;
import rede_solidaria.database.model.enums.TipoBeneficiario;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
public class BeneficiarioResponseDto {
    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    @NotBlank
    @Email
    private String email;
    private String endereco;
    @NotBlank
    private TipoBeneficiario tipoBeneficiario; 
    @NotBlank
    private NivelPrioridade nivelPrioridade; 
}   
