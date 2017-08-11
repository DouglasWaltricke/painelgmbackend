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
}
