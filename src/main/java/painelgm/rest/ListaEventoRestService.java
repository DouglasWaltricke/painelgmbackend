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
import painelgm.data.UsuarioRepository;
import painelgm.model.Usuario;

@Path("/listaeventos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ListaEventoRestService {

    @Inject
    private ListaEventoService listaEventoService;

    @Inject
    private ListaEventoRepository listaEventoRepository;
    
    @Inject
    UsuarioRepository usuarioRepository;


    @GET
    @Path("/findListFromUser/{codigoUsuario}")
    public List<ListaEventos> listar(@PathParam("codigoUsuario") Long codigoUsuario) {
        Usuario usuario = usuarioRepository.findByID(codigoUsuario);
        if(usuario.getAdministrador() == true){
           return listaEventoRepository.findAll(); 
        } else {
            return listaEventoRepository.findListFromUser(usuario);
        }
        
    }

    @POST
    public ListaEventos adicionar(ListaEventos listaEventos) {
        Usuario usuario = usuarioRepository.findByID(listaEventos.codigoUsuario);
        listaEventoService.cadastrarListaEvento(listaEventos,usuario);
        return listaEventos;
    }
    
    @PUT
    @Path("/conferir")
    public ListaEventos conferida(ListaEventos listaEventos){
       return listaEventoRepository.conferida(listaEventos.getId());
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
        listaEventoRepository.excluir(id);
        Usuario usuario = usuarioRepository.findByID(listaEventos.getUsuario().getId()); 
        listaEventos.setId(null);
        listaEventos.setUsuario(null);
        listaEventoService.cadastrarListaEvento(listaEventos, usuario);
        return listaEventos;
    }
    
    
}
