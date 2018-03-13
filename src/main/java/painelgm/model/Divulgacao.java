/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package painelgm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 *
 * @author goga
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="divulgacao", schema ="public")
public class Divulgacao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
   
    private Integer quantidade;
    private Integer numeroSemana;
    private boolean checked;
    private String gameMaster;
    private Date dataDivulgacao;
    
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "divulgacao",
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PaginaUrl> paginaUrl;
    
    @OneToOne()
    public Usuario usuario;
    
    @Ignore
    public Long codigoUsuario;
    
    public void associar() {
        for (PaginaUrl pagina : paginaUrl) {
            pagina.setDivulgacao(this);
        }
    }
    
    
}
