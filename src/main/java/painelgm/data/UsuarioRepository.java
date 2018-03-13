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
import painelgm.model.ListaEventos;
 import painelgm.model.Usuario;
 
 @Stateless
 public class UsuarioRepository {
    
     @Inject
     private EntityManager em;
     
     
     public Usuario findByID(Long id){
         return em.find(Usuario.class,id);
     }
     
     public Usuario findUser(Usuario usuario){
        try{
           Usuario teste = em.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha", Usuario.class)
                   .setParameter("login",usuario.getLogin())
                   .setParameter("senha", usuario.getSenha())
                   .getSingleResult();
           if(teste != null)  {
               return teste;
           }
        }catch(Exception e){
            System.out.println(e);
            return null;
         } 
        return null;
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
     
     public List<Object> topEventosGM(){
         return em.createQuery("select sum(premiacao), gameMaster from Evento group by gameMaster order by sum(premiacao) desc").setMaxResults(10).getResultList();
     }
     
 }
