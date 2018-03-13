package painelgm.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import painelgm.model.Divulgacao;
import painelgm.model.Usuario;


@Stateless
public class DivulgacaoRepository {
   
    @Inject
    @PersistenceContext(unitName="PainelgmPU")
    private EntityManager em;
    
    public List<Divulgacao> findAll(){
        return em.createQuery("select dv from Divulgacao dv order by dv.dataDivulgacao desc", Divulgacao.class).getResultList();
    }
    
    public List<Divulgacao> findListFromUser(Usuario usuario){
         List<Divulgacao> teste =  em.createQuery("select distinct dv from Divulgacao dv where dv.usuario = :usuario order by dv.dataDivulgacao desc", Divulgacao.class)
                .setParameter("usuario", usuario)
                .getResultList();
         return teste;
    }
    
    public int maxQuantidadeFromUser(Usuario usuario){
         if(findListFromUser(usuario).size() > 0){
            int dv =  (int) em.createQuery("select max(quantidade) from Divulgacao dv where dv.usuario = :usuario")
                .setParameter("usuario", usuario)
                .getSingleResult();
            return dv;
         
        } else {
             return 0;
        }
    }
    
    
    
    public Divulgacao findById(Long id){
        return em.find(Divulgacao.class,id);
    }
    
    public Divulgacao excluir(Long id){
        Divulgacao divulgacao = em.find(Divulgacao.class, id);
        em.remove(divulgacao);
        return divulgacao;
    }
    
    public Divulgacao atualizar(Long id, Divulgacao divulgacaoAtualizada){
         Divulgacao divulgacao = em.find(Divulgacao.class, id);
         divulgacao.setChecked(divulgacaoAtualizada.isChecked());
         divulgacao.setDataDivulgacao(divulgacaoAtualizada.getDataDivulgacao());
         divulgacao.setGameMaster(divulgacaoAtualizada.getGameMaster());
         divulgacao.setNumeroSemana(divulgacaoAtualizada.getNumeroSemana());
       /*  divulgacao.setUrls(divulgacaoAtualizada.getUrls()); */
         divulgacao.setQuantidade(divulgacaoAtualizada.getQuantidade());
         
         return divulgacao;
        
    }
    
    public List<Object> topDivulcao(){
       return em.createQuery("select sum(qtd), gameMaster from Rankingdv group by gameMaster order by sum(qtd) desc").setMaxResults(10).getResultList();
    }
    
    public void resetar(){
        Query query = em.createQuery("delete from Rankingdv");
        query.executeUpdate();
    }
   
}
