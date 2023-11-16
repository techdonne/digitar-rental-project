package techdonne.ifma.dcomp.repositories;

import jakarta.persistence.EntityManager;
import techdonne.ifma.dcomp.entities.ClienteEntity;
import techdonne.ifma.dcomp.entities.JogoEntity;

public class ClienteRepository {
    private final DAOGenerico<ClienteEntity> daoGenerico;

    public ClienteRepository(EntityManager entityManager) {
        this.daoGenerico = new DAOGenerico<ClienteEntity>(entityManager);
    }

    public ClienteEntity salvar(ClienteEntity cliente){
        return daoGenerico.salvar(cliente);
    }

    public ClienteEntity buscarPorId(Integer id){
        return this.daoGenerico.buscarPorId(ClienteEntity.class, id);
    }

}
