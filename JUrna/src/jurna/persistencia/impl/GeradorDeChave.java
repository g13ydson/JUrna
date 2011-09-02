/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jurna.persistencia.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jurna.excecao.JUrnaException;

/**
 *
 * @author Gleydson_2
 */
class GeradorDeChave {

    private static final byte INCREMENTO = 1;
    private Connection con;
    private String tabela;
    private long proximoCodigo;
    private long maximoCodigo;

    public GeradorDeChave(String tabela) throws JUrnaException {
        this.con = GerenciadorDeConexao.getConexao();
        this.tabela = tabela;
        proximoCodigo = 0;
        maximoCodigo = 0;
        try {
            con.setAutoCommit(false);
        } catch (SQLException exc) {
            StringBuffer mensagem = new StringBuffer("Não foi possível desligar a confirmação automática");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new JUrnaException(mensagem.toString());
        }
    }

    public synchronized long getProximoCodigo() throws JUrnaException {
        if (proximoCodigo == maximoCodigo) {
            reservarCodigo();
        }
        return proximoCodigo;
    }

    private void reservarCodigo() throws JUrnaException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        long proximoCodigoNovo;

        String sql = "SELECT proximoCodigo FROM chaves WHERE tabela = ? FOR UPDATE";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, tabela);
            rs = stmt.executeQuery();
            rs.next();
            proximoCodigoNovo = rs.getLong("proximoCodigo");
        } catch (SQLException exc) {
            StringBuffer mensagem = new StringBuffer("Não foi possível gerar o próximo código");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new JUrnaException(mensagem.toString());
        }

        long maximoCodigoNovo = proximoCodigoNovo + INCREMENTO;
        stmt = null;
        rs = null;

        try {
            sql = "UPDATE chaves SET proximoCodigo = ? WHERE tabela = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, maximoCodigoNovo);
            stmt.setString(2, tabela);
            stmt.executeUpdate();
            con.commit();
            proximoCodigo = proximoCodigoNovo;
            maximoCodigo = maximoCodigoNovo;
        } catch (SQLException exc) {
            StringBuffer mensagem = new StringBuffer("Não foi possível gerar o código");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new JUrnaException(mensagem.toString());
        } finally {
            GerenciadorDeConexao.closeConexao(con, stmt, rs);
        }
    }
}
