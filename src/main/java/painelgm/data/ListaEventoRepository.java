package painelgm.data;

import painelgm.model.ListaEventos;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ListaEventoRepository {

    @Inject
    private EntityManager em;

    public ListaEventos findById(Long id) {
        return em.createQuery("select le from ListaEventos le left join fetch le.eventos where le.id = :id", ListaEventos.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<ListaEventos> findAll() {
        return em.createQuery("select le from ListaEventos le left join fetch le.eventos", ListaEventos.class)
                .getResultList();
    }
}
