package br.senai.sp.jandira.dao;

import br.senai.sp.jandira.model.Especialidade;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class EspecialidadesDAO {

    private Especialidade especialidades;
    private static ArrayList<Especialidade> especialidadeArray = new ArrayList<>();

    public EspecialidadesDAO(Especialidade especialidade) {
        this.especialidadeArray.add(especialidades);
    }

    public EspecialidadesDAO() {

    }

    public static void gravar(Especialidade especialidades) {
        especialidadeArray.add(especialidades);
    }

    public static boolean excluir(Integer codigo) {
        for (Especialidade e : especialidadeArray) {
            if (e.getCodigo().equals(codigo)) {
                especialidadeArray.remove(e);
                return true;
            }
        }
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
    
    public static void criarEspecialidadesTeste() {
        Especialidade e1 = new Especialidade("Cirurgia Geral", "Tem por objetivo diagnosticar e tratar doenças por meio de procedimentos cirúrgicos");
        Especialidade e2 = new Especialidade("Ginecologia", "Especialidade da Medicina dedicada ao estudo do aparelho genital feminino como um todo.");
        Especialidade e3 = new Especialidade("Pediatra", "Cuida de crianças desde o nascimento até a adolescência.");
        Especialidade e4 = new Especialidade("Dermatologia", "Diagnostica e trata diversas doenças, como, por exemplo, câncer de pele");
        especialidadeArray.add(e1);
        especialidadeArray.add(e2);
        especialidadeArray.add(e3);
        especialidadeArray.add(e4);
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

}
