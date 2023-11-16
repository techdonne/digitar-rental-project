package techdonne.ifma.dcomp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Table(name="jogo")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class JogoEntity implements EntidadeBaseEntity{
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;
    @Getter @Setter
    private String titulo;
    @Getter
    @OneToMany(mappedBy = "id.jogoEntity", cascade = CascadeType.ALL)
    private Set<JogoPlataformaEntity> jogos_da_plataforma = new HashSet<>();

    public void adiciona(JogoPlataformaEntity jogoPlataformaEntity){
        this.jogos_da_plataforma.add(jogoPlataformaEntity);
    }

}
