package br.senai.sp.jandira.dao;

import br.senai.sp.jandira.model.Medico;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MedicoDAO {
    
    private Medico medico;
    private static ArrayList<Medico> medicoArray = new ArrayList<>();
    
    private static final String ARQUIVO = "C:\\Users\\22282092\\clinica-pastas\\java-medico\\medico.txt";
    private static final Path PATH = Paths.get(ARQUIVO);
    private static final String ARQUIVO_TEMP = "C:\\Users\\22282092\\clinica-pastas\\java-medico\\medico-temp.txt";
    private static final Path PATH_TEMP = Paths.get(ARQUIVO_TEMP);

    public MedicoDAO(Medico medico) {
        this.medicoArray.add(medico);
    }

    public MedicoDAO() {

    }
    
    public static void gravar(Medico medico) {
        medicoArray.add(medico);
        try {
        BufferedWriter bw = Files.newBufferedWriter(
                PATH,
                StandardOpenOption.APPEND,
                StandardOpenOption.WRITE);  
        String novoMedico = medico.getMedicoSeparadoPorPontoEVirgula();
                bw.write(novoMedico);
                bw.newLine();
                bw.close();
                
    } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, 
                    "Houve um problema ao tentar abrir o arquivo.",
                    "Erro ao gravar",
                    JOptionPane.ERROR_MESSAGE);
     
        }    
    }
    
    public static boolean excluir(Integer codigo) {
        for(Medico m : medicoArray) {
            if(m.getCodigo().equals(codigo)){
                medicoArray.remove(m);
                break;
            }
        }
        atualizarArquivo();
        return false;
    }
    
    public static Medico getMedico(Integer codigo) {
      
        for(Medico m : medicoArray) {
            if(m.getCodigo().equals(codigo)){
                return m;
            }
        }
        
        return null;  
    }
    
    public static void atualizarArquivo (){
        File arquivoAtual = new File(ARQUIVO);
        File arquivoTemp = new File(ARQUIVO_TEMP);
        
        try {
            arquivoTemp.createNewFile();
            
            BufferedWriter bwTemp = Files.newBufferedWriter(
                    PATH_TEMP, 
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);
            
            for (Medico m : medicoArray) {
                bwTemp.write(m.getMedicoSeparadoPorPontoEVirgula());
                bwTemp.newLine();    
            }
            //fechr o arquivo temporario
            bwTemp.close();
            
            //excluir o arquivo atual - plano-de-saude.txt
            arquivoAtual.delete();
            
            //renomear o arquivo temp
            arquivoTemp.renameTo(arquivoAtual);
            
            } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "OCORREU UM ERRO AO CRIAR O ARQUIVO", 
                    "ERRO", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void atualizar(Medico medico) {
        for(Medico m : medicoArray) {
            if(m.getCodigo().equals(medico.getCodigo())){
                medicoArray.set(medicoArray.indexOf(m), medico);
                break;
            }
        }
    }
    
    public static ArrayList<Medico> listarTodos() {
        return medicoArray;
    }
    
    public static void getListaMedico() {
        try {
            //abrir o arquivo para leitura - leitor
            BufferedReader br = Files.newBufferedReader(PATH);
            String linha = br.readLine();
            
            while (linha != null && !linha.isEmpty()){
                String[] linhaVetor = linha.split(";");
                Medico novoMedico = new Medico(
                        Integer.valueOf(linhaVetor[0]),
                        linhaVetor[1],
                        linhaVetor[2]);
                medicoArray.add(novoMedico);
                linha = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "ocorreu um erro ao abrir o arquivo", 
                    "erro ao abrir", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public static DefaultTableModel getTableModel() {

        Object[][] dados = new Object[medicoArray.size()][3];

        int i = 0;
        for (Medico m : medicoArray) {
            dados[i][0] = m.getCodigo();
            dados[i][1] = m.getCrm();
            dados[i][2] = m.getNome();
            
            i++;
        }
        
        String[] titulos = {"Código", "CRM", "Nome do medico"};

        DefaultTableModel tableModel = new DefaultTableModel(dados, titulos);

        return tableModel;
    }
    
}
