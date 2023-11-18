package techdonne.ifma.dcomp.util;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMFactory {
    public static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("digital_rental_project");
    }

    public EntityManager getEntityManger(){
        return factory.createEntityManager();
    }

    public void close(){
        factory.close();
    }
}
