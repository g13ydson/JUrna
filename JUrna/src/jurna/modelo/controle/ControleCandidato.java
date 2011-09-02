/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jurna.modelo.controle;

import java.util.List;
import jurna.excecao.JUrnaException;
import jurna.modelo.dominio.Candidato;
import jurna.persistencia.IFabricaPersistencia;
import jurna.persistencia.IGatewayCandidato;
import jurna.persistencia.IPesquisadorDeCandidato;
import jurna.persistencia.impl.CriterioDePesquisa;
import jurna.persistencia.impl.CriterioDePesquisaContem;
import jurna.persistencia.impl.FabricaPersistencia;

/**
 *
 * @author Gleydson_2
 */
public class ControleCandidato {

    private IPesquisadorDeCandidato pesquisador;

    public void gravarCandidato(Candidato candidato) throws JUrnaException {
        IFabricaPersistencia fabricaPersistencia = new FabricaPersistencia();
        IGatewayCandidato gatewayCandidato = fabricaPersistencia.getGatewayCandidato();
        gatewayCandidato.gravarCandidato(candidato);
    }

    public void adicionarCriterioDePesquisaIgualA(String campo, int valor) {
        if (this.pesquisador == null) {
            this.criarPesquisador();
        }
        pesquisador.adicionarCriterio(CriterioDePesquisa.igualA(campo, valor));
    }

    public void adicionarCriterioDePesquisaContem(String campo, String valor) {
        if (this.pesquisador == null) {
            this.criarPesquisador();
        }
        pesquisador.adicionarCriterio(CriterioDePesquisaContem.contem(campo, valor));
    }

    public List realizarPesquisa() throws JUrnaException {
        if (this.pesquisador == null) {
            this.criarPesquisador();
        }
        return pesquisador.realizarPesquisa();
    }

    private void criarPesquisador() {
        IFabricaPersistencia fabricaPersistencia = new FabricaPersistencia();
        this.pesquisador = fabricaPersistencia.getPesquisadorDeCandidato();
    }
}
