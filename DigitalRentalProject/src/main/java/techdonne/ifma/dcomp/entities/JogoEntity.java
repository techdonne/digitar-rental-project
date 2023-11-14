package techdonne.ifma.dcomp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Table(name="jogo")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public @Data class JogoEntity {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
}
