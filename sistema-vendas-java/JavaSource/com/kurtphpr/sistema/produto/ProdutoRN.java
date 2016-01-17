package com.kurtphpr.sistema.produto;

import java.util.List;

import com.kurtphpr.sistema.util.DAOFactory;

public class ProdutoRN {

	private ProdutoDAO produtoDAO;
	
	public ProdutoRN() {
		this.produtoDAO = DAOFactory.criaProdutoDAO();
	}

	public void salvar(Produto produto) {
		this.produtoDAO.salvar(produto);
	}

	public void alterar(Produto produto) {
		this.produtoDAO.alterar(produto);
		
	}

	public List<Produto> listar() {
		return this.produtoDAO.listar();
	}

	public void excluir(Produto produto) {
		this.produtoDAO.excluir(produto);
		
	}

	public Produto pesquisar(String produto) {
		return this.produtoDAO.pesquisar(produto);
	}
	
	

}
