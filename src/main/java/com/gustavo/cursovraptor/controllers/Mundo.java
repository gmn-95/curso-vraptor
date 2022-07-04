package com.gustavo.cursovraptor.controllers;

import java.util.ArrayList;
import java.util.List;

import com.gustavo.cursovraptor.model.entities.Produto;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class Mundo {

	private final Result result;
	
	public Mundo(Result result) {
		this.result = result;
	}
	
	public void hello() {
		result.include("ola", "Olá as!");
	}
	
	public void paises() {
		List<String> resultado = new ArrayList<>();
		resultado.add("Brasil");
		resultado.add("Portugal");
		resultado.add("Japão");
		resultado.add("Canadá");
		resultado.add("Paraguai");
		
		String teste = "testou";
		
		result.include("listaPaises", resultado).include("teste", teste);
	}
	
	public Integer inteiro() {
		return 10;
	}
	
	public Produto produto() {
		return new Produto("ps5", "video game", 5000.0);
	}

}
