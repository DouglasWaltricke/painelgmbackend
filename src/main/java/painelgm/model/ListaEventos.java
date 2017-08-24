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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "listaEventos",
            orphanRemoval = true)
    private List<Evento> eventos;
    
    @OneToOne
    private Usuario usuario;

    public void associar() {
        for (Evento evento : eventos) {
            evento.setListaEventos(this);
        }
    }

    public void atualizarAssociacao(ListaEventos listaEventosAtualizada) {
        for (Evento evento : listaEventosAtualizada.getEventos()) {
            evento.setListaEventos(listaEventosAtualizada);
        }
    }

}
