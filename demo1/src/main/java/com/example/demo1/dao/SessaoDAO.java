package com.example.demo1.dao;


import com.example.demo1.factory.ConnectionFactory;
import com.example.demo1.model.Filme;
import com.example.demo1.model.Sessao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SessaoDAO {

    private static Connection connection;

    public SessaoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaTabelaSessao() {
        String sql = "CREATE TABLE IF NOT EXISTS sessao (" +
                "idSessao INT PRIMARY KEY AUTO_INCREMENT," +
                "numSessao INT ," +
                "preco DECIMAL(10,2)," +
                "dadosdofilme INT," +
                "FOREIGN KEY (dadosdofilme)" +
                "REFERENCES filme(idFilme)" +
                ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Sessao> listaSessao() {
        String sql = "SELECT * FROM sessao";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Sessao> sessaos = new ArrayList<>();
            Sessao sessao;

            while (resultSet.next()) {
                sessao = new Sessao();
                sessao.setIdSessao(resultSet.getLong("idSessao"));
                sessao.setNumSala(resultSet.getInt("numSessao"));
                sessao.setPreco(resultSet.getDouble("preco"));

                 FilmeDAO filmeDAO = new FilmeDAO();
                    Filme filme = filmeDAO.findbyid(resultSet.getInt("dadosdofilme")) ;
                    sessao.setDadosdoFilme(filme);
                sessaos.add(sessao);
            }

            return sessaos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}


