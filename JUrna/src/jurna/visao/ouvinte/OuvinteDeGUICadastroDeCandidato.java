/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jurna.visao.ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import jurna.excecao.JUrnaException;
import jurna.modelo.controle.ControleCandidato;
import jurna.modelo.dominio.Candidato;
import jurna.visao.gui.GUICadastroDeCandidatos;
import jurna.visao.gui.GUIMensagem;

/**
 *
 * @author Gleydson_2
 */
public class OuvinteDeGUICadastroDeCandidato {

    private GUICadastroDeCandidatos guiCadastroDeCandidatos;

    public OuvinteDeGUICadastroDeCandidato(GUICadastroDeCandidatos guiCadastroDeCandidatos) {
        this.guiCadastroDeCandidatos = guiCadastroDeCandidatos;
        guiCadastroDeCandidatos.bGravarCandidatoAddActionListener(new OuvinteGravarCandidato());
    }
    

    class OuvinteGravarCandidato implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "BOTAO 2");
            /*Candidato candidato;
            try {
                candidato = guiCadastroDeCandidatos.getCandidato();
                ControleCandidato controle = new ControleCandidato();
                controle.gravarCandidato(candidato);
                GUIMensagem.exibirMensagem("Candidato gravado com sucesso!", "JUrna - Candidato", false);
                guiCadastroDeCandidatos.limparCampos();
            } catch (JUrnaException ex) {
                GUIMensagem.exibirMensagem(ex.getMessage(), "JUrna - Candidato",
                        true);
            }*/
        }
    }
}
