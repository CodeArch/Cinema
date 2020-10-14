/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.telas;

import br.ufmt.ic.alg3.cinema.entidades.Assento;
import br.ufmt.ic.alg3.cinema.entidades.Sala;
import br.ufmt.ic.alg3.cinema.entidades.Sessao;
import br.ufmt.ic.alg3.cinema.persistencia.AssentoDAO;
import br.ufmt.ic.alg3.cinema.persistencia.SalaDAO;
import br.ufmt.ic.alg3.cinema.persistencia.arquivo.AssentoDAOImplArq;
import br.ufmt.ic.alg3.cinema.persistencia.arquivo.SalaDAOImplArq;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author henrique
 */
public class JPanelSala extends javax.swing.JPanel {

    private SalaDAO salaDAO = new SalaDAOImplArq();
    private AssentoDAO assentoDAO = new AssentoDAOImplArq();
    
    /**
     * Creates new form JPanelSala
     */
    public JPanelSala() {
        initComponents();
        carregarTabela();
    }
    
    private void carregarTabela() {
        List<Sala> salas = salaDAO.listar();
        
        DefaultTableModel tableModel = (DefaultTableModel) jTableSala.getModel();
        
        // Limpar a tabela
        int linhas = tableModel.getRowCount();
        for (int i = 0; i < linhas; i++) {
            tableModel.removeRow(0);
        }
        
        for (Sala sala : salas) {
            Object[] linha = new Object[2];
            linha[0] = sala.getId();
            linha[1] = sala.getAssentos() == null ? null: sala.getAssentos().length;
            
            tableModel.addRow(linha);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSala = new javax.swing.JTable();
        jButtonSalvar = new javax.swing.JButton();
        jTextFieldId = new javax.swing.JTextField();
        jButtonLimpar = new javax.swing.JButton();
        jSpinnerAssentos = new javax.swing.JSpinner();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        jLabel1.setText("ID:");

        jLabel3.setText("Assentos:");

        jTableSala.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Assentos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableSala);

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jSpinnerAssentos.setModel(new javax.swing.SpinnerNumberModel(30, 0, null, 1));

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinnerAssentos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonExcluir)))
                        .addGap(0, 102, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinnerAssentos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldId.setText("");
        jSpinnerAssentos.setValue(30);
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        Sala sala = new Sala();
        
        int id = Integer.parseInt(jTextFieldId.getText());
        int quantAssentos = (int) jSpinnerAssentos.getValue();
        
        sala.setId(id);
        
        int cont = 1;
        Assento[] assentos = new Assento[quantAssentos];
        for (Assento assento : assentos) {
            assento = new Assento();
            assento.setId(cont * id * quantAssentos);
            assento.setSala(sala);
            
            assentoDAO.inserir(assento);
            
            cont++;
        }
        
        sala.setAssentos(assentos);
        
        if (salaDAO.getById(id) == null) {
            salaDAO.inserir(sala);
        } else {
            salaDAO.editar(sala);
        }
        
        jButtonLimparActionPerformed(evt);
        carregarTabela();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        int linha = jTableSala.getSelectedRow();
        
        if (linha != -1) {
            int id = (int) jTableSala.getValueAt(linha, 0);

            Sala sala = salaDAO.getById(id);

            jTextFieldId.setText(Integer.toString(sala.getId()));
            jSpinnerAssentos.setValue(sala.getAssentos().length);
            
        }
        
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int[] linhas = jTableSala.getSelectedRows();
        
        for (int linha : linhas) {
            int id = (int) jTableSala.getValueAt(linha, 0);
            salaDAO.remover(id);
        }
        
        carregarTabela();
    }//GEN-LAST:event_jButtonExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerAssentos;
    private javax.swing.JTable jTableSala;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables
}
