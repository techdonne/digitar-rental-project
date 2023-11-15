package techdonne.ifma.dcomp.repositories;

import jakarta.persistence.EntityManager;
import techdonne.ifma.dcomp.entities.EntidadeBaseEntity;
import java.util.Objects;

class DAOGenerico<T extends EntidadeBaseEntity> {
    private final EntityManager entidadeManager;

    public DAOGenerico(EntityManager entidadeManager) {
        this.entidadeManager = entidadeManager;
    }

    T buscarPorId(Class<T> classe, Integer id){
        return this.entidadeManager.find(classe, id);
    }

    T buscarTodos(Class<T> classe){
        return this.entidadeManager.find(classe, null);
    }

    T salvar(T t){
        if (Objects.isNull(t.getId())){
            this.entidadeManager.persist(t);
        }else {
            this.entidadeManager.merge(t);
        }
        return t;
    }

    void remove(T t){
        this.entidadeManager.remove(t);
    }
}
