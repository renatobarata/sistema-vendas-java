package com.kurtphpr.sistema.venda;

import java.util.List;

import com.kurtphpr.sistema.produto.Produto;

public interface VendaDAO {

	public void registraVenda (Venda venda);

	public List<Venda> getLista();

	public void excluir(Venda venda);

	public boolean existeEstoqueProduto(Produto produto);

	public void reduzEstoqueProduto(Produto produto);
	
}
