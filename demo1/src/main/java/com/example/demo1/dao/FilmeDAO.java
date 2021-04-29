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

public class FilmeDAO {

    private static Connection connection;

    public FilmeDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaTabelaFilme() {
        String sql = "CREATE TABLE IF NOT EXISTS filme (" +
                "idFilme INT PRIMARY KEY AUTO_INCREMENT," +
                "nomeFilme VARCHAR(50) NOT NULL," +
                "idadeFilme INT " +
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
    public static List<Filme> listaFilme() {
        String sql = "SELECT * FROM filme";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Filme> filmes = new ArrayList<>();
            Filme filme;

            while (resultSet.next()) {
                filme = new Filme();
                filme.setIdFilme(resultSet.getInt("idFilme"));
                filme.setNomeFilme(resultSet.getString("nomeFilme"));
                filme.setIdadeFilme(resultSet.getInt("idadeFilme"));

                filmes.add(filme);
            }

            return filmes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Filme findbyid(int idFilme) {
        String sql = "select * from filme where idFilme = ? ";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idFilme);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {

                Filme filme = new Filme();
                filme.setIdFilme(resultSet.getInt("idFilme"));
                filme.setNomeFilme(resultSet.getString("nomeFilme"));
                filme.setIdadeFilme(resultSet.getInt("idadeFilme"));
                return filme;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
