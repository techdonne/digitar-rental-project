package techdonne.ifma.dcomp.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "item_locacao")
public class ItemLocacaoEntity {
    @EmbeddedId
    private ItemLocacaoPK id;
    private Integer dias;
    private Integer quantidade = 1;
}
