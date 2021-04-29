package com.example.demo1.controller;

import com.example.demo1.dao.FilmeDAO;
import com.example.demo1.dao.SessaoDAO;
import com.example.demo1.model.Filme;

import com.example.demo1.model.Sessao;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sessoes")
public class SessaoController {

	@GET
	@Path("nova")
	public Response criaTabelaSessao()
	{
		SessaoDAO dao = new SessaoDAO();
		dao.criaTabelaSessao();

		return Response.ok(new Gson().toJson("criada")).build();
	}

	@GET
	@Produces("application/json")
	public Response listDemand() {

		SessaoDAO dao = new SessaoDAO();
		List<Sessao> ses = dao.listaSessao();
		return Response.ok(new Gson().toJson(ses)).build();

	}
}
