package com.gustavo.cursovraptor.model.dao;


import java.util.List;

import com.gustavo.cursovraptor.model.entities.Produto;
import com.gustavo.cursovraptor.utils.CriadoDeSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class ProdutoDao {

	private final Session session;
	
	public ProdutoDao() {
		this.session = CriadoDeSession.getSession();
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
		return session.createCriteria(Produto.class).list();
	}
	

}
