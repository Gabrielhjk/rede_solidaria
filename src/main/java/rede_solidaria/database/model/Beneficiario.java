package rede_solidaria.database.model;

import rede_solidaria.database.model.enums.NivelPrioridade;
import rede_solidaria.database.model.enums.TipoBeneficiario;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Entity
@Table(name = "beneficiarios")
public class Beneficiario extends Usuario{
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoBeneficiario tipoBeneficiario;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false) 
    private NivelPrioridade nivelPrioridade; 

    @OneToMany(mappedBy = "beneficiario")
    @Builder.Default
    private Set<Solicitacao> solicitacoes = new HashSet<>();
}
