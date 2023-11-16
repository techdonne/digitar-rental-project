package techdonne.ifma.dcomp.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "item_locacao")
public class ItemLocacaoEntity {
    @EmbeddedId
    private ItemLocacaoPK id = new ItemLocacaoPK();
    private Integer dias;
    private Integer quantidade = 1;

    public void setId(JogoPlataformaEntity jogoPlataformaEntity, LocacaoEntity locacaoEntity){
        this.id.setLocacaoEntity(locacaoEntity);
        this.id.setJogoPlataformaEntity(jogoPlataformaEntity);
    }
}
