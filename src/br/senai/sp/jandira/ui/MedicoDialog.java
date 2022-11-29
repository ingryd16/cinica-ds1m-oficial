package br.senai.sp.jandira.ui;

import br.senai.sp.jandira.dao.MedicoDAO;
import br.senai.sp.jandira.model.Medico;
import br.senai.sp.jandira.model.TipoOperacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class MedicoDialog extends javax.swing.JDialog {
    
    private TipoOperacao tipoOperacao;
    private Medico medico;
    
    private DefaultListModel<String> listaTodosModel = new DefaultListModel<>();
    private ArrayList<String> especialidadesArray = new ArrayList<>();
    
    private DefaultListModel<String> selecionadosModel = new DefaultListModel<>();
    private ArrayList<String> especialidadesSelecionadasArray = new ArrayList<>();

    public MedicoDialog(
            java.awt.Frame parent, 
            boolean modal, 
            TipoOperacao tipoOperacao,
            Medico medico) {
        
        super(parent, modal);
        initComponents();
        carregarEspecialidades();
        this.tipoOperacao = tipoOperacao;
        this.medico = medico;
        
        // Preencher os campos, caso o tipo de operação for ALTERAR
        if(tipoOperacao == TipoOperacao.ALTERAR) {
            preencherFormulario();
        } 
    }
    
        private void carregarEspecialidades() {
        especialidadesArray.add("100 - Cotia");
        especialidadesArray.add("200 - Itapevi");
        especialidadesArray.add("300 - São Roque");
        especialidadesArray.add("400 - Osasco");
        especialidadesArray.add("500 - Barueri");
        especialidadesArray.add("600 - Carapicuíba");
        especialidadesArray.add("700 - Santana de Parnaíba");
        
        listaTodosModel.addAll(especialidadesArray);
        ListListaDeEspecialidades.setModel(listaTodosModel);
    }
    
        private void preencherFormulario() {
        labelTitulo.setText("Medico - " + tipoOperacao);
        labelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/edit32.png")));
        textCodigo.setText(medico.getCodigo().toString());
        textCrm.setText(medico.getCrm());
        textNome.setText(medico.getNome());
        textTelefone.setText(medico.getTelefone());
        textEmail.setText(medico.getEmail());
//        textData.setText(medico.getDataDeNascimento().toString());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        dataLabel = new javax.swing.JLabel();
        codigoLabel = new javax.swing.JLabel();
        crmLabel = new javax.swing.JLabel();
        nomeLabel = new javax.swing.JLabel();
        listaLabel = new javax.swing.JLabel();
        telefoneLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        listaMedicoLabel = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        textCrm = new javax.swing.JTextField();
        textNome = new javax.swing.JTextField();
        textTelefone = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        textData = new javax.swing.JTextField();
        ScrollListaDeEspecialidades = new javax.swing.JScrollPane();
        ListListaDeEspecialidades = new javax.swing.JList<>();
        ScrollListaDeEspecialidadesMedico = new javax.swing.JScrollPane();
        ListListaDeEspecialidadesMedico = new javax.swing.JList<>();
        botaoPass = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        buttonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/add32.png"))); // NOI18N
        labelTitulo.setText("Cadastro de médicos - NOVO");
        jPanel1.add(labelTitulo);
        labelTitulo.setBounds(10, 10, 530, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 770, 50);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes do médico:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(153, 0, 51))); // NOI18N
        jPanel2.setLayout(null);

        dataLabel.setText("Data De Nascimento");
        jPanel2.add(dataLabel);
        dataLabel.setBounds(450, 100, 108, 16);

        codigoLabel.setText("Código");
        jPanel2.add(codigoLabel);
        codigoLabel.setBounds(20, 40, 39, 16);

        crmLabel.setText("CRM");
        jPanel2.add(crmLabel);
        crmLabel.setBounds(130, 40, 26, 16);

        nomeLabel.setText("Nome");
        jPanel2.add(nomeLabel);
        nomeLabel.setBounds(250, 40, 33, 16);

        listaLabel.setText("Lista de especialidades");
        jPanel2.add(listaLabel);
        listaLabel.setBounds(30, 180, 119, 16);

        telefoneLabel.setText("Telefone");
        jPanel2.add(telefoneLabel);
        telefoneLabel.setBounds(20, 100, 45, 16);

        emailLabel.setText("E-mail");
        jPanel2.add(emailLabel);
        emailLabel.setBounds(170, 100, 37, 16);

        listaMedicoLabel.setText("Especialidades do Médico");
        jPanel2.add(listaMedicoLabel);
        listaMedicoLabel.setBounds(220, 180, 150, 16);

        textCodigo.setEditable(false);
        textCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodigoActionPerformed(evt);
            }
        });
        jPanel2.add(textCodigo);
        textCodigo.setBounds(20, 60, 80, 22);
        jPanel2.add(textCrm);
        textCrm.setBounds(130, 60, 90, 22);
        jPanel2.add(textNome);
        textNome.setBounds(250, 60, 350, 22);

        textTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTelefoneActionPerformed(evt);
            }
        });
        jPanel2.add(textTelefone);
        textTelefone.setBounds(20, 120, 120, 22);
        jPanel2.add(textEmail);
        textEmail.setBounds(170, 120, 250, 22);
        jPanel2.add(textData);
        textData.setBounds(450, 120, 150, 22);

        ListListaDeEspecialidades.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ScrollListaDeEspecialidades.setViewportView(ListListaDeEspecialidades);

        jPanel2.add(ScrollListaDeEspecialidades);
        ScrollListaDeEspecialidades.setBounds(30, 200, 120, 130);

        ListListaDeEspecialidadesMedico.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ScrollListaDeEspecialidadesMedico.setViewportView(ListListaDeEspecialidadesMedico);

        jPanel2.add(ScrollListaDeEspecialidadesMedico);
        ScrollListaDeEspecialidadesMedico.setBounds(220, 200, 140, 130);

        botaoPass.setText(">");
        botaoPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPassActionPerformed(evt);
            }
        });
        jPanel2.add(botaoPass);
        botaoPass.setBounds(160, 250, 50, 23);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 70, 630, 350);

        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/cancel32.png"))); // NOI18N
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonCancelar);
        buttonCancelar.setBounds(560, 430, 80, 60);

        buttonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/save32.png"))); // NOI18N
        buttonSalvar.setToolTipText("Salvar Cadastro");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSalvar);
        buttonSalvar.setBounds(450, 430, 80, 60);

        setBounds(0, 0, 668, 513);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed

        if(tipoOperacao == TipoOperacao.ADICIONAR) {
            gravar();
        } else {
            atualizar();
        }
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void textCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodigoActionPerformed

    private void textTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTelefoneActionPerformed

    private void botaoPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPassActionPerformed
        //String cidade = ListListaDeEspecialidades.getSelectedValue(); Pega somente um, o primeiro
        //Object[] cidades = ListListaDeEspecialidades.getSelectedValues(); Depreciado
        List<String> especialidadesArray = ListListaDeEspecialidades.getSelectedValuesList(); // Usar esse aqui
        
        for (String especialidade : especialidadesArray){
            especialidadesSelecionadasArray.add(especialidade);
        }
        
        selecionadosModel.clear();
        selecionadosModel.addAll(especialidadesSelecionadasArray);
        ListListaDeEspecialidadesMedico.setModel(selecionadosModel);
    }//GEN-LAST:event_botaoPassActionPerformed

private void atualizar() {
        medico.setCrm(textCrm.getText());
        medico.setNome(textNome.getText());
        medico.setEmail(textEmail.getText());
        medico.setTelefone(textTelefone.getText());
        
        if (validarCadastro()){
        MedicoDAO.atualizar(medico);
        JOptionPane.showMessageDialog(
                null, 
                "Medico atualizado com sucesso!",
                "Medico",
                JOptionPane.INFORMATION_MESSAGE);
        dispose();
        }
    }
    
private void gravar() {
        Medico medico = new Medico();
        medico.setCrm(textCrm.getText());
        medico.setNome(textNome.getText());
//        medico.setDataDeNascimento(textData.getText());
        medico.setEmail(textEmail.getText());
        medico.setTelefone(textTelefone.getText());
    
        if (validarCadastro()){
            MedicoDAO.gravar(medico);
            
            JOptionPane.showMessageDialog(
                    this, 
                    "Medico gravado com sucesso!", 
                    "Medico", 
                    JOptionPane.INFORMATION_MESSAGE);
            
            dispose();
        }
    }
    
private boolean validarCadastro() {
        
        if (textNome.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(
                    this, 
                    "Por favor preencha o nome!", 
                    "Medico", 
                    JOptionPane.ERROR_MESSAGE);
            
            textNome.requestFocus();
            return false;
        }
        
        if (textCrm.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(
                    this, 
                    "Por favor preencha o CRM!", 
                    "Medico", 
                    JOptionPane.ERROR_MESSAGE);
            
            textCrm.requestFocus();
            return false;  
        }
        
        if (textTelefone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, preencha o número de telefone!!",
                    "Médico",
                    JOptionPane.ERROR_MESSAGE);

            textTelefone.requestFocus();
            return false;
        }
        if (textEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, preencha o email!!",
                    "Médico",
                    JOptionPane.ERROR_MESSAGE);

            textEmail.requestFocus();
            return false;
        }
        if (textData.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, preencha a data de nascimento!!",
                    "Médico",
                    JOptionPane.ERROR_MESSAGE);

            textData.requestFocus();
            return false;
        }
        return true;
    }
        
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListListaDeEspecialidades;
    private javax.swing.JList<String> ListListaDeEspecialidadesMedico;
    private javax.swing.JScrollPane ScrollListaDeEspecialidades;
    private javax.swing.JScrollPane ScrollListaDeEspecialidadesMedico;
    private javax.swing.JButton botaoPass;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JLabel codigoLabel;
    private javax.swing.JLabel crmLabel;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel listaLabel;
    private javax.swing.JLabel listaMedicoLabel;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JLabel telefoneLabel;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textCrm;
    private javax.swing.JTextField textData;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textTelefone;
    // End of variables declaration//GEN-END:variables

    
}
