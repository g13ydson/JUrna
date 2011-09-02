/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jurna.persistencia;

import jurna.excecao.JUrnaException;
import jurna.modelo.dominio.Candidato;

/**
 *
 * @author Gleydson_2
 */
public interface IGatewayCandidato {
    public abstract void gravarCandidato(Candidato candidato) throws JUrnaException; 
}
