package painelgm.data;

import painelgm.model.ListaEventos;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ListaEventoRepository {

    @Inject
    private EntityManager em;

    public ListaEventos findById(Long id) {
        return em.find(ListaEventos.class, id);
    }
}
