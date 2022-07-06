package com.gustavo.cursovraptor.controllers;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.gustavo.cursovraptor.model.dao.ProdutoDao;
import com.gustavo.cursovraptor.model.entities.Produto;

import br.com.caelum.vraptor.Resource;

@Resource
public class ProdutosController {

	private ProdutoDao dao;

	public ProdutosController(ProdutoDao dao){
		this.dao = dao;
	}
	
	public List<Produto> lista(){
		List<Produto> produtos = new ArrayList<>();
		try {
			produtos = dao.listar();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		return produtos;
	}

}
