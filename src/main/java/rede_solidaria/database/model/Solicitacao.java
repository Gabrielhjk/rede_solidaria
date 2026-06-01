package rede_solidaria.database.model;

import rede_solidaria.database.model.enums.StatusSolicitacao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "solicitacoes")
public class Solicitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false)
    private Integer quantidadeSolicitada;
    @Column(length = 255)
    private String justificativa;
    @Column(nullable = false)
    private StatusSolicitacao statusSolicitacao;

    @ManyToOne
    @JoinColumn(name = "item_doacao_id")
    private ItemDoacao itemDoacao;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;
}
