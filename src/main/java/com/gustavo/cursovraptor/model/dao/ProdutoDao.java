package com.gustavo.cursovraptor.model.dao;


import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import com.gustavo.cursovraptor.model.entities.Produto;
import com.gustavo.cursovraptor.utils.CriadoDeSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Component
public class ProdutoDao {

	private Session session;

	public ProdutoDao() {
		this.session = CriadoDeSession.getSession();;
	}

	public void salvar(Produto produto) {
		Transaction tx = session.beginTransaction();
		session.save(produto);
		tx.commit();
	}

	public void deletar(Produto produto) {
		Transaction tx = session.beginTransaction();
		produto = (Produto) session.load(Produto.class, produto.getId());
		session.delete(produto);
		tx.commit();
	}
	
	public List<Produto> listar(){
		List<Produto> produtos = new ArrayList<>();
		try {
			produtos = session.createCriteria(Produto.class).list();
		}catch (Exception e){
			System.out.println("erro: " + e.getMessage());
			e.printStackTrace();
		}
		return produtos;
	}
	

}
