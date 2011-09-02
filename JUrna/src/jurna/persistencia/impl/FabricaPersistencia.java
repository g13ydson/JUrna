/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jurna.persistencia.impl;

import jurna.persistencia.IFabricaPersistencia;
import jurna.persistencia.IGatewayCandidato;
import jurna.persistencia.IPesquisadorDeCandidato;

/**
 *
 * @author Gleydson_2
 */
public class FabricaPersistencia implements IFabricaPersistencia {

    @Override
    public IGatewayCandidato getGatewayCandidato() {
        return new GatewayCandidato();
    }

    public IPesquisadorDeCandidato getPesquisadorDeCandidato() {
        return new PesquisadorDeCandidato();
    }
}
