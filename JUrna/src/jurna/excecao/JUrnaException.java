/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jurna.excecao;

/**
 *
 * @author Gleydson_2
 */
public class JUrnaException extends Exception {

    public JUrnaException() {
        super("Causa do erro: Desconhecida");
    }

    public JUrnaException(String message) {
        super(message);
    }
}
