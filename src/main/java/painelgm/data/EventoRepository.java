package painelgm.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import painelgm.model.Divulgacao;
import painelgm.model.Evento;
import painelgm.model.Usuario;


/**
 *
 * @author goga
 */
@Stateless
public class EventoRepository {
    @Inject
    @PersistenceContext(unitName="PainelgmPU")
    private EntityManager em;
    
    public List<Object> getVencedores(){
        return em.createQuery("select sum(premiacao), player from Evento group by player order by sum(premiacao) desc").setMaxResults(3).getResultList();

    }
    
    public void resetar(){
        Query query = em.createQuery("delete from Evento");
        query.executeUpdate();
    }
    
    
}
