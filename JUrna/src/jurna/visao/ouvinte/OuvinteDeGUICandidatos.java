/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jurna.visao.ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import jurna.excecao.JUrnaException;
import jurna.modelo.controle.ControleCandidato;
import jurna.visao.gui.GUICandidatos;
import jurna.visao.gui.GUIMensagem;

/**
 *
 * @author Gleydson_2
 */
public class OuvinteDeGUICandidatos {

    private GUICandidatos guiCandidatos;

    public OuvinteDeGUICandidatos(GUICandidatos guiCandidatos) {
        this.guiCandidatos = guiCandidatos;
        this.guiCandidatos.bPesquisarCandidatoAddActionListener(new OuvintePesquisarCandidatos());
    }

    class OuvintePesquisarCandidatos implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            try {
                ControleCandidato controle = new ControleCandidato();
                String nomeDoCandidato = guiCandidatos.getNome();
                if (nomeDoCandidato != null && !nomeDoCandidato.trim().equals("")) {
                    controle.adicionarCriterioDePesquisaContem("numero", nomeDoCandidato);
                }
                List candidatos = controle.realizarPesquisa();
                if (candidatos.size() > 0) {
                    guiCandidatos.exibirCandidatos(candidatos);
                } else {
                    StringBuffer mensagem = new StringBuffer();
                    mensagem.append("Não há candidatos cadastrados ou que");
                    mensagem.append("\natendam ao critério informado.");
                    GUIMensagem.exibirMensagem(mensagem.toString(), "Cadastro de candidatos",
                            true);
                }

            } catch (JUrnaException ex) {
                GUIMensagem.exibirMensagem(ex.getMessage(), "JUrna - Candidatos", true);
            }
        }
    }
}
