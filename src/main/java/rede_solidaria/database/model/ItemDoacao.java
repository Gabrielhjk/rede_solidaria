package rede_solidaria.database.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import rede_solidaria.database.model.enums.StatusItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "item_doacao")
public class ItemDoacao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false)
    private String nomeItem;
    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false, length = 255)
    private String descricao;
    @Column(nullable = false)
    private Integer quantidade;
    @Column(nullable = false)
    private String estadoDeConversao;
    @Column(nullable = false) 
    private StatusItem statusItem;
    @CreationTimestamp
    private LocalDateTime dataDoacao;

    @OneToMany(mappedBy = "itemDoacao")
    @Builder.Default
    private Set<Solicitacao> solicitacoes = new HashSet<>();

    @ManyToOne
    @JoinColumn(table = "doador_id")
    private Doador doador;
}
