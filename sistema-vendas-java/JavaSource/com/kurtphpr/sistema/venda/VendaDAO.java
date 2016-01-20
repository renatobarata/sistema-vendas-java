package com.kurtphpr.sistema.venda;

import java.util.List;

public interface VendaDAO {

	public void registraVenda (Venda venda);

	public List<Venda> getLista();

	public void excluir(Venda venda);
	
}
