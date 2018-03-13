package painelgm.data;

import painelgm.model.ListaEventos;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import painelgm.model.Evento;
import painelgm.model.Usuario;

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
        return em.createQuery("select le from ListaEventos le order by le.dataEvento desc", ListaEventos.class).getResultList();
    }
    
    public ListaEventos excluir(Long id){
        ListaEventos listaEventos = em.find(ListaEventos.class,id);
        em.remove(listaEventos);
        return listaEventos;
    }
    
    public ListaEventos atualizar(Long id, ListaEventos listaEventosAtualizada){
        ListaEventos listaEventos = findById(id);
        listaEventos.setChecked(listaEventosAtualizada.isChecked());
        listaEventos.setDataEvento(listaEventosAtualizada.getDataEvento());
        listaEventos.setGameMaster(listaEventosAtualizada.getGameMaster());
        listaEventos.associar(listaEventosAtualizada.getGameMaster());

        em.merge(listaEventos);
        return listaEventos;
    }
    
     public ListaEventos conferida(Long id){
        ListaEventos listaEventos = findById(id);
        listaEventos.setChecked(true);
       /* listaEventos.associar(); */

        em.merge(listaEventos);
        return listaEventos;
    }

   public List<ListaEventos> findListFromUser(Usuario usuario) {
        //select le from ListaEventos le left join fetch le.eventos where le.usuario = :usuario order by le.dataEvento desc
        /* return em.createNativeQuery("select le from ListaEventos le left join fetch le.eventos where le.usuario = :usuario order by le.dataEvento desc", ListaEventos.class)
                 .setParameter("usuario", usuario)
                 .getResultList(); */
        
        Query query = em.createQuery("select le from ListaEventos le where le.usuario = :usuario order by le.dataEvento desc", ListaEventos.class)
                .setParameter("usuario", usuario);
        List<ListaEventos> lista = query.getResultList();
        return lista;
      
   }
 
     
}

