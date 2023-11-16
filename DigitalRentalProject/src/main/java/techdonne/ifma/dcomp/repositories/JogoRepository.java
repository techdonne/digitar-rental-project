package techdonne.ifma.dcomp.repositories;

import jakarta.persistence.EntityManager;
import techdonne.ifma.dcomp.entities.JogoEntity;

import java.util.List;
import java.util.Objects;

public class JogoRepository {
    private final DAOGenerico<JogoEntity> daoGenerico;
    public JogoRepository(EntityManager manager) {
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public JogoEntity salvar(JogoEntity jogoEntity){
        return this.daoGenerico.salvar(jogoEntity);
    }

    public JogoEntity buscarPorId(Integer id){
        return this.daoGenerico.buscarPorId(JogoEntity.class, id);
    }

    public JogoEntity buscaPor(String titulo) {
        return this.daoGenerico.getEntidadeManager().createQuery("from jogo " +
                        "where upper(titulo) like :titulo", JogoEntity.class)
                .setParameter("titulo", titulo.toUpperCase() + "%")
                .getResultList().get(0);
    }
}
