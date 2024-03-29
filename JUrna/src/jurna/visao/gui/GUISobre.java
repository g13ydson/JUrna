/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUISobre.java
 *
 * Created on 03/08/2011, 01:48:42
 */
package jurna.visao.gui;

import java.awt.Dimension;

/**
 *
 * @author Gleydson_2
 */
public class GUISobre extends javax.swing.JInternalFrame {

    /** Creates new form GUISobre */
    public GUISobre() {
        initComponents();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2,
                (d.height - this.getSize().height) / 2);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lNomeDoAplicativo = new javax.swing.JLabel();
        lVersaoDoAplicativo = new javax.swing.JLabel();
        lAutorDoAplicativo = new javax.swing.JLabel();
        lDescricaoDoAplicativo = new javax.swing.JLabel();
        lLicencaDoAplicativo = new javax.swing.JLabel();
        tfAutor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taLicenca = new javax.swing.JTextArea();
        bFechar = new javax.swing.JButton();

        setClosable(true);
        setTitle("JUrna - Sobre");

        lNomeDoAplicativo.setText("JUrna");

        lVersaoDoAplicativo.setText("Versao 1.0");

        lAutorDoAplicativo.setText("Autor");

        lDescricaoDoAplicativo.setText("Descrição");

        lLicencaDoAplicativo.setText("Licença");

        tfAutor.setEditable(false);
        tfAutor.setText("Gleydson da S Tavares");

        taDescricao.setColumns(20);
        taDescricao.setEditable(false);
        taDescricao.setLineWrap(true);
        taDescricao.setRows(5);
        taDescricao.setText("JUrna é aplicativo desenvolvido na linguagem OO Java que visa auxiliar na computação dos votos de diversos tipos de eleições de uma forma ajustável.");
        taDescricao.setWrapStyleWord(true);
        jScrollPane1.setViewportView(taDescricao);

        taLicenca.setColumns(20);
        taLicenca.setEditable(false);
        taLicenca.setLineWrap(true);
        taLicenca.setRows(5);
        taLicenca.setText("Licença Pública da GNU (GNU General Public \nLicense), conforme publicada pela Free \nSoftware Foundation.");
        taLicenca.setWrapStyleWord(true);
        jScrollPane2.setViewportView(taLicenca);

        bFechar.setText("Fechar");
        bFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lNomeDoAplicativo)
                    .addComponent(lVersaoDoAplicativo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lAutorDoAplicativo)
                        .addGap(32, 32, 32)
                        .addComponent(tfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lDescricaoDoAplicativo)
                            .addComponent(lLicencaDoAplicativo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))))
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(bFechar)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lNomeDoAplicativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lVersaoDoAplicativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lAutorDoAplicativo)
                    .addComponent(tfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lDescricaoDoAplicativo)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lLicencaDoAplicativo)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(bFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_bFecharActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lAutorDoAplicativo;
    private javax.swing.JLabel lDescricaoDoAplicativo;
    private javax.swing.JLabel lLicencaDoAplicativo;
    private javax.swing.JLabel lNomeDoAplicativo;
    private javax.swing.JLabel lVersaoDoAplicativo;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextArea taLicenca;
    private javax.swing.JTextField tfAutor;
    // End of variables declaration//GEN-END:variables
}
