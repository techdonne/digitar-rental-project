package techdonne.ifma.dcomp.teste;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import techdonne.ifma.dcomp.entities.JogoEntity;
import techdonne.ifma.dcomp.entities.JogoPlataformaEntity;
import techdonne.ifma.dcomp.entities.JogoPlataformaEntityPK;
import techdonne.ifma.dcomp.entities.PlataformaEntity;
import techdonne.ifma.dcomp.repositories.JogoRepository;

import java.math.BigDecimal;

public class InserirJogo {
    private static JogoRepository jogoRepository;
    private static EntityManager manager;
    private static EntityManagerFactory factory;
    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory("digital_rental_project");
        manager = factory.createEntityManager();

        JogoEntity jogo = JogoEntity.builder().titulo("GOD OF WAR").build();

        /*PlataformaEntity plataforma = PlataformaEntity.builder().nome("Xbox").build();

        JogoPlataformaEntityPK id = new JogoPlataformaEntityPK(jogo, plataforma);

        JogoPlataformaEntity jogoPlataformaEntity = JogoPlataformaEntity.
                builder()
                .id(id)
                .precoDiario(new BigDecimal(1000)).
                build();*/

        manager.getTransaction().begin();
        
        jogoRepository = new JogoRepository(manager);

        jogoRepository.save(jogo);


        manager.getTransaction().commit();

        manager.close();

        factory.close();
;
    }


}