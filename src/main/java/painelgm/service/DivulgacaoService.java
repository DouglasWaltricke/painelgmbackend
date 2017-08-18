package painelgm.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.POST;
import painelgm.model.Divulgacao;


@Stateless
public class DivulgacaoService {
   
    @Inject
    @PersistenceContext(unitName="PainelgmPU")
    private EntityManager em;
    

    public Divulgacao cadastrarDivulgacao(Divulgacao divulgacao){
        em.persist(divulgacao);
        return divulgacao;
    }
    
}
