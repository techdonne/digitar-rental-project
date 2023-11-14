package techdonne.ifma.dcomp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "console")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public @Data class ConsoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(name="preco_por_hora")
    private BigDecimal precoPorHora;

    @ManyToMany()
    @JoinTable(name = "acessorio_console",
                joinColumns = @JoinColumn(name="console_id"),
                inverseJoinColumns = @JoinColumn(name = "acessorio_id"))
    private Collection<AcessorioEntity> acessorios;
}
