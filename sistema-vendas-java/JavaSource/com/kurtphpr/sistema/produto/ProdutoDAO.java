package com.kurtphpr.sistema.produto;

import java.util.List;

public interface ProdutoDAO {

	public void salvar(Produto produto);

	public List<Produto> listar();

	public void excluir(Produto produto);
	
}
