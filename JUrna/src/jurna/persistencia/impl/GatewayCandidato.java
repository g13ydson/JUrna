/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jurna.persistencia.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jurna.excecao.JUrnaException;
import jurna.modelo.dominio.Candidato;
import jurna.modelo.dominio.constante.Constante;
import jurna.persistencia.IGatewayCandidato;

/**
 *
 * @author Gleydson_2
 */
public class GatewayCandidato implements IGatewayCandidato {

    private static final String SQL_INCLUIRCANDIDATO =
            "INSERT INTO candidatos "
            + "(numero, nome, partido, votos, foto) "
            + "VALUES (?, ?, ?, ?, ?)";

    @Override
    public void gravarCandidato(Candidato candidato) throws JUrnaException {
        if (candidato.getCodigo() == Constante.NOVO) {
            incluirCandidato(candidato);
        }
    }

    private void incluirCandidato(Candidato candidato) throws JUrnaException {
        if (candidato == null) {
            String mensagem = "Não foi informado o candidato a cadastrar.";
            throw new JUrnaException(mensagem);
        }

        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = GerenciadorDeConexao.getConexao();
            stmt = con.prepareStatement(SQL_INCLUIRCANDIDATO);
            //GeradorDeChave geradorDeChave = new GeradorDeChave("candidatos");
            //long codigocandidato = geradorDeChave.getProximoCodigo();
            //stmt.setLong(1, codigocandidato);
            stmt.setInt(1, candidato.getNumero());
            stmt.setString(2, candidato.getNome().toUpperCase());
            stmt.setString(3, candidato.getPartido().toUpperCase());
            stmt.setInt(4, candidato.getVotos());
            stmt.setString(5, candidato.getCaminhoFoto());
            stmt.executeUpdate();
        } catch (SQLException exc) {
            StringBuffer mensagem = new StringBuffer("Não foi possível incluir o candidato.");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new JUrnaException(mensagem.toString());
        } finally {
            GerenciadorDeConexao.closeConexao(con, stmt);
        }
    }
}
