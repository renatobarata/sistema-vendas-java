package com.kurtphpr.sistema.produto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class ProdutoDAOHibernate implements ProdutoDAO {

	private Session sessao;
	
	@Override
	public void salvar(Produto produto) {
		this.sessao.save(produto);
	}

	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@Override
	public List<Produto> listar() {
		Criteria lista = sessao.createCriteria(Produto.class);
		return lista.list();
	}
	
}
