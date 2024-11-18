package org.example.dao;

import org.example.factory.ConnectionFactory;
import org.example.model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AlunoDao {

    private Connection conn;

    public AlunoDao(){
        this.conn = new ConnectionFactory().getConnection();
    };

    public void inserirAluno(Aluno aluno){
        System.out.println("Inserindo...");
        String sql = "INSERT INTO tb_aluno(al_cpf, al_nome, al_nascimento, al_peso, al_altura) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getCpf());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getDataNascimento());
            stmt.setDouble(4, aluno.getPeso());
            stmt.setDouble(5, aluno.getAltura());
            stmt.execute();
            stmt.close();

            System.out.println("Inserção Concluída!");
        }
        catch (SQLException e) {
            System.out.println("Erro na inserção: ");
            throw new RuntimeException(e);
        }

    }



    public void excluirAluno(Aluno aluno){
        System.out.println("Excluíndo...");
        String sql = "DELETE FROM tb_aluno WHERE al_cpf = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getCpf());
            stmt.execute();
            stmt.close();

            System.out.println("Exclusão Concluída!");
        }
        catch (SQLException e) {
            System.out.println("Erro na Exclusão: ");
            throw new RuntimeException(e);
        }
    }

    public void atualizarAluno(Aluno aluno){
        System.out.println("Excluíndo...");
        String sql = "DELETE FROM tb_aluno WHERE al_cpf = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getCpf());

            System.out.println("Exclusão Concluída!");
        }
        catch (SQLException e) {
            System.out.println("Erro na Exclusão: ");
            throw new RuntimeException(e);
        }
    }
    public void consultarAluno(Aluno aluno){
        System.out.println("Consultando...");
        String sql = "SELECT * FROM tb_aluno WHERE al_cpf =  ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getCpf());
            ResultSet rs = stmt.executeQuery();

            System.out.println("Consulta Concluída! Verifique o resultado abaixo: ");

            if(rs.next()){
                String cpf = rs.getString("al_cpf");
                String nome = rs.getString("al_nome");
                String data = rs.getString("al_nascimento");
                double altura = rs.getDouble("al_altura");
                double peso = rs.getDouble("al_peso");

                System.out.println("-------------------");
                System.out.println("CPF: " + cpf);
                System.out.println("Nome: " + nome);
                System.out.println("Data de Nascimento: " + data);
                System.out.println("Altura: " + altura);
                System.out.println("Peso: " + peso);
            }
            else{
                System.out.println("Nenhum aluno com este CPF.");
            }

            stmt.close();

        }
        catch (SQLException e) {
            System.out.println("Erro na Consulta: ");
            throw new RuntimeException(e);
        }
    }
}
