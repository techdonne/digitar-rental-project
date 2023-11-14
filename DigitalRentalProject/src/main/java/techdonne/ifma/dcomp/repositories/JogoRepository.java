package techdonne.ifma.dcomp.repositories;

import jakarta.persistence.EntityManager;
import techdonne.ifma.dcomp.entities.JogoEntity;
import java.util.Objects;

public class JogoRepository {
    private final EntityManager manager;

    public JogoRepository(EntityManager manager){
        this.manager = manager;
    }

    public JogoEntity save(JogoEntity jogoEntity){
        if (Objects.isNull(jogoEntity.getId())){
            this.manager.persist(jogoEntity);
        }else{
            jogoEntity = this.manager.merge(jogoEntity);
        }
        return jogoEntity;
    }
}
