package org.example.model;

import javax.swing.text.DateFormatter;
import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public void calculaIMC() throws IOException {
        DecimalFormat df = new DecimalFormat("#.#");
        Double imc = peso / Math.pow(altura, 2);
        String imcString = df.format(imc);

        //Chama o método que define a condição do aluno
        String condicaoAluno = defineIMC(imc);

        //Registra as informações
        registraIMC(imcString, condicaoAluno);
    }

    public String defineIMC(double imc){
        String condicao = "";
        if(imc <= 18.5){
            condicao = "Abaixo do Peso";
        }
        else if (imc <= 24.9) {
            condicao = "Normar";
        }
        else if (imc <= 29.9) {
            condicao = "Sobrepeso";
        }
        else if (imc <= 34.9) {
            condicao = "Obesidade I";
        }
        else if (imc <= 39.9) {
            condicao = "Obesidade II";
        }
        else if (imc > 40) {
            condicao = "Obesidade III";
        }

        return condicao;
    }

    public void registraIMC(String imc, String condicao) throws IOException {

        //Pega a data em que o código é executado e formata
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter dataFormatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataRegistro = dataAtual.format(dataFormatacao);

        //INICIANDO O ARQUIVO
        //Verifica se o diretório existe
        File diretorio = new File("registros");
        if(!diretorio.exists()){
            diretorio.mkdirs();
            System.out.println("Criando o Diretório...");
        }

        //Verifica se o arquivo
        File registro = new File(diretorio, "registro-"+cpf+".txt");
        if(!registro.exists()){
            registro.createNewFile();
            System.out.println("Criando o Registro...");
        }

        //Escrevendo o registro no arquivo
        FileWriter fw = new FileWriter(registro, true);
        BufferedWriter escritor = new BufferedWriter(fw);

        System.out.println("Escrevendo o Registro...");

        escritor.write("Nome: " + nome + " | CPF: " + cpf + " | Data do Registro: [ "+ dataRegistro +" ]");
        escritor.newLine();
        escritor.write( "O IMC calculado foi "+ imc + " sua situação é " + condicao +"!");
        escritor.newLine();
        escritor.newLine();
        escritor.close();
    }
}
