package painelgm.data;
/**
 *
 * @author goga
 */
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import painelgm.model.Usuario;

@ApplicationScoped
public class UsuarioRepository {
    
    @Inject
    private EntityManager em;
    
    
    public Usuario findByID(Long id){
        return em.createQuery("select u from usuarios u where usuarios.id = :id", Usuario.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    
    public List<Usuario> findAll(){
        return em.createQuery("select u from usuarios", Usuario.class).getResultList();
    }
}
