package techdonne.ifma.dcomp.teste.jogos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import techdonne.ifma.dcomp.entities.PlataformaEntity;
import techdonne.ifma.dcomp.repositories.PlataformaRepository;
import techdonne.ifma.dcomp.util.EMFactory;


public class CadastroDePlataforma {
    public static final EMFactory factory = new EMFactory();
    public static void main(String[] args) {
        EntityManager manager = factory.getEntityManger();

        PlataformaEntity plataforma1 = PlataformaEntity.builder().nome("Xbox").build();
        PlataformaEntity plataforma2 = PlataformaEntity.builder().nome("PS3").build();
        PlataformaEntity plataforma3 = PlataformaEntity.builder().nome("PS4").build();
        PlataformaEntity plataforma4 = PlataformaEntity.builder().nome("PC").build();

        manager.getTransaction().begin();

        PlataformaRepository plataformaRepository = new PlataformaRepository(manager);

        plataformaRepository.salvar(plataforma1);
        plataformaRepository.salvar(plataforma2);
        plataformaRepository.salvar(plataforma3);
        plataformaRepository.salvar(plataforma4);

        manager.getTransaction().commit();

        manager.close();

        factory.close();
    }
}
