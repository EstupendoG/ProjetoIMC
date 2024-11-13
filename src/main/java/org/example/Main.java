package org.example;

import org.example.model.Aluno;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        Aluno aluno1 = new Aluno("1232434", "José", "12/03/2014", 70, 1.71);
        aluno1.calculaIMC();
    }
}