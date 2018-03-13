package painelgm.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.POST;
import painelgm.data.DivulgacaoRepository;
import painelgm.model.Divulgacao;
import painelgm.model.Rankingdv;
import painelgm.model.Usuario;


@Stateless
public class DivulgacaoService {
   
    @Inject
    @PersistenceContext(unitName="PainelgmPU")
    private EntityManager em;
    
    @Inject
    DivulgacaoRepository divulgacaoRepository;
    

    public Divulgacao cadastrarDivulgacao(Divulgacao divulgacao,Usuario usuario){
   
        divulgacao.setUsuario(usuario);
        divulgacao.associar();
        List<Divulgacao> lista = divulgacaoRepository.findListFromUser(usuario);
       
        divulgacao.setNumeroSemana(lista.size()+1);
        divulgacao.setGameMaster(usuario.getLogin());
        int lastDivulgacaoQuantidade = divulgacaoRepository.maxQuantidadeFromUser(usuario);
        int lastDivulgacaoQuantidadeAux = lastDivulgacaoQuantidade > 0 ? lastDivulgacaoQuantidade : 0;
        em.persist(divulgacao);
        
     
        
        Rankingdv rankingAux = new Rankingdv();
        rankingAux.setGameMaster(usuario.getLogin());
        Integer qtd = divulgacao.getQuantidade() - lastDivulgacaoQuantidadeAux;
        rankingAux.setQtd(qtd);
        em.persist(rankingAux);
        
        return divulgacao;
    }
    
}
