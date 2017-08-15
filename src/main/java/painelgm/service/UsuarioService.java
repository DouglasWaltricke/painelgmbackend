package painelgm.service;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import painelgm.model.Usuario;

/**
 *
 * @author goga
 */
@Stateless
public class UsuarioService {
    
    @Inject
    private EntityManager em;
    
    public void cadastrarUsuario(Usuario usuario){
        em.persist(usuario);
    }
   
  
}