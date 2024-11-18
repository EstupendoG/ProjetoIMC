package org.example.factory;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConnection {
    public static void main(String[] args) throws SQLException {
        Connection conn = new ConnectionFactory().getConnection();
        System.out.println("Conexão Aberta");
        conn.close();
    }
}
