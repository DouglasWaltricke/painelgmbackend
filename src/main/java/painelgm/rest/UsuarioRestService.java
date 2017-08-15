/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package painelgm.rest;

import java.util.List;
import javax.enterprise.context.RequestScoped;
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

import painelgm.data.UsuarioRepository;
import painelgm.model.Usuario;
import painelgm.service.UsuarioService;

/**
 *
 * @author goga
 */
@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class UsuarioRestService {
    
    @Inject 
    private UsuarioService usuarioService;
    
    @Inject
    private UsuarioRepository usuarioRepository;
    
    @GET
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @POST
    public Usuario adicionar(Usuario usuario) {
        usuarioService.cadastrarUsuario(usuario);
        return usuario;
    }
    
   @DELETE
   @Path("{id}")
    public Long excluir(@PathParam("id") Long id){
        usuarioRepository.excluir(id);
        return id;
      }
   
    @GET
    @Path("{id}")
    public Usuario getUsuario(@PathParam("id") Long id){
        return usuarioRepository.findByID(id);
        
    }
    
    @PUT
    @Path("{id}")
    public Usuario atualizar(@PathParam("id") Long id, Usuario usuario){
        return usuarioRepository.atualizar(id, usuario);
    }
}