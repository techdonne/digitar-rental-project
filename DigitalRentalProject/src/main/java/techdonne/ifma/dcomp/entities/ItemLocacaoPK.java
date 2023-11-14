package techdonne.ifma.dcomp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Embeddable
@AllArgsConstructor
public class ItemLocacaoPK {
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="jogo_id", referencedColumnName = "jogo_id"),
            @JoinColumn(name="plataforma_id", referencedColumnName = "plataforma_id")
    })
    private JogoPlataformaEntity jogoPlataformaEntity;

    @ManyToOne
    @JoinColumn(name = "locacao_id")
    private LocacaoEntity locacaoEntity;
}
