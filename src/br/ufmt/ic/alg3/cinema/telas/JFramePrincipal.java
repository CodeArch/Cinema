/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.telas;

import java.awt.Component;
import java.awt.Cursor;

/**
 *
 * @author henrique
 */
public class JFramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalJFrame
     */
    public JFramePrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelConteudo = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemFilme = new javax.swing.JMenuItem();
        jMenuItemSessao = new javax.swing.JMenuItem();
        jMenuItemSala = new javax.swing.JMenuItem();
        jMenuItemIngresso = new javax.swing.JMenuItem();
        jMenuItemCaixa = new javax.swing.JMenuItem();
        jMenuItemFuncionario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemListarAssentos = new javax.swing.JMenuItem();
        jMenuItemListarFilmes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanelConteudo.setLayout(new javax.swing.BoxLayout(jPanelConteudo, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(jPanelConteudo);

        jMenu1.setText("Arquivo");

        jMenuItemFilme.setText("Filme");
        jMenuItemFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFilmeActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFilme);

        jMenuItemSessao.setText("Sessão");
        jMenuItemSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSessaoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSessao);

        jMenuItemSala.setText("Sala");
        jMenuItemSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSala);

        jMenuItemIngresso.setText("Ingresso");
        jMenuItemIngresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIngressoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemIngresso);

        jMenuItemCaixa.setText("Caixa");
        jMenuItemCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCaixaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCaixa);

        jMenuItemFuncionario.setText("Funcionário");
        jMenuItemFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFuncionario);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Exibir");

        jMenuItemListarAssentos.setText("Listar Assentos");
        jMenuItemListarAssentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarAssentosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemListarAssentos);

        jMenuItemListarFilmes.setText("Listar Filmes");
        jMenuItemListarFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarFilmesActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemListarFilmes);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFilmeActionPerformed
        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            jPanelConteudo.removeAll();
            jPanelConteudo.add(new JPanelFilme());
            jPanelConteudo.setVisible(false);
            jPanelConteudo.setVisible(true);
        } finally {
            this.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_jMenuItemFilmeActionPerformed

    private void jMenuItemSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSessaoActionPerformed
        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            jPanelConteudo.removeAll();
            jPanelConteudo.add(new JPanelSessao());
            jPanelConteudo.setVisible(false);
            jPanelConteudo.setVisible(true);
        } finally {
            this.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_jMenuItemSessaoActionPerformed

    private void jMenuItemSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalaActionPerformed
        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            jPanelConteudo.removeAll();
            jPanelConteudo.add(new JPanelSala());
            jPanelConteudo.setVisible(false);
            jPanelConteudo.setVisible(true);
        } finally {
            this.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_jMenuItemSalaActionPerformed

    private void jMenuItemIngressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIngressoActionPerformed
        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            jPanelConteudo.removeAll();
            jPanelConteudo.add(new JPanelIngresso());
            jPanelConteudo.setVisible(false);
            jPanelConteudo.setVisible(true);
        } finally {
            this.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_jMenuItemIngressoActionPerformed

    private void jMenuItemFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncionarioActionPerformed
        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            jPanelConteudo.removeAll();
            jPanelConteudo.add(new JPanelFuncionario());
            jPanelConteudo.setVisible(false);
            jPanelConteudo.setVisible(true);
        } finally {
            this.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_jMenuItemFuncionarioActionPerformed

    private void jMenuItemCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCaixaActionPerformed
        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            jPanelConteudo.removeAll();
            jPanelConteudo.add(new JPanelCaixa());
            jPanelConteudo.setVisible(false);
            jPanelConteudo.setVisible(true);
        } finally {
            this.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_jMenuItemCaixaActionPerformed

    private void jMenuItemListarAssentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarAssentosActionPerformed
        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            JDialogAssentos dialog = new JDialogAssentos(this, false);
            dialog.setVisible(true);
        } finally {
            this.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_jMenuItemListarAssentosActionPerformed

    private void jMenuItemListarFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarFilmesActionPerformed
        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            JDialogFilmes dialog = new JDialogFilmes(this, false);
            dialog.setVisible(true);
        } finally {
            this.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_jMenuItemListarFilmesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemCaixa;
    private javax.swing.JMenuItem jMenuItemFilme;
    private javax.swing.JMenuItem jMenuItemFuncionario;
    private javax.swing.JMenuItem jMenuItemIngresso;
    private javax.swing.JMenuItem jMenuItemListarAssentos;
    private javax.swing.JMenuItem jMenuItemListarFilmes;
    private javax.swing.JMenuItem jMenuItemSala;
    private javax.swing.JMenuItem jMenuItemSessao;
    private javax.swing.JPanel jPanelConteudo;
    // End of variables declaration//GEN-END:variables
}
