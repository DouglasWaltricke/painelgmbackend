package painelgm.service;

import painelgm.model.ListaEventos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateless
public class ListaEventoService {

    private Logger log = Logger.getLogger(ListaEventoService.class.getName());

    @Inject
    private EntityManager em;

    public void cadastrarListaEvento(ListaEventos listaEvento) {
        em.persist(listaEvento);
        log.info("Objeto salvo: " + listaEvento);
    }
}
