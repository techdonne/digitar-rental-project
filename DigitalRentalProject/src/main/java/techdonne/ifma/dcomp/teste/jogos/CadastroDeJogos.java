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
import techdonne.ifma.dcomp.util.EMFactory;

import java.math.BigDecimal;
import java.util.HashSet;

public class CadastroDeJogos {
    public static final EMFactory factory = new EMFactory();
    public static void main(String[] args) {
        EntityManager manager = factory.getEntityManger();
        //criando o jogo
        JogoEntity jogo = new JogoEntity(null , "GOD OF WAR", new HashSet<>());

        manager.getTransaction().begin(); // comeco de transação

        //objetos de repositótio de plataforma e jogo
        PlataformaRepository plataformaRepository = new PlataformaRepository(manager);
        JogoRepository jogoRepository = new JogoRepository(manager);

        //buscando plataforma de id = 1 e id = 2
        PlataformaEntity plataforma1 = plataformaRepository.buscarPorId(PlataformaEntity.class, 1);
        PlataformaEntity plataforma2 = plataformaRepository.buscarPorId(PlataformaEntity.class, 2);

        JogoPlataformaEntity jogoPlataformaEntity1 = new JogoPlataformaEntity();

        jogoPlataformaEntity1.setPrecoDiario(new BigDecimal(10));
        jogoPlataformaEntity1.setJogo(jogo);
        jogoPlataformaEntity1.setPlataforma(plataforma1);

        JogoPlataformaEntity jogoPlataformaEntity2 = new JogoPlataformaEntity();

        jogoPlataformaEntity2.setPrecoDiario(new BigDecimal(12));
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