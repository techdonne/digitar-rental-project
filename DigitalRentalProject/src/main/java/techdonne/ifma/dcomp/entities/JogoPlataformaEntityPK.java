package techdonne.ifma.dcomp.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public @Data class JogoPlataformaEntityPK{
    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private JogoEntity jogoEntity;
    @ManyToOne
    @JoinColumn(name="plataforma_id")
    private PlataformaEntity plataformaEntity;
}
