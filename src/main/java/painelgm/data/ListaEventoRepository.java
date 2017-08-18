package painelgm.data;

import painelgm.model.ListaEventos;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Stateless
public class ListaEventoRepository {

    @Inject
    @PersistenceContext(unitName="PainelgmPU")
    private EntityManager em;

    public ListaEventos findById(Long id) {
        return em.createQuery("select le from ListaEventos le left join fetch le.eventos where le.id = :id", ListaEventos.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<ListaEventos> findAll() {
        return em.createQuery("select le from ListaEventos le left join fetch le.eventos", ListaEventos.class).getResultList();
    }
    
    public ListaEventos excluir(Long id){
        ListaEventos listaEventos = em.find(ListaEventos.class,id);
        em.remove(listaEventos);
        return listaEventos;
    }
    
    public ListaEventos atualizar(Long id, ListaEventos listaeventosAtualizada){
        ListaEventos listaEventos = findById(id);
        listaEventos.setChecked(listaeventosAtualizada.isChecked());
        listaEventos.setDataEvento(listaeventosAtualizada.getDataEvento());
        listaEventos.setGameMaster(listaeventosAtualizada.getGameMaster());
        listaEventos.associar();
        
        return listaEventos;
    }
}
