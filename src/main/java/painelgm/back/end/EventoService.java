/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package painelgm.back.end;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

@Stateless
@Path("eventos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventoService {

    @PersistenceContext(unitName = "PainelgmPU")
    private EntityManager entityManager;

    public EventoService() {

    }

    @GET
    public List<Evento> getEvento() {
        Query query = entityManager.createQuery("SELECT eventos FROM Evento eventos");
        return query.getResultList();
    }

    @POST
    public Evento adicionar(Evento evento) {
        entityManager.persist(evento);
        return evento;
    }

    @PUT
    @Path("{id}")
    public Evento atualizar(@PathParam("id") Integer id, Evento eventoAtualizado) {
        Evento eventoEncontrado = getEvento(id);
        eventoEncontrado.setNickPlayer(eventoAtualizado.getNickPlayer());
        eventoEncontrado.setNomeEvento(eventoAtualizado.getNomeEvento());
        eventoEncontrado.setPremiacao(eventoAtualizado.getPremiacao());
        eventoEncontrado.setPrintUrl(eventoAtualizado.getPrintUrl());
        entityManager.merge(eventoEncontrado);

        return eventoEncontrado;
    }

    @DELETE
    @Path("{id}")
    public Evento excluir(@PathParam("id") Integer id) {
        Evento evento = getEvento(id);
        entityManager.remove(evento);
        return evento;
    }

    @GET
    @Path("{id}")
    public Evento getEvento(@PathParam("id") Integer id) {
        return entityManager.find(Evento.class, id);
    }
}
