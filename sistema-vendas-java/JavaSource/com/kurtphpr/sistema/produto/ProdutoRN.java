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

	public void alterar(Produto produtoSelecionado) {
		// TODO Auto-generated method stub
		
	}

	public List<Produto> listar() {
		return this.produtoDAO.listar();
	}

	public void excluir(Produto produto) {
		this.produtoDAO.excluir(produto);
		
	}
	
	

}
