package techdonne.ifma.dcomp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "locacao")
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public @Data @AllArgsConstructor class LocacaoEntity {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.DATE) @Getter
    private LocalDate data;

    @ManyToOne()
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;

    @PrePersist
    private void setData(){
        this.data = LocalDate.now();
    }

}
