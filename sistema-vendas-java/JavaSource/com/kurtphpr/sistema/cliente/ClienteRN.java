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
	
}
