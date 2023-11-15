package techdonne.ifma.dcomp.teste;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import techdonne.ifma.dcomp.entities.ClienteEntity;
import techdonne.ifma.dcomp.repositories.ClienteRepository;

public class ClienteTeste {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static ClienteEntity cliente;
    private static ClienteRepository repository;
    public static void main(String[] args) {
        //Questão 1: cadastrar cliente

        entityManagerFactory = Persistence.createEntityManagerFactory("digital_rental_project");
        entityManager = entityManagerFactory.createEntityManager();

        cliente = new ClienteEntity(null, "Daniel Araújo", "daniel@dominio.com", "98 98989-9831", "1234");

        entityManager.getTransaction().begin();

        repository = new ClienteRepository(entityManager);

        repository.salvar(cliente);

        entityManager.getTransaction().commit();

        entityManager.close();

        entityManagerFactory.close();

    }
}
