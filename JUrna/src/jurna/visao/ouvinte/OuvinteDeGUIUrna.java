/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jurna.visao.ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import jurna.visao.gui.GUIUrna;

/**
 *
 * @author Gleydson_2
 */
public class OuvinteDeGUIUrna {

    private GUIUrna guiUrna;

    public OuvinteDeGUIUrna(GUIUrna guiUrna) {
        this.guiUrna = guiUrna;
        guiUrna.b1AddActionListener(new OuvinteB1());
        guiUrna.b2AddActionListener(new OuvinteB2());
        guiUrna.b3AddActionListener(new OuvinteB3());


    }
    class OuvinteB1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "BOTAO 1");
        }
    }

    class OuvinteB2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "BOTAO 2");
        }
    }
    class OuvinteB3 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "BOTAO 3");
        }
    }
}
