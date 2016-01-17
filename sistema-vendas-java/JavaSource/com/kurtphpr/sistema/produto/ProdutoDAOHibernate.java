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

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listar() {
		Criteria lista = sessao.createCriteria(Produto.class);
		return lista.list();
	}

	@Override
	public void excluir(Produto produto) {
		this.sessao.delete(produto);
		
	}
	
}
