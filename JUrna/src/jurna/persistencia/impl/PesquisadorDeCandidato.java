/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jurna.persistencia.impl;

import jurna.persistencia.IPesquisadorDeCandidato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jurna.excecao.JUrnaException;
import jurna.modelo.dominio.Candidato;

/**
 *
 * @author Gleydson_2
 */
public class PesquisadorDeCandidato implements IPesquisadorDeCandidato {

    private List criterios = new ArrayList();

    @Override
    public void adicionarCriterio(CriterioDePesquisa criterio) {
        this.criterios.add(criterio);
    }

    private String gerarClausulaWhere() {
        StringBuffer clausulaWhere = new StringBuffer();
        if (criterios.size() != 0) {
            clausulaWhere.append(" WHERE ");
            Iterator iterator = criterios.iterator();
            while (iterator.hasNext()) {
                if (clausulaWhere.length() != 7) {
                    clausulaWhere.append(" OR ");
                }
                CriterioDePesquisa criterio = (CriterioDePesquisa) iterator.next();
                clausulaWhere.append(criterio.gerarSQL());
            }
        }
        return clausulaWhere.toString();
    }

    private List encontrarCandidatosOnde(String clausulaWhere) throws JUrnaException {
        String sql = "SELECT * FROM candidatos" + clausulaWhere;

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List resultado = new ArrayList();
        try {
            con = GerenciadorDeConexao.getConexao();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Candidato candidato = criarCandidato(rs);
                resultado.add(candidato);
            }
        } catch (SQLException exc) {
            StringBuffer mensagem = new StringBuffer(
                    "Não foi possível realizar a consulta.");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new JUrnaException(mensagem.toString());
        } finally {
            GerenciadorDeConexao.closeConexao(con, stmt, rs);
        }

        return resultado;
    }

    private Candidato criarCandidato(ResultSet rs) throws JUrnaException {
        Candidato candidato = new Candidato();

        try {
            candidato.setNumero(rs.getByte("numero"));
            candidato.setNome(rs.getString("nome"));
            candidato.setPartido(rs.getString("partido"));
        } catch (SQLException exc) {
            //System.out.println(exc);
            StringBuffer mensagem = new StringBuffer(
                    "Não foi possível obter os dados do candidato.");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new JUrnaException(mensagem.toString());
        }

        return candidato;
    }

    @Override
    public List realizarPesquisa() throws JUrnaException {
        String clausulaWhere = this.gerarClausulaWhere();
        return encontrarCandidatosOnde(clausulaWhere);
    }
}
