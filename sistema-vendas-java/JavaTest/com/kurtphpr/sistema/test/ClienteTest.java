package com.kurtphpr.sistema.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kurtphpr.sistema.cliente.Cliente;
import com.kurtphpr.sistema.cliente.ClienteRN;
import com.kurtphpr.sistema.util.HibernateUtil;

public class ClienteTest {

	private static Session sessao;
	private static Transaction transacao;
	
	@BeforeClass
	public static void abreConexao() {
		sessao = HibernateUtil.getSession().getCurrentSession();
		transacao = sessao.beginTransaction();
	}
	
	@AfterClass
	public static void fechaConexao() {
			
		try {
			transacao.commit();
		} catch (Throwable e) {
			System.out.println("Erro no commit: " + e.getMessage());
		} finally {
			try {
				if(sessao.isOpen()) {
					sessao.close();
				}
			} catch (Exception e2) {
				System.out.println("Erro no fechamento da sess�o: " + e2.getMessage());
			}
			
		}
		
	}
	
	@Before
	public void setup() {
		
		Cliente c2 = new Cliente("21244634700", "teste2@mail.com", "Rua 2", "Cliente 2", new Date(), 2000);
		Cliente c3 = new Cliente("21244634700", "teste3@mail.com", "Rua 3", "Cliente 3", new Date(), 3000);
		Cliente c4 = new Cliente("21244634700", "teste4@mail.com", "Rua 4", "Cliente 4", new Date(), 4000);
		
		ClienteRN clienteRN = new ClienteRN();
		clienteRN.salvar(c2);
		clienteRN.salvar(c3);
		clienteRN.salvar(c4);
		
	}
	
	@After
	public void limpaBanco() {
		
		ClienteRN clienteRN = new ClienteRN();
		List<Cliente> lista = clienteRN.listar();
		
		for (Cliente cliente : lista) {
			clienteRN.excluir(cliente);
		}
		
	}
	
	@Test
	public void salvarTest() {
		
		Cliente c1 = new Cliente();
		c1.setNome("Ronaldo");
		c1.setEndereco("Rua Teste");
		c1.setRenda(5000f);
		c1.setCpf("00457869925");
		
		ClienteRN clienteRN = new ClienteRN();
		clienteRN.salvar(c1);
		
		assertEquals(true, true);
		
	}
	
	@Test
	public void listarTest() {
		
		ClienteRN clienteRN = new ClienteRN();
		List<Cliente> lista = clienteRN.listar();
		assertEquals(3, lista.size());
		
	}
	
	@Test
	public void excluirTest() {
		
		ClienteRN clienteRN = new ClienteRN();
		List<Cliente> lista = clienteRN.listar();
		Cliente clienteExcluido = lista.get(0);
		clienteRN.excluir(clienteExcluido);
		lista = clienteRN.listar();
		assertEquals(2, lista.size());
		
	}
	
	@Test
	public void pesquisaTest() {
		
		ClienteRN clienteRN = new ClienteRN();
		Cliente clientePesquisado = clienteRN.pesquisar("te 2");
		
		assertEquals("teste2@mail.com", clientePesquisado.getEmail());
		
	}
	
	@Test
	public void alterarTest() {
		
		ClienteRN clienteRN = new ClienteRN();
		Cliente clientePesquisado = clienteRN.pesquisar("te 2");
		assertEquals("teste2@mail.com", clientePesquisado.getEmail());
		
		clientePesquisado.setEndereco("Novo Endere�o");
		clienteRN.alterar(clientePesquisado);
		Cliente clienteAlterado = clienteRN.pesquisar("te 2");
		assertEquals("Novo Endere�o", clienteAlterado.getEndereco());
		
	}
	
}
