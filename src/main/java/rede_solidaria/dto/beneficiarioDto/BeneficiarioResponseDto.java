package rede_solidaria.dto.beneficiarioDto;

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
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private TipoBeneficiario tipoBeneficiario; 
    private NivelPrioridade nivelPrioridade; 
}   
