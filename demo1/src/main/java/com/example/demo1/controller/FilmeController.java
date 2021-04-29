package com.example.demo1.controller;

import com.example.demo1.dao.FilmeDAO;
import com.example.demo1.dao.SessaoDAO;
import com.example.demo1.model.Filme;
import com.example.demo1.model.Sessao;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/filmes")
public class FilmeController {
    @GET
    @Path("criatabela")
    @Produces("application/json")
    public Response criaTabelaFilme() {
        FilmeDAO filmeDAO = new FilmeDAO();
        filmeDAO.criaTabelaFilme();
        return Response.ok(new Gson().toJson("Tabela criada com sucesso!")).build();
    }
    @GET
    @Produces("application/json")
    public Response listDemand() {

        FilmeDAO dao = new FilmeDAO();
        List<Filme> filme = dao.listaFilme();
        return Response.ok(new Gson().toJson(filme)).build();

    }

}
