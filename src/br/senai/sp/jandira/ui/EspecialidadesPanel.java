package br.senai.sp.jandira.ui;

import br.senai.sp.jandira.dao.EspecialidadesDAO;
import br.senai.sp.jandira.model.Especialidade;
import br.senai.sp.jandira.model.TipoOperacao;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class EspecialidadesPanel extends javax.swing.JPanel {

    int linha;

    public EspecialidadesPanel() {
        initComponents();
        criarTabelaEspecialidades();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scrollTableEspecialidades = new javax.swing.JScrollPane();
        tableEspecialidades = new javax.swing.JTable();
        buttonExcluirEspecialidades = new javax.swing.JButton();
        buttonAlterarEspecialidades = new javax.swing.JButton();
        buttonAdicionarEspecialidades = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(945, 370));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Especialidades");
        add(jLabel1);
        jLabel1.setBounds(20, 10, 180, 20);

        tableEspecialidades.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollTableEspecialidades.setViewportView(tableEspecialidades);

        add(scrollTableEspecialidades);
        scrollTableEspecialidades.setBounds(20, 40, 905, 240);

        buttonExcluirEspecialidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/delete32-2.png"))); // NOI18N
        buttonExcluirEspecialidades.setToolTipText("Excluir especialidade selecionada");
        buttonExcluirEspecialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirEspecialidadesActionPerformed(evt);
            }
        });
        add(buttonExcluirEspecialidades);
        buttonExcluirEspecialidades.setBounds(700, 294, 70, 60);

        buttonAlterarEspecialidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/edit32.png"))); // NOI18N
        buttonAlterarEspecialidades.setToolTipText("Editar especialidade selecionada");
        buttonAlterarEspecialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarEspecialidadesActionPerformed(evt);
            }
        });
        add(buttonAlterarEspecialidades);
        buttonAlterarEspecialidades.setBounds(780, 294, 70, 60);

        buttonAdicionarEspecialidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/add32.png"))); // NOI18N
        buttonAdicionarEspecialidades.setToolTipText("Adicionar especialidade");
        buttonAdicionarEspecialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarEspecialidadesActionPerformed(evt);
            }
        });
        add(buttonAdicionarEspecialidades);
        buttonAdicionarEspecialidades.setBounds(860, 294, 70, 60);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExcluirEspecialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirEspecialidadesActionPerformed

        linha = tableEspecialidades.getSelectedRow();

        //Verificamos se a linha é diferente de -1
        // -1 significa que o usuário não selecionou nada
        if (linha != -1) {
            excluir();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, selecione a especialidade que você deseja excluir!",
                    "Especialidade",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonExcluirEspecialidadesActionPerformed

    private void buttonAlterarEspecialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarEspecialidadesActionPerformed

        linha = tableEspecialidades.getSelectedRow();
        if (linha != -1) {
            editar();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, selecione uma especialidade para alterar.",
                    "Especialidade",
                    JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_buttonAlterarEspecialidadesActionPerformed

    private void buttonAdicionarEspecialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarEspecialidadesActionPerformed

        EspecialidadeDialog especialidadeDialog
                = new EspecialidadeDialog(
                        null,
                        true,
                        TipoOperacao.ADICIONAR,
                        null);

        especialidadeDialog.setVisible(true);

        criarTabelaEspecialidades();
    }//GEN-LAST:event_buttonAdicionarEspecialidadesActionPerformed

    private void editar() {
        Especialidade especialidades = EspecialidadesDAO.getEspecialidade(getCodigo());

        EspecialidadeDialog especialidadeDialog
                = new EspecialidadeDialog(
                        null,
                        true,
                        TipoOperacao.ALTERAR,
                        especialidades);

        especialidadeDialog.setVisible(true);
        criarTabelaEspecialidades();
    }

    private void excluir() {

        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Você confirma a exclusão da especialidade selecionada?",
                "Especialidade",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (resposta == 0) {
            EspecialidadesDAO.excluir(getCodigo());
            criarTabelaEspecialidades();
        }

    }

    private Integer getCodigo() {
        String codigoStr = tableEspecialidades.getValueAt(linha, 0).toString();
        return Integer.valueOf(codigoStr);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionarEspecialidades;
    private javax.swing.JButton buttonAlterarEspecialidades;
    private javax.swing.JButton buttonExcluirEspecialidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scrollTableEspecialidades;
    private javax.swing.JTable tableEspecialidades;
    // End of variables declaration//GEN-END:variables

    private void criarTabelaEspecialidades() {

        tableEspecialidades.setModel(EspecialidadesDAO.getTableModel());

        // Desativar o redimensionamento da JTable
        tableEspecialidades.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Definir a largura de cada coluna
        tableEspecialidades.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableEspecialidades.getColumnModel().getColumn(1).setPreferredWidth(300);
        tableEspecialidades.getColumnModel().getColumn(2).setPreferredWidth(300);

        // Impedir/bloquear a movimentação das colunas
        tableEspecialidades.getTableHeader().setReorderingAllowed(false);

        // Bloquear edição das células
        tableEspecialidades.setDefaultEditor(Object.class, null);

    }
}
