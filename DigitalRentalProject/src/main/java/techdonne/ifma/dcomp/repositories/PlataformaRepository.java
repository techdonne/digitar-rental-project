package techdonne.ifma.dcomp.repositories;

import jakarta.persistence.EntityManager;
import lombok.Builder;
import techdonne.ifma.dcomp.entities.EntidadeBaseEntity;
import techdonne.ifma.dcomp.entities.PlataformaEntity;

public class PlataformaRepository {
    private final DAOGenerico<PlataformaEntity> daoGenerico;

    public PlataformaRepository(EntityManager entityManager){
        daoGenerico = new DAOGenerico<>(entityManager);
    }

    public PlataformaEntity salvar(PlataformaEntity plataformaEntity){
        return daoGenerico.salvar(plataformaEntity);
    }

    public PlataformaEntity buscarPorId(Class<PlataformaEntity> classe, Integer id){
        return this.daoGenerico.buscarPorId(classe, id);
    }
}
