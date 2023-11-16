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
import java.util.Set;

public class AdicionarPrecosDoJogoNaPlataforma {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("digital_rental_project");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        PlataformaRepository plataformaRepository = new PlataformaRepository(manager);
        JogoRepository jogoRepository = new JogoRepository(manager);

        JogoEntity jogo = jogoRepository.buscarPorId(1);

        PlataformaEntity plataforma1 = plataformaRepository.buscarPorId(PlataformaEntity.class, 1);
        PlataformaEntity plataforma2 = plataformaRepository.buscarPorId(PlataformaEntity.class, 2);

        JogoPlataformaEntity jogoPlataformaEntity1 = new JogoPlataformaEntity();

        jogoPlataformaEntity1.setPrecoDiario(new BigDecimal(1000));
        jogoPlataformaEntity1.setJogo(jogo);
        jogoPlataformaEntity1.setPlataforma(plataforma1);

        JogoPlataformaEntity jogoPlataformaEntity2 = new JogoPlataformaEntity();

        jogoPlataformaEntity2.setPrecoDiario(new BigDecimal(1200));
        jogoPlataformaEntity2.setJogo(jogo);
        jogoPlataformaEntity2.setPlataforma(plataforma2);

        jogo.adiciona(jogoPlataformaEntity1);
        jogo.adiciona(jogoPlataformaEntity2);

        jogoRepository.salvar(jogo);

        manager.getTransaction().commit();

        manager.close();

        factory.close();
    }
}
