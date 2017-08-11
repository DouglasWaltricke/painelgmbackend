/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package painelgm.back.end;

import painelgm.model.Evento;
import painelgm.model.ListaEventos;
import painelgm.service.ListaEventoService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author goga
 */

/*





Transferir todos os métodos abaixo para ListaEventosRestService.java








 */

/*@Stateless
@Path("listaeventos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)*/
public class ListaEventosService {

    /*@PersistenceContext(unitName = "PainelgmPU")
    private EntityManager entityManager;

    @Inject
    private ListaEventoService listaEventoService;

    public ListaEventosService() {
    }

    @GET
    public List<ListaEventos> getListaEventos() {
        Query query = entityManager.createQuery("SELECT lista FROM ListaEventos lista");
        return query.getResultList();
    }

    @POST
    public ListaEventos adicionar(ListaEventos listaEventos) {
        listaEventoService.cadastrarListaEvento(listaEventos);
        return listaEventos;
    }

    @PUT
    @Path("{id}")
    public ListaEventos atualizar(@PathParam("id") Integer id, ListaEventos listaEventosAtualizada) {
        ListaEventos listaEventosEncontrada = getListaEventos(id);
        listaEventosEncontrada.setGameMaster(listaEventosAtualizada.getGameMaster());
        listaEventosEncontrada.setDataEvento(listaEventosAtualizada.getDataEvento());
        listaEventosEncontrada.setChecked(listaEventosAtualizada.isChecked());
        entityManager.merge(listaEventosEncontrada);

        return listaEventosEncontrada;
    }

    @DELETE
    @Path("{id}")
    public ListaEventos excluir(@PathParam("id") Integer id) {
        ListaEventos lista = getListaEventos(id);
        entityManager.remove(lista);
        return lista;
    }

    @GET
    @Path("{id}")
    public ListaEventos getListaEventos(@PathParam("id") Integer id) {
        return entityManager.find(ListaEventos.class, id);
    }

    @GET
    @Path("{id}/eventos")
    public List<Evento> getEventos(@PathParam("id") Integer id) {
        TypedQuery<Evento> query = entityManager.createQuery("select e from Evento e where e.listaEventos.id = :id", Evento.class);
        query.setParameter("id", id);
        List<Evento> eventosTemp = query.getResultList();
        return eventosTemp;
    }*/
}
