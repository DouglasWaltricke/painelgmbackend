package painelgm.rest;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.hibernate.engine.spi.Status;
import painelgm.data.DivulgacaoRepository;
import painelgm.data.EventoRepository;
import painelgm.data.UsuarioRepository;
import painelgm.model.Divulgacao;
import painelgm.model.Evento;
import painelgm.model.Usuario;
import painelgm.service.DivulgacaoService;

@Path("/eventos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

@Stateless
public class EventoRestService {
    
    @Inject
    private EventoRepository eventoRepository;
    
    @GET
    public List<Object> getVencedores(){
        return eventoRepository.getVencedores();
    }
    
    @POST
    @Path("/resetar")
    public Status excluir(){
        eventoRepository.resetar();
        return Status.DELETED;
    }
}
