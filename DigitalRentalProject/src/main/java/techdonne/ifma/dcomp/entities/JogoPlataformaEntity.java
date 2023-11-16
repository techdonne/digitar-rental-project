package techdonne.ifma.dcomp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="jogo_plataforma")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class JogoPlataformaEntity {
    @EqualsAndHashCode.Include
    @EmbeddedId @Getter
    private JogoPlataformaEntityPK id = new JogoPlataformaEntityPK();
    @Getter @Column(name="preco_diario") @Setter
    private BigDecimal precoDiario;

    public void setJogo(JogoEntity jogo){
        this.id.setJogoEntity(jogo);
    }
    public void setPlataforma(PlataformaEntity plataforma){
        id.setPlataformaEntity(plataforma);
    }
}
