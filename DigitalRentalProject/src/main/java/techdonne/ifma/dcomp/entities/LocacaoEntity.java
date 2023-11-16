package techdonne.ifma.dcomp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;

@Entity
@Table(name = "locacao")
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public @AllArgsConstructor class LocacaoEntity implements EntidadeBaseEntity{
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Getter
    private Integer id;
    @Temporal(TemporalType.DATE) @Getter
    private LocalDate data;

    @ManyToOne()
    @JoinColumn(name = "cliente_id", nullable = false) @Setter @Getter
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "id.locacaoEntity", cascade = CascadeType.ALL) @Getter
    private Set<ItemLocacaoEntity> itens = new HashSet<>();

    @PrePersist
    private void setData(){
        this.data = LocalDate.now();
    }

    public void adiciona(ItemLocacaoEntity itemLocacaoEntity){
        this.itens.add(itemLocacaoEntity);
    }

    public BigDecimal preco_total_da_locacao(){
        ToDoubleFunction<ItemLocacaoEntity> map = value ->
                value.getId().getJogoPlataformaEntity().getPrecoDiario()
                        .multiply(new BigDecimal(value.getDias()))
                        .multiply(new BigDecimal(value.getQuantidade()))
                        .doubleValue();

        double soma = itens.stream().mapToDouble(map).sum();

        return BigDecimal.valueOf(soma);
    }

}
