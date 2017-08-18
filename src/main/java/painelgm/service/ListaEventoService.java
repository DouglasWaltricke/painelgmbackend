package painelgm.service;

import painelgm.model.ListaEventos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import painelgm.model.Usuario;

@Stateless
public class ListaEventoService {

    @Inject
    @PersistenceContext(unitName="PainelgmPU")
    private EntityManager em;
    
    public void cadastrarListaEvento(ListaEventos listaEvento,Usuario usuario) {
        listaEvento.setUsuario(usuario);
        listaEvento.associar();
        em.persist(listaEvento);
    }
}
