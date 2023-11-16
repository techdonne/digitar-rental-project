package techdonne.ifma.dcomp.teste.jogos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import techdonne.ifma.dcomp.entities.JogoEntity;
import techdonne.ifma.dcomp.entities.JogoPlataformaEntity;
import techdonne.ifma.dcomp.entities.JogoPlataformaEntityPK;
import techdonne.ifma.dcomp.entities.PlataformaEntity;
import techdonne.ifma.dcomp.repositories.JogoRepository;
import techdonne.ifma.dcomp.repositories.PlataformaRepository;

import java.math.BigDecimal;

public class CadastroDeJogos {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("digital_rental_project");
        EntityManager manager = factory.createEntityManager();

        JogoEntity jogo = JogoEntity.builder().titulo("GOD OF WAR").build();

        manager.getTransaction().begin();

        JogoRepository jogoRepository = new JogoRepository(manager);

        jogoRepository.salvar(jogo);

        manager.getTransaction().commit();

        manager.close();

        factory.close();
    }


}