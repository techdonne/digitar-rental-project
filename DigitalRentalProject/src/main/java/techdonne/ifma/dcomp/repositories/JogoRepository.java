package techdonne.ifma.dcomp.repositories;

import jakarta.persistence.EntityManager;
import techdonne.ifma.dcomp.entities.JogoEntity;
import java.util.Objects;

public class JogoRepository {
    private final DAOGenerico<JogoEntity> daoGenerico;
    public JogoRepository(EntityManager manager) {
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public JogoEntity salvar(JogoEntity jogoEntity){
        return this.daoGenerico.salvar(jogoEntity);
    }

    public JogoEntity buscarPorId(Class<JogoEntity> classe, Integer id){
        return this.daoGenerico.buscarPorId(classe, id);
    }
}
