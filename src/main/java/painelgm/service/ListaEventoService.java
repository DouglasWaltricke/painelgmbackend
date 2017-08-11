package painelgm.service;

import painelgm.model.ListaEventos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class ListaEventoService {

    @Inject
    private EntityManager em;

    public void cadastrarListaEvento(ListaEventos listaEvento) {
        listaEvento.associar();
        em.persist(listaEvento);
    }
}
