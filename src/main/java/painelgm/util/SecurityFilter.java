package painelgm.util;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;


/**
 *
 * @author goga
 */

@Provider
public class SecurityFilter implements ContainerRequestFilter{
    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String AUTHORIZATION_HEADER_PREFIX = "Basic";
    private static final String SECURED_URL_PREFIX = "secured";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)){
            List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
            if(authHeader != null && authHeader.size() > 0){
                String authToken = authHeader.get(0);
               authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX,"");

              /*  if("login".equals(username) && "senha".equals(password)){
                    return;
                }*/
        } 
       }
    }
        
} 
