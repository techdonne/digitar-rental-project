package techdonne.ifma.dcomp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Collection;

@Entity
@Table(name= "acessorio")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AcessorioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @ManyToMany(mappedBy = "acessorios", cascade = CascadeType.ALL)
    private Collection<ConsoleEntity> consoles;
}
