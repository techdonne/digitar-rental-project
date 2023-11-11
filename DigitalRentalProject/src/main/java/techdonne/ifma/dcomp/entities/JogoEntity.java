package techdonne.ifma.dcomp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Table(name="jogo")
@AllArgsConstructor
@NoArgsConstructor
public @Data class JogoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
}
