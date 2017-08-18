package painelgm.data;
 /**
 + *
 + * @author goga
 + */
 import javax.enterprise.context.ApplicationScoped;
 import javax.inject.Inject;
 import javax.persistence.EntityManager;
 import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
 import painelgm.model.Usuario;
 
 @Stateless
 public class UsuarioRepository {
    
     @Inject
     private EntityManager em;
     
     
     public Usuario findByID(Long id){
         return em.find(Usuario.class,id);
     }
     
     public Usuario findUser(Usuario usuario){
         Usuario teste = em.createQuery("select u from Usuario u where u.login = :login", Usuario.class)
                 .setParameter("login",usuario.getLogin())
                 .getSingleResult();
         return teste;
     }
     public List<Usuario> findAll(){
         return em.createQuery("select u from Usuario u", Usuario.class).getResultList();
    }
     
     public Usuario excluir(Long id){
          Usuario usuario = findByID(id);
          em.remove(usuario);
          return usuario;
     }
     
     public Usuario atualizar(Long id, Usuario usuarioAtualizado){
         Usuario usuario = findByID(id);
         
         usuario.setLogin(usuarioAtualizado.getLogin());
         usuario.setFotoUrl(usuarioAtualizado.getFotoUrl());
         usuario.setAdministrador(usuarioAtualizado.getAdministrador());
         usuario.setIdade(usuarioAtualizado.getIdade());
         usuario.setSenha(usuarioAtualizado.getSenha());
         em.merge(usuario);
         
       return usuario;  
     }
 }
