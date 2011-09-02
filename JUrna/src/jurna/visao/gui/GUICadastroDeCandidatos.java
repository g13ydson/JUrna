/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUICadastroDeCandidatos.java
 *
 * Created on 12/08/2011, 02:16:41
 */
package jurna.visao.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import jurna.excecao.JUrnaException;
import jurna.modelo.dominio.Candidato;
import jurna.modelo.dominio.constante.Constante;

/**
 *
 * @author Gleydson_2
 */
public class GUICadastroDeCandidatos extends javax.swing.JInternalFrame {

    /** Creates new form GUICadastroDeCandidatos */
    public GUICadastroDeCandidatos() {
        initComponents();

    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation(15 + (d.width - this.getSize().width) / 5, 15 + (d.height
                - this.getSize().height) / 5);
    }

    public Candidato getCandidato() throws JUrnaException {

        try {
            String nome = tfNome.getText();
            if (nome == null || nome.trim().equals("")) {
                tfNome.requestFocus();
                throw new JUrnaException("Não foi informado o nome do candidato.");
            } else {
                candidato.setNome(nome);
            }
            candidato.setNumero(Integer.parseInt(tfNumero.getText()));
            candidato.setPartido(tfPartido.getText());
            


            return candidato;
        }catch(NumberFormatException exc){
            StringBuffer mensagem = new StringBuffer("Informe um número válido.");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new JUrnaException(mensagem.toString());
        }
    }

    public void exibeDadosDoCandidato() throws JUrnaException {
        limparCampos();

        if (candidato.getCodigo() != Constante.NOVO) {
            tfNome.setText(candidato.getNome());
            tfNumero.setText(Integer.toString(candidato.getNumero()));
            tfPartido.setText(candidato.getPartido());
            //mostrarImagem();
        }
    }

    public void setCandidato(Candidato candidato) throws JUrnaException {
        this.candidato = candidato;
        this.exibeDadosDoCandidato();
    }

    public void bGravarCandidatoAddActionListener(ActionListener ouvinte) {
        bGravarCandidato.addActionListener(ouvinte);

    }

    public void limparCampos() {
        tfNome.setText(null);
        tfNumero.setText(null);
        tfPartido.setText(null);
        lFotoCandidato.setIcon(null);
    }

    public File getArquivoImagem() {
        return this.arquivoImagem;
    }

    public void mostrarImagem() {
        lFotoCandidato.setIcon(frameIcon);
        fcSelecionadorDeArquivo.setFileFilter(new FileNameExtensionFilter("JPG, GIF, PNG E BMP",
                "jpg", "gif", "png", "bmp"));
        int res = fcSelecionadorDeArquivo.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            arquivoImagem = fcSelecionadorDeArquivo.getSelectedFile();
            candidato.setCaminhoFoto(arquivoImagem.getAbsolutePath());
            String Imc = arquivoImagem.getAbsolutePath();
            ImageIcon imagem = new ImageIcon(Imc);
            lFotoCandidato.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(lFotoCandidato.getWidth(), lFotoCandidato.getHeight(), Image.SCALE_DEFAULT)));
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fcSelecionadorDeArquivo = new javax.swing.JFileChooser();
        pDadosCandidato = new javax.swing.JPanel();
        lNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lNumero = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        lPartido = new javax.swing.JLabel();
        tfPartido = new javax.swing.JTextField();
        bSelecionar = new javax.swing.JButton();
        lFoto = new javax.swing.JLabel();
        lFotoCandidato = new javax.swing.JLabel();
        bGravarCandidato = new javax.swing.JButton();
        bLimpar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("JUrna - Cadastro de Candidato");

        pDadosCandidato.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Candidato"));

        lNome.setText("Nome");

        lNumero.setText("Número");

        lPartido.setText("Partido");

        bSelecionar.setText("Selecionar...");
        bSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelecionarActionPerformed(evt);
            }
        });

        lFoto.setText("Foto");

        lFotoCandidato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pDadosCandidatoLayout = new javax.swing.GroupLayout(pDadosCandidato);
        pDadosCandidato.setLayout(pDadosCandidatoLayout);
        pDadosCandidatoLayout.setHorizontalGroup(
            pDadosCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDadosCandidatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDadosCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNome)
                    .addComponent(lNumero)
                    .addComponent(lPartido)
                    .addGroup(pDadosCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfNumero, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfPartido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDadosCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lFoto)
                    .addComponent(bSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lFotoCandidato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pDadosCandidatoLayout.setVerticalGroup(
            pDadosCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDadosCandidatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDadosCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome)
                    .addComponent(lFoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(pDadosCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDadosCandidatoLayout.createSequentialGroup()
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lNumero)
                        .addGap(3, 3, 3)
                        .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lPartido)
                        .addGap(8, 8, 8)
                        .addComponent(tfPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lFotoCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(bSelecionar)
                .addContainerGap())
        );

        bGravarCandidato.setText("Gravar candidato");
        bGravarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGravarCandidatoActionPerformed(evt);
            }
        });

        bLimpar.setText("Limpar");
        bLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimparActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pDadosCandidato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bGravarCandidato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addComponent(bCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pDadosCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGravarCandidato)
                    .addComponent(bLimpar)
                    .addComponent(bCancelar))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelecionarActionPerformed
        mostrarImagem();
    }//GEN-LAST:event_bSelecionarActionPerformed

    private void bLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_bLimparActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bGravarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGravarCandidatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bGravarCandidatoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bGravarCandidato;
    private javax.swing.JButton bLimpar;
    private javax.swing.JButton bSelecionar;
    private javax.swing.JFileChooser fcSelecionadorDeArquivo;
    private javax.swing.JLabel lFoto;
    private javax.swing.JLabel lFotoCandidato;
    private javax.swing.JLabel lNome;
    private javax.swing.JLabel lNumero;
    private javax.swing.JLabel lPartido;
    private javax.swing.JPanel pDadosCandidato;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfPartido;
    // End of variables declaration//GEN-END:variables
    private Candidato candidato;
    private File arquivoImagem;
}