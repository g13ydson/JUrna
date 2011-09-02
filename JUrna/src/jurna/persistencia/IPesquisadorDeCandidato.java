/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jurna.persistencia;

import java.util.List;
import jurna.excecao.JUrnaException;
import jurna.persistencia.impl.CriterioDePesquisa;

/**
 *
 * @author Gleydson_2
 */
public interface IPesquisadorDeCandidato {

    void adicionarCriterio(CriterioDePesquisa criterio);

    List realizarPesquisa() throws JUrnaException;
    
}
