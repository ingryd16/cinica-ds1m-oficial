package br.senai.sp.jandira.dao;

import java.util.ArrayList;

import br.senai.sp.jandira.model.PlanoDeSaude;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PlanoDeSaudeDAO { // Simular nosso banco de dados

    private PlanoDeSaude planoDeSaude;
    private static ArrayList<PlanoDeSaude> planos = new ArrayList<>();
    
    private static final String ARQUIVO = "C:\\Users\\22282092\\clinica-pastas\\java-planoDeSaude\\plano-de-saude.txt";
    private static final Path PATH = Paths.get(ARQUIVO);
    private static final String ARQUIVO_TEMP = "C:\\Users\\22282092\\clinica-pastas\\java-planoDeSaude\\plano-de-saude-temp.txt";
    private static final Path PATH_TEMP = Paths.get(ARQUIVO_TEMP);

    public PlanoDeSaudeDAO(PlanoDeSaude planoDeSaude) {
        this.planos.add(planoDeSaude);
    }

    public PlanoDeSaudeDAO() {

    }

    public static void gravar(PlanoDeSaude planoDeSaude) {
        planos.add(planoDeSaude);
        try {
        BufferedWriter bw = Files.newBufferedWriter(
                PATH,
                StandardOpenOption.APPEND,
                StandardOpenOption.WRITE);  
        String novoPlanoDeSaude = planoDeSaude.getPlanoDeSaudeSeparadoPorPontoEVirgula();
                bw.write(novoPlanoDeSaude);
                bw.newLine();
                bw.close();
                
    } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, 
                    "Houve um problema ao tentar abrir o arquivo.",
                    "Erro ao gravar",
                    JOptionPane.ERROR_MESSAGE);
     
        }    
    }
    
    public static boolean excluir(Integer codigo) {
        for(PlanoDeSaude p : planos) {
            if(p.getCodigo().equals(codigo)){
                planos.remove(p);
                break;
            }
        }
        atualizarArquivo();
        return false;
    }
       
    public static PlanoDeSaude getPlanoDeSaude(Integer codigo) {
      
        for(PlanoDeSaude p : planos) {
            if(p.getCodigo().equals(codigo)){
                return p;
            }
        }
        
        return null;  
    }
    
    public static void atualizarArquivo (){
    //reconstruir um arquivo atualizado, ou seja, sem o plano q foi removido
        //PASSO 1 = CRIAR UMA REPRESENTAÇAO DOS ARQUIVOS Q SERAO MANIPULADOS
        File arquivoAtual = new File(ARQUIVO);
        File arquivoTemp = new File(ARQUIVO_TEMP);
        
        try {
            arquivoTemp.createNewFile();
            
            BufferedWriter bwTemp = Files.newBufferedWriter(
                    PATH_TEMP, 
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);
            
            for (PlanoDeSaude p : planos) {
                bwTemp.write(p.getPlanoDeSaudeSeparadoPorPontoEVirgula());
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
    
    public static void atualizar(PlanoDeSaude planoDeSaude) {
        for(PlanoDeSaude p : planos) {
            if(p.getCodigo().equals(planoDeSaude.getCodigo())){
                planos.set(planos.indexOf(p), planoDeSaude);
                break;
            }
        }
    }

    public static ArrayList<PlanoDeSaude> listarTodos() {
        return planos;
    }

    public static void getListaPlanosDeSaude() {
        try {
            //abrir o arquivo para leitura - leitor
            BufferedReader br = Files.newBufferedReader(PATH);
            String linha = br.readLine();
            
            while (linha != null && !linha.isEmpty()){
                String[] linhaVetor = linha.split(";");
                PlanoDeSaude novoPlanoDeSaude = new PlanoDeSaude(
                        Integer.valueOf(linhaVetor[0]),
                        linhaVetor[1],
                        linhaVetor[2]);
                planos.add(novoPlanoDeSaude);
                linha = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "ocorreu um erro ao abrir o arquivo", 
                    "erro ao abrir", 
                    JOptionPane.ERROR_MESSAGE);
        }
   
                
//        PlanoDeSaude p1 = new PlanoDeSaude("Unimed", "Bronze");
//        PlanoDeSaude p2 = new PlanoDeSaude("Unimed", "Ouro");
//        PlanoDeSaude p3 = new PlanoDeSaude("Amil", "Advanced");
//        PlanoDeSaude p4 = new PlanoDeSaude("Bradesco", "Exclusive");
//        planos.add(p1);
//        planos.add(p2);
//        planos.add(p3);
//        planos.add(p4);
    }

    public static DefaultTableModel getTableModel() {

        // Matriz que receberá os planos de saúde
        // que serão utilizados na Tabela (JTable)
        Object[][] dados = new Object[planos.size()][3];

        // For Each, para extrair cada objeto plano de saúde do
        // arraylist planos e separar cada dado na matriz dados
        int i = 0;
        for (PlanoDeSaude p : planos) {
            dados[i][0] = p.getCodigo();
            dados[i][1] = p.getOperadora();
            dados[i][2] = p.getTipoDoPlano();
            i++;
        }

        // Definir um vetor com os nomes das colulas da tabela
        String[] titulos = {"Código", "Nome da operadora", "Tipo do plano"};

        // Criar o modelo que será utilizado pela JTable 
        // para exibir os dados dos planos
        DefaultTableModel tableModel = new DefaultTableModel(dados, titulos);

        return tableModel;

    }

}
