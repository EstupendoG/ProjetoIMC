package org.example;

import org.example.dao.AlunoDao;
import org.example.factory.ConnectionFactory;
import org.example.model.Aluno;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AlunoDao alunoDao = new AlunoDao();

        Aluno aluno1 = new Aluno("1232434", "José", "12/03/2014", 70, 1.71);
        aluno1.calculaIMC();

        alunoDao.consultarAluno(aluno1);
    }
}