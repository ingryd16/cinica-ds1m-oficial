package br.senai.sp.jandira.dao;

import br.senai.sp.jandira.model.Especialidade;
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

public class EspecialidadesDAO {

    private Especialidade especialidades;
    private static ArrayList<Especialidade> especialidadeArray = new ArrayList<>();
    private final static String ARQUIVO = "C:\\Users\\22282092\\clinica-pastas\\java-especialidade\\especialidades.txt";
    private static final Path PATH = Paths.get(ARQUIVO);
    private static final String ARQUIVO_TEMP = "C:\\Users\\22282092\\clinica-pastas\\java-especialidade\\especialidades-temp.txt";
    private static final Path PATH_TEMP = Paths.get(ARQUIVO_TEMP);
    
    public EspecialidadesDAO(Especialidade especialidade) {
        this.especialidadeArray.add(especialidades);
    }

    public EspecialidadesDAO() {

    }

    public static void gravar(Especialidade especialidades) {
        especialidadeArray.add(especialidades);
        
        try {
            //gravar a especialidade no arquivo de texto
            BufferedWriter bw = Files.newBufferedWriter(
                    PATH,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);
            bw.write(especialidades.getEspecialidadeSeparadoPorPontoEVirgula());
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "ocorreu um erro ao gravar \n\nentre em contato com o suporte",
                    "erro ao gravar",
                    JOptionPane.ERROR_MESSAGE);
        }  
        
    }

    public static boolean excluir(Integer codigo) {
        for (Especialidade e : especialidadeArray) {
            if (e.getCodigo().equals(codigo)) {
                especialidadeArray.remove(e);
                break;
            }
        }
        atualizarArquivo();
        return false;
    }

    public static Especialidade getEspecialidade(Integer codigo) {

        for (Especialidade e : especialidadeArray) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }

        return null;
    }

    public static void atualizar(Especialidade especialidades) {
        for (Especialidade e : especialidadeArray) {
            if (e.getCodigo().equals(especialidades.getCodigo())) {
                especialidadeArray.set(especialidadeArray.indexOf(e), especialidades);
                break;
            }
        }
    }

    public static ArrayList<Especialidade> listarTodos() {
        return especialidadeArray;
    }
    
    public static void getListaEspecialidades() {
         try {
            //abrir o arquivo para leitura - leitor
            BufferedReader br = Files.newBufferedReader(PATH);
            String linha = br.readLine();
            
            while (linha != null && !linha.isEmpty()){
                String[] linhaVetor = linha.split(";");
                Especialidade novaEspecialidade = new Especialidade(
                        Integer.valueOf(linhaVetor[0]), 
                        linhaVetor[1], 
                        linhaVetor[2]);
                especialidadeArray.add(novaEspecialidade);
                linha = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "ocorreu um erro ao abrir o arquivo", 
                    "erro ao abrir", 
                    JOptionPane.ERROR_MESSAGE);
        }
//        Especialidade e1 = new Especialidade("Cirurgia Geral", "Tem por objetivo diagnosticar e tratar doenças por meio de procedimentos cirúrgicos");
//        Especialidade e2 = new Especialidade("Ginecologia", "Especialidade da Medicina dedicada ao estudo do aparelho genital feminino como um todo.");
//        Especialidade e3 = new Especialidade("Pediatra", "Cuida de crianças desde o nascimento até a adolescência.");
//        Especialidade e4 = new Especialidade("Dermatologia", "Diagnostica e trata diversas doenças, como, por exemplo, câncer de pele");
//        especialidadeArray.add(e1);
//        especialidadeArray.add(e2);
//        especialidadeArray.add(e3);
//        especialidadeArray.add(e4);
    }


    public static DefaultTableModel getTableModel() {

        // Matriz que receberá as especialidades
        // que serão utilizadas na Tabela (JTable)
        Object[][] dados = new Object[especialidadeArray.size()][3];

        // For Each, para extrair cada objeto especialidade do
        // arraylist especialidadeArray e separar cada dado na matriz dados
        int i = 0;
        for (Especialidade e : especialidadeArray) {
            dados[i][0] = e.getCodigo();
            dados[i][1] = e.getNome();
            dados[i][2] = e.getDescricao();
            i++;
        }

        // Definir um vetor com os nomes das colulas da tabela
        String[] titulos = {"Código", "Nome da especialidade", "Descrição"};

        // Criar o modelo que será utilizado pela JTable 
        // para exibir os dados da especialidade
        DefaultTableModel tableModel = new DefaultTableModel(dados, titulos);

        return tableModel;

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
            
            for (Especialidade e : especialidadeArray) {
                bwTemp.write(e.getEspecialidadeSeparadoPorPontoEVirgula());
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
    
}
