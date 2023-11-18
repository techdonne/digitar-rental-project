package techdonne.ifma.dcomp.teste.locacaodejogos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import techdonne.ifma.dcomp.entities.*;
import techdonne.ifma.dcomp.repositories.ClienteRepository;
import techdonne.ifma.dcomp.repositories.JogoRepository;
import techdonne.ifma.dcomp.repositories.LocacaoRepository;
import techdonne.ifma.dcomp.util.EMFactory;

import java.util.List;

public class LocacaoDosJogosPeloCliente {
    public static final EMFactory factory = new EMFactory();
    public static void main(String[] args) {
            EntityManager entityManager = factory.getEntityManger();

            entityManager.getTransaction().begin();

            ClienteRepository clienteRepository = new ClienteRepository(entityManager);
            JogoRepository jogoRepository = new JogoRepository(entityManager);
            LocacaoRepository locacaoRepository = new LocacaoRepository(entityManager);

            //buscando Cliente com ID = 1
            ClienteEntity cliente = clienteRepository.buscarPorId(1);

            String nomeDoJogo = "god of war";
            String nomeDaPlataforma  = "Xbox";

            //O cliente decide alocar o jogo GOD OF WAR
            JogoEntity jogo = jogoRepository.buscarPorId(1);

            //Vamos criar a Locacao e vincular ao cliente com ID = 1
            LocacaoEntity locacaoEntity = new LocacaoEntity();
            locacaoEntity.setCliente(cliente);

            //agora vamos escolher qual a plataforma que vamos alocar do jogo
            //escolheremos a plataforma 'Xbox' que está vinculada a o jogo GOD OF WAR

            JogoPlataformaEntity jogoPlataformaEntity = jogo.getJogos_da_plataforma().stream().
                    filter(x -> x.getId().getPlataformaEntity().
                            getNome().equalsIgnoreCase(nomeDaPlataforma)).
                    findFirst().orElse(null);

            //criando o item de locacao
            ItemLocacaoEntity itemLocacao = new ItemLocacaoEntity();

            itemLocacao.setId(jogoPlataformaEntity, locacaoEntity);
            itemLocacao.setDias(10);
            itemLocacao.setQuantidade(2);

            //vinculando o item de locacao a locacao
            locacaoEntity.adiciona(itemLocacao);

            //Salvando a locacao
            locacaoRepository.salvar(locacaoEntity);

            entityManager.getTransaction().commit();

            System.out.println("O valor da locação é = " + locacaoEntity.preco_total_da_locacao().doubleValue());

            entityManager.close();
            factory.close();
    }
}
