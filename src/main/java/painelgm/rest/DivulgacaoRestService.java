/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import painelgm.data.DivulgacaoRepository;
import painelgm.data.UsuarioRepository;
import painelgm.model.Divulgacao;
import painelgm.service.DivulgacaoService;

/**
 *
 * @author goga
 */

@Path("/divulgacao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class DivulgacaoRestService {
    
    @Inject
    private DivulgacaoRepository divulgacaoRepository;
    
    @Inject
    private DivulgacaoService divulgacaoService;
    
    @Inject
    UsuarioRepository usuarioRepository;
    
    @GET
    public List<Divulgacao> lista(){
        return divulgacaoRepository.findAll();
    }
    
    @POST
    public Divulgacao adicionar(Divulgacao divulgacao){
        return divulgacaoService.cadastrarDivulgacao(divulgacao);
    }
    
    @DELETE
    @Path("{id}")
    public Long excluir(@PathParam("id") Long id){
        divulgacaoRepository.excluir(id);
        return id;
    }
    
    @PUT
    @Path("{id}")
    public Divulgacao atualizar(@PathParam("id") Long id, Divulgacao divulgacao){
        return divulgacaoRepository.atualizar(id, divulgacao);
    }
    
    @GET
    @Path("{id}")
    public Divulgacao getDivulgacao(@PathParam("id") Long id){
        return divulgacaoRepository.findById(id);
    }
}
