package techdonne.ifma.dcomp.repositories;

import jakarta.persistence.EntityManager;
import techdonne.ifma.dcomp.entities.LocacaoEntity;

public class LocacaoRepository {
    private final DAOGenerico<LocacaoEntity> daoGenerico;

    public LocacaoRepository(EntityManager entityManager) {
        this.daoGenerico = new DAOGenerico<>(entityManager);
    }

    public LocacaoEntity salvar(LocacaoEntity locacaoEntity){
        return this.daoGenerico.salvar(locacaoEntity);
    }
}
