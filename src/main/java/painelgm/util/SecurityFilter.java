package painelgm.util;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import painelgm.data.UsuarioRepository;


/**
 *
 * @author goga
 */

@Provider
public class SecurityFilter implements ContainerRequestFilter{
 /*   private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String AUTHORIZATION_HEADER_PREFIX = "Basic"; */
    private static final String SECURED_URL_PREFIX = "secured";
    
    @Inject UsuarioRepository usuarioRepository;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
      
      /*   if(!requestContext.getUriInfo().getPath().contains("http://localhost:8080/api/webresources/login")){
            MultivaluedMap<String,String> authHeader0 = requestContext.getHeaders();
            String teste = requestContext.getHeaderString("x-access-token");
            List<String> authHeader3 = requestContext.getHeaders().get("x-access-token");
            List<String> authHeader2 = requestContext.getHeaders().get(this);
            System.out.println(authHeader2);
       /*   if(authHeader != null && authHeader.size() > 0){
                String authToken = authHeader.get(0);
            
                if(usuarioRepository.findByID(authToken)){
                    return;
                }
            }  */
       } 
        
    }
        

