package org.example.dao;

import org.example.factory.ConnectionFactory;
import org.example.model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AlunoDao {

    private Connection conn;

    public AlunoDao(){
        this.conn = new ConnectionFactory().getConnection();
    };

    public String inserirAluno(Aluno aluno){
        System.out.println("Inserindo...");
        String sql = "INSERT INTO tb_aluno(al_cpf, al_nome, al_nascimento, al_peso, al_altura) VALUES (?, ?, ?, ?, ?)";
        String res = "";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getCpf());
            stmt.setString(2, aluno.getNome());

            LocalDate dataNascimento = LocalDate.parse(aluno.getDataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            stmt.setString(3, dataNascimento.toString());

            stmt.setDouble(4, aluno.getPeso());
            stmt.setDouble(5, aluno.getAltura());
            stmt.executeUpdate();
            stmt.close();

            res = "Inserção Concluída!";
        }
        catch (SQLException e) {
            res = "Erro na inserção: " + e;
            throw new RuntimeException(e);
        }
        return res;
    }



    public String excluirAluno(String cpf){
        System.out.println("Excluíndo...");
        String sql = "DELETE FROM tb_aluno WHERE al_cpf = ?";
        String res = "";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.execute();
            stmt.close();

            res = "Exclusão Concluída!";
        }
        catch (SQLException e) {
            res = "Erro na Exclusão: " +e;
            throw new RuntimeException(e);
        }

        return res;
    }

    public String atualizarAluno(Aluno aluno){
        System.out.println("Atualizando...");
        String sql = "UPDATE tb_aluno SET al_nome = ?, al_nascimento = ?, al_peso = ?, al_altura = ? WHERE al_cpf = ?";
        String res = "";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());

            LocalDate dataNascimento = LocalDate.parse(aluno.getDataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            stmt.setString(2, dataNascimento.toString());

            stmt.setDouble(3, aluno.getPeso());
            stmt.setDouble(4, aluno.getAltura());
            stmt.setString(5, aluno.getCpf());
            stmt.executeUpdate();
            stmt.close();

            res = "Atualização Concluída!";
        }

        catch (SQLException e) {
            res = "Erro na Exclusão: " + e;
            throw new RuntimeException(e);
        }

        return res;
    }

    public String consultarAlunos() {
        System.out.println("Consultando...");
        String sql = "SELECT * FROM tb_aluno";
        String res = "";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Consulta Concluída! Verifique o resultado abaixo: ");

            while (rs.next()) {

                String cpf = rs.getString("al_cpf");
                String nome = rs.getString("al_nome");

                LocalDate dataMysql = LocalDate.parse(rs.getString("al_nascimento"));
                String data = dataMysql.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                String altura = rs.getString("al_altura");
                String peso = rs.getString("al_peso");

                res += nome + ", " + data + ", " + cpf + ", " + peso + ", " + altura + "\n";
            }

            stmt.close();

        } catch (SQLException e) {
            res = "Erro na Consulta: " + e;
            throw new RuntimeException(e);
        }

        return res;
    }
}
