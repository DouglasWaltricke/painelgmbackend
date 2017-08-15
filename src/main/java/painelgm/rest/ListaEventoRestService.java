package painelgm.rest;

import painelgm.data.ListaEventoRepository;
import painelgm.model.ListaEventos;
import painelgm.service.ListaEventoService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

@Path("/listaeventos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ListaEventoRestService {

    @Inject
    private ListaEventoService listaEventoService;

    @Inject
    private ListaEventoRepository listaEventoRepository;

    @GET
    public List<ListaEventos> listar() {
        return listaEventoRepository.findAll();
    }

    @POST
    public ListaEventos adicionar(ListaEventos listaEventos) {
        listaEventoService.cadastrarListaEvento(listaEventos);
        return listaEventos;
    }
    
    @DELETE
    @Path("{id}")
     public Long excluir(@PathParam("id") Long id){
         listaEventoRepository.excluir(id);
         return id;
       }
   
    @GET
    @Path("{id}")
    public ListaEventos getListaEventos(@PathParam("id") Long id){
        return listaEventoRepository.findById(id);
        
    }
    
    @PUT
    @Path("{id}")
    public ListaEventos atualizar(@PathParam("id") Long id, ListaEventos listaEventos){
        return listaEventoRepository.atualizar(id, listaEventos);
    }
    
    
}
