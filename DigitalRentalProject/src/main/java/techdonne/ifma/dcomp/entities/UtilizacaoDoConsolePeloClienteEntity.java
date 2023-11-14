package techdonne.ifma.dcomp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "utilizacao_do_console_pelo_cliente")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public @Data class UtilizacaoDoConsolePeloClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP) @Getter
    private LocalDateTime inicio;
    @Temporal(TemporalType.TIMESTAMP) @Getter
    private LocalDateTime fim;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "console_id")
    private ConsoleEntity console;
}
