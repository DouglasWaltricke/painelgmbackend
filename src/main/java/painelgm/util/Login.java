/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package painelgm.util;

import java.io.IOException;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import painelgm.data.UsuarioRepository;
import painelgm.model.Usuario;

@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class Login extends HttpServlet{
    
    @Inject
    private UsuarioRepository usuarioRepository;
    
    @POST
    public Long efetuarLogin(Usuario usuario){
        Usuario usuarioLogado =  usuarioRepository.findUser(usuario);
 
        if(usuarioLogado != null){
            Long id = usuarioLogado.getId();
            return id;
        } else {
           return null;
        }
    }
    
    
}
