package techdonne.ifma.dcomp.teste.cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import techdonne.ifma.dcomp.entities.ClienteEntity;
import techdonne.ifma.dcomp.repositories.ClienteRepository;
import techdonne.ifma.dcomp.util.EMFactory;

public class CadastroDeClientes {
    private static final EMFactory factory = new EMFactory();
    public static void main(String[] args) {
        //Questão 1: cadastrar cliente

        EntityManager entityManager = factory.getEntityManger();

        ClienteEntity cliente = new ClienteEntity(null, "Daniel Araújo", "daniel@dominio.com", "98 98989-9831", "1234");

        entityManager.getTransaction().begin();

        ClienteRepository repository = new ClienteRepository(entityManager);

        repository.salvar(cliente);

        entityManager.getTransaction().commit();

        entityManager.close();

        factory.close();

    }
}
