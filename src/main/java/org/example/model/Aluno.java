package org.example.model;

import java.util.Date;

public class Aluno {
    private String cpf;
    private String nome;
    private String dataNascimento;
    private double peso;
    private double altura;

    //CONSTRUCTOR
    public Aluno(String cpf, String nome, String dataNascimento, double peso, double altura) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.altura = altura;
    }

    //GETTERS
    public String getCpf() {
        return cpf;
    }

    public String getNome(){ return nome;}

    public String getDataNascimento() {
        return dataNascimento;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    //SETTERS
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}
