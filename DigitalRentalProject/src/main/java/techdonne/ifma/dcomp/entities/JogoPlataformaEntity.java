package techdonne.ifma.dcomp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
@Entity
@Builder
@Table(name="jogo_plataforma")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class JogoPlataformaEntity {
    @EqualsAndHashCode.Include
    @EmbeddedId
    private JogoPlataformaEntityPK id;
    @Getter @Column(name="preco_diario")
    private BigDecimal precoDiario;
}
