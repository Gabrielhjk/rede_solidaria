package rede_solidaria.dto;

import rede_solidaria.database.model.enums.NivelPrioridade;
import rede_solidaria.database.model.enums.TipoBeneficiario;


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
public class BeneficiarioDto {
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private String endereco;
    private TipoBeneficiario tipoBeneficiario; 
    private NivelPrioridade nivelPrioridade; 
}
