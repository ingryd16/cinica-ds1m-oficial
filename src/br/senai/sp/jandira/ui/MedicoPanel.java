
package br.senai.sp.jandira.ui;

public class MedicoPanel extends javax.swing.JPanel {

    
    public MedicoPanel() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        scrollTableMedico = new javax.swing.JScrollPane();
        tableMedico = new javax.swing.JTable();
        buttonExcluirMedico = new javax.swing.JButton();
        buttonAlterarMedico = new javax.swing.JButton();
        buttonAdicionarMedico = new javax.swing.JButton();

        setLayout(null);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Médicos");
        add(jLabel3);
        jLabel3.setBounds(20, 10, 180, 20);

        tableMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollTableMedico.setViewportView(tableMedico);

        add(scrollTableMedico);
        scrollTableMedico.setBounds(20, 40, 905, 240);

        buttonExcluirMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/delete32-2.png"))); // NOI18N
        buttonExcluirMedico.setToolTipText("Excluir plano de saúde selecionado");
        buttonExcluirMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirMedicoActionPerformed(evt);
            }
        });
        add(buttonExcluirMedico);
        buttonExcluirMedico.setBounds(700, 294, 70, 60);

        buttonAlterarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/edit32.png"))); // NOI18N
        buttonAlterarMedico.setToolTipText("Editar plano de saúde selecionado");
        buttonAlterarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarMedicoActionPerformed(evt);
            }
        });
        add(buttonAlterarMedico);
        buttonAlterarMedico.setBounds(780, 294, 70, 60);

        buttonAdicionarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/add32.png"))); // NOI18N
        buttonAdicionarMedico.setToolTipText("Adicionar plano de saúde");
        buttonAdicionarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarMedicoActionPerformed(evt);
            }
        });
        add(buttonAdicionarMedico);
        buttonAdicionarMedico.setBounds(860, 294, 70, 60);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExcluirMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirMedicoActionPerformed

        // Obtemos o índice da linha selecionada na tabela
        linha = tablePlanosDeSaude.getSelectedRow();

        // Verificamos se a linha é diferente de -1
        // -1 significa que o usuário não selecionou nada
        if (linha != -1) {
            excluir();
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Por favor, selecione o plano que você deseja excluir!",
                "Plano de Saúde",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonExcluirMedicoActionPerformed

    private void buttonAlterarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarMedicoActionPerformed

        linha = tablePlanosDeSaude.getSelectedRow();

        if (linha != -1) {
            editar();
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Por favor, selecione um plano de saúde para alterar.",
                "Planos de Saúde",
                JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_buttonAlterarMedicoActionPerformed

    private void buttonAdicionarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarMedicoActionPerformed

        PlanosDeSaudeDialog planosDeSaudeDialog =
        new PlanosDeSaudeDialog(
            null,
            true,
            TipoOperacao.ADICIONAR,
            null);

        planosDeSaudeDialog.setVisible(true);

        criarTabelaPlanosDeSaude();
    }//GEN-LAST:event_buttonAdicionarMedicoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionarMedico;
    private javax.swing.JButton buttonAlterarMedico;
    private javax.swing.JButton buttonExcluirMedico;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane scrollTableMedico;
    private javax.swing.JTable tableMedico;
    // End of variables declaration//GEN-END:variables
}
