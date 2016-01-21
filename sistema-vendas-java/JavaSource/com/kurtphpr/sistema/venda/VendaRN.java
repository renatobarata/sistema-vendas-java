package com.kurtphpr.sistema.venda;

import java.util.List;

import com.kurtphpr.sistema.produto.Produto;
import com.kurtphpr.sistema.util.DAOFactory;

public class VendaRN {

	private VendaDAO vendaDAO;
	
	public VendaRN() {
		this.vendaDAO = DAOFactory.criaVendaDAO();
	}
	
	public void registraVenda(Venda venda1) {
		this.vendaDAO.registraVenda(venda1);
	}

	public List<Venda> listar() {
		return this.vendaDAO.getLista();
	}
	
	public void excluir(Venda venda) {
		this.vendaDAO.excluir(venda);
		
	}

	public boolean existeEstoque(Produto produto) {
		return this.vendaDAO.existeEstoqueProduto(produto);
	}

	public void reduzEstoqueProduto(Produto produto) {
		this.vendaDAO.reduzEstoqueProduto(produto);
		
	}
	
}
