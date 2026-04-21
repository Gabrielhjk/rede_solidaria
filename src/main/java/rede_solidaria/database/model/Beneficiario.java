package rede_solidaria.database.model;

import rede_solidaria.database.model.enums.NivelPrioridade;
import rede_solidaria.database.model.enums.TIpoBeneficiario;


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
public class Beneficiario extends Usuario{
    private TIpoBeneficiario tipoBeneficiario; 
    private NivelPrioridade nivelPrioridade; 
}
