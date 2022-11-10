package br.senai.sp.jandira.model;

import java.time.LocalDate;
import java.util.ArrayList;

    public class Medico extends Pessoa {

    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataDeNascimento;
    private Integer codigo;
    private static int contador = 100;
    private String crm;
    private ArrayList<Especialidade> especialidades;
    private ArrayList<Medico> medicos;
  
    
    // Construtores da classe
    public Medico () {
        atualizarCodigo();
    }
    
    public Medico (String nome) {
        this.nome = nome;
        atualizarCodigo();
    }

    public Medico (Integer codigo, String crm, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.crm = crm;
        this.contador = this.codigo++;

    }

    private void atualizarCodigo() {
	contador++;
        this.codigo = contador;
    }   
    
    
    //Métodos de acesso
    
//    public String getNome(){
//        return nome;
//    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public int getContador() {
        return contador;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public ArrayList<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(ArrayList<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

    public String getMedicoSeparadoPorPontoEVirgula() {
        String MedicoStr = this.codigo + ";" + this.crm + ";" + this.nome + ";" + this.telefone + ";" + this.email + ";" + this.dataDeNascimento + ";" + this.especialidades;
        return MedicoStr;
    }
}