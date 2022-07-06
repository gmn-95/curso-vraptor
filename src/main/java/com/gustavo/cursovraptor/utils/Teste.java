package com.gustavo.cursovraptor.utils;

import com.gustavo.cursovraptor.controllers.ProdutosController;
import com.gustavo.cursovraptor.model.dao.ProdutoDao;
import com.gustavo.cursovraptor.model.entities.Produto;


public class Teste {
    public static void main(String[] args) {
        Produto produto = new Produto("teste", "testando", 50.0);
        ProdutoDao dao = new ProdutoDao();
        dao.salvar(produto);
    }
}
