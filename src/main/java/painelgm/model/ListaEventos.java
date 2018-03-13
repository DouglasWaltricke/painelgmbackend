/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package painelgm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.codehaus.jackson.annotate.JsonIgnore;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "lista_eventos", schema = "public")
public class ListaEventos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gameMaster;
    private Date dataEvento;
    private boolean checked;
    
    @Ignore
    public Long codigoUsuario;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "listaEventos",
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Evento> eventos;
    
    @OneToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    public void associar(String gameMaster) {
        for (Evento evento : eventos) {
            evento.setGameMaster(gameMaster);
            evento.setListaEventos(this);
        }
    }

    public void atualizarAssociacao(ListaEventos listaEventosAtualizada) {
        for (Evento evento : listaEventosAtualizada.getEventos()) {
            evento.setListaEventos(listaEventosAtualizada);
        }
    }

}
