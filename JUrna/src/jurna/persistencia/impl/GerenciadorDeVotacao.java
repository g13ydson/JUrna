/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jurna.persistencia.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jurna.excecao.JUrnaException;

/**
 *
 * @author Gleydson_2
 */
public class GerenciadorDeVotacao {

    private void setVoto(String numero) throws JUrnaException {
        String quantidadeDeVotos = Integer.toString(getQuantidadeDeVotos(numero)+1);
        String SQL_INCLUIRVOTO = "UPDATE CANDIDATOS SET VOTOS=" + quantidadeDeVotos + " WHERE NUMERO =" + numero;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = GerenciadorDeConexao.getConexao();
            stmt = con.prepareStatement(SQL_INCLUIRVOTO);
            stmt.executeUpdate();
        } catch (SQLException exc) {
            StringBuffer mensagem = new StringBuffer(
                    "Não foi possível realizar a inclusão do voto do {candidato.}");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new JUrnaException(mensagem.toString());
        } finally {
            GerenciadorDeConexao.closeConexao(con, stmt);
        }
    }

    private int getQuantidadeDeVotos(String numero) throws JUrnaException {
        int quantidadeDeVotos = 0;


        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT*FROM CANDIDATOS WHERE NUMERO =" + numero;
            con = GerenciadorDeConexao.getConexao();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                quantidadeDeVotos = rs.getByte("votos");
            }
        } catch (SQLException exc) {
            StringBuffer mensagem = new StringBuffer(
                    "Não foi possível realizar a contagem dos votos.");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new JUrnaException(mensagem.toString());
        } finally {
            GerenciadorDeConexao.closeConexao(con, stmt, rs);
        }

        return quantidadeDeVotos;
    }

    public void realizarVoto(String numeroCandidato) throws JUrnaException {
        setVoto(numeroCandidato);
    }
}
