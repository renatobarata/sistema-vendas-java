package com.kurtphpr.sistema.cliente;

import java.util.List;

import com.kurtphpr.sistema.util.DAOFactory;

public class ClienteRN {

	private ClienteDAO clienteDAO;
	
	public ClienteRN() {
		this.clienteDAO = DAOFactory.criaClienteDAO();
	}
	
	public void salvar(Cliente cliente) {
		this.clienteDAO.salvar(cliente);
	}

	public List<Cliente> listar() {
		return this.clienteDAO.listar();
		
	}

	public void excluir(Cliente cliente) {
		this.clienteDAO.excluir(cliente);
		
	}

	public Cliente pesquisar(String cliente) {
		return this.clienteDAO.pesquisar(cliente);
	}

	
	public void alterar(Cliente cliente) {
		this.clienteDAO.alterar(cliente);
		
	}

	public Cliente pesquisarPorCodigo(Integer codigo) {
		return this.clienteDAO.pesquisarPorCodigo(codigo);
	}
	
}
