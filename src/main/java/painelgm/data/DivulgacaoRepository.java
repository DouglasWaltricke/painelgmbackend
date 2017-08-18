package painelgm.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import painelgm.model.Divulgacao;


@Stateless
public class DivulgacaoRepository {
   
    @Inject
    @PersistenceContext(unitName="PainelgmPU")
    private EntityManager em;
    
    public List<Divulgacao> findAll(){
        return em.createQuery("select dv from Divulgacao dv", Divulgacao.class).getResultList();
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
         divulgacao.setGamemaster(divulgacaoAtualizada.getGamemaster());
         divulgacao.setNumeroSemana(divulgacaoAtualizada.getNumeroSemana());
         divulgacao.setPaginaUrl(divulgacaoAtualizada.getPaginaUrl());
         divulgacao.setQuantidade(divulgacaoAtualizada.getQuantidade());
         
         return divulgacao;
        
    }
}
