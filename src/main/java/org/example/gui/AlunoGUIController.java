package org.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.dao.AlunoDao;
import org.example.model.Aluno;

import java.io.IOException;

import static java.lang.Double.parseDouble;


public class AlunoGUIController {
    @FXML
    private TextField nomeField;
    @FXML
    private TextField dataField;
    @FXML
    private TextField cpfField;
    @FXML
    private TextField pesoField;
    @FXML
    private TextField alturaField;

    @FXML
    private TextArea textareaOutput;

    String nome;
    String data;
    String cpf;
    double peso;
    double altura;

    Aluno aluno;

    AlunoDao crud = new AlunoDao();

    public void armazenaInput(){
        nome = nomeField.getText();
        data = dataField.getText();
        cpf = cpfField.getText();
        peso = parseDouble(pesoField.getText());
        altura = parseDouble(alturaField.getText());

        aluno = new Aluno(cpf, nome, data, peso, altura);
    }

    public void exibirDados(ActionEvent click){
        textareaOutput.setText(crud.consultarAlunos());
    }

    public void calcularImc(ActionEvent click) throws IOException {
        armazenaInput();

        textareaOutput.setText(aluno.calculaIMC());
    }

    public void insereDados(ActionEvent click){
        armazenaInput();

        textareaOutput.setText( crud.inserirAluno(aluno));
    }

    public void excluirDados(ActionEvent click){
        cpf = cpfField.getText();

        textareaOutput.setText(crud.excluirAluno(cpf));
    }

    public void atualizarDados(ActionEvent click){
        armazenaInput();

        textareaOutput.setText(crud.atualizarAluno(aluno));
    }

}
