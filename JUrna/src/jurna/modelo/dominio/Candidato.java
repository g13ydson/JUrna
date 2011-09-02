/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jurna.modelo.dominio;

import javax.swing.JOptionPane;
import jurna.excecao.JUrnaException;

/**
 *
 * @author Gleydson_2
 */
public class Candidato {

    private long codigo;
    private String nome;
    private String partido;
    private int numero;
    private int votos;
    private String caminhoFoto;

    public Candidato() {
    }

    /**
     * @return the codigo
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) throws JUrnaException {
        if (!this.isNomeValido(nome.trim())) {
            throw new JUrnaException("O nome do candidato deve ser informado!");
        }
        this.nome = nome;
    }

    /**
     * @return the partido
     */
    public String getPartido() {
        return partido;
    }

    /**
     * @param partido the partido to set
     */
    public void setPartido(String partido) throws JUrnaException {
        if (!this.isPartidoValido(partido.trim())) {
            throw new JUrnaException("O partido do candidato deve ser informado!");
        }
        this.partido = partido;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) throws JUrnaException {
        this.numero = numero;

    }

    /**
     * @return the caminhoFoto
     */
    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    /**
     * @param caminhoFoto the caminhoFoto to set
     */
    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    private boolean isNomeValido(String nome) {
        if (nome == null || nome.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isPartidoValido(String partido) {
        if (partido == null || partido.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @return the votos
     */
    public int getVotos() {
        return votos;
    }

    /**
     * @param votos the votos to set
     */
    public void setVotos(int votos) {
        this.votos = votos;
    }
}
