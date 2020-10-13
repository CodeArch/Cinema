/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.cinema.telas;

import br.ufmt.ic.alg3.cinema.entidades.Caixa;
import br.ufmt.ic.alg3.cinema.entidades.Funcionario;
import br.ufmt.ic.alg3.cinema.persistencia.CaixaDAO;
import br.ufmt.ic.alg3.cinema.persistencia.FuncionarioDAO;
import br.ufmt.ic.alg3.cinema.persistencia.arquivo.CaixaDAOImplArq;
import br.ufmt.ic.alg3.cinema.persistencia.arquivo.FuncionarioDAOImplArq;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author henrique
 */
public class JPanelCaixa extends javax.swing.JPanel {

    private CaixaDAO caixaDAO = new CaixaDAOImplArq();
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAOImplArq();
    
    /**
     * Creates new form JPanelCaixa
     */
    public JPanelCaixa() {
        initComponents();
        carregarTabela();
    }
    
    private void carregarTabela() { 
        List<Caixa> caixas = caixaDAO.listar();
        
        DefaultTableModel tableModel = (DefaultTableModel) jTableCaixa.getModel();
        
        // Limpar tabela
        int linhas = tableModel.getRowCount();
        for (int i = 0; i < linhas; i++) {
            tableModel.removeRow(0);
        }
        
        // Preencher tabela
        for (Caixa caixa : caixas) {
            Object[] linha = new Object[3];
            linha[0] = caixa.getId();
            
            if (caixa.getFuncionario() != null) {
                linha[1] = caixa.getFuncionario().getId();
                linha[2] = caixa.getFuncionario().getNome();
            } 
            
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
        jLabel2 = new javax.swing.JLabel();
        jTextFieldFuncionario = new javax.swing.JTextField();
        jTextFieldId = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCaixa = new javax.swing.JTable();

        jLabel1.setText("ID:");

        jLabel2.setText("Funcionario:");

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

        jTableCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID do Funcionario", "Nome do Funcionario"
            }
        ));
        jScrollPane2.setViewportView(jTableCaixa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldId, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(jTextFieldFuncionario)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonExcluir)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldId.setText("");
        jTextFieldFuncionario.setText("");
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        Caixa novoCaixa = new Caixa();
        
        List<Funcionario> funcionarios = funcionarioDAO.listar();
        
        int id = Integer.parseInt(jTextFieldId.getText());
        int idFuncionario = Integer.parseInt(jTextFieldFuncionario.getText());
       
        novoCaixa.setId(id);
        
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == idFuncionario) {
                novoCaixa.setFuncionario(funcionario);
                break;
            }
        }
        
        if (caixaDAO.getById(id) == null) {
            caixaDAO.inserir(novoCaixa);
        } else {
            caixaDAO.editar(novoCaixa);
        }
        
        jButtonLimparActionPerformed(evt);
        carregarTabela();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        int linha = jTableCaixa.getSelectedRow();
        
        if (linha != -1) {
            int id = (int) jTableCaixa.getValueAt(linha, 0);
            
            Caixa caixa = caixaDAO.getById(id);
            
            jTextFieldId.setText(Integer.toString(caixa.getId()));
            if (caixa.getFuncionario() != null) {
                jTextFieldFuncionario.setText(
                        Integer.toString(caixa.getFuncionario().getId())
                );
            } else {
                jTextFieldFuncionario.setText("");
            }
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int[] linhas = jTableCaixa.getSelectedRows();
        
        for (int linha : linhas) {
            int id = (int) jTableCaixa.getValueAt(linha, 0);
            caixaDAO.remover(id);
        }
        
        carregarTabela();
    }//GEN-LAST:event_jButtonExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCaixa;
    private javax.swing.JTextField jTextFieldFuncionario;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables
}
