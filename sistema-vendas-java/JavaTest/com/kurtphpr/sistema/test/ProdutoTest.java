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

import com.kurtphpr.sistema.produto.Produto;
import com.kurtphpr.sistema.produto.ProdutoRN;
import com.kurtphpr.sistema.util.HibernateUtil;

public class ProdutoTest {

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
				System.out.println("Erro no fechamento da sessão: " + e2.getMessage());
			}
			
		}
		
	}
	
	
	@Before
	public void setup() {
		
		Produto p2 = new Produto("lote", "Caderno", new Date(), 50, 7.0f);
		Produto p3 = new Produto("lote2", "Regua", new Date(), 30, 2.5f);
		Produto p4 = new Produto("fardo", "Papel", new Date(), 300, 1.5f);
		Produto p5 = new Produto("edicao", "Livro", new Date(), 10, 30.0f);
		Produto p6 = new Produto("caixa", "Caneta", new Date(), 90, 1.5f);
		
		ProdutoRN produtoRN = new ProdutoRN();
		produtoRN.salvar(p2);
		produtoRN.salvar(p3);
		produtoRN.salvar(p4);
		produtoRN.salvar(p5);
		produtoRN.salvar(p6);
		
	}
		
	@After
	public void limpaBanco() {
		
		ProdutoRN produtoRN = new ProdutoRN();
		List<Produto> lista = produtoRN.listar();
		
		for (Produto produto : lista) {
			produtoRN.excluir(produto);
		}
		
	}
		
	@Test
	public void salvarTest() {
		
		Produto p1 = new Produto();
		p1.setUnidade("lote");
		p1.setDescricao("Caderno");
		p1.setDataCadastro(new Date());
		p1.setEstoque(50);
		p1.setValor(7.0f);
		
		ProdutoRN produtoRN = new ProdutoRN();
		produtoRN.salvar(p1);
		assertEquals(true, true);
		
	}
	
	@Test
	public void listarTest() {
		
		ProdutoRN produtoRN = new ProdutoRN();
		List<Produto> lista = produtoRN.listar();
		assertEquals(5, lista.size());
		
	}
	
	
	
	@Test
	public void excluirTest() {
		
		ProdutoRN produtoRN = new ProdutoRN();
		List<Produto> lista = produtoRN.listar();
		Produto produtoExcluido = lista.get(0);
		produtoRN.excluir(produtoExcluido);
		lista = produtoRN.listar();
		assertEquals(4, lista.size());
		
	}
	
	
	@Test
	public void pesquisarTest() {
		
		ProdutoRN produtoRN = new ProdutoRN();
		Produto produtoPesquisado = produtoRN.pesquisar("Re");
		
		assertEquals(30.0f, produtoPesquisado.getEstoque(), 0.0001);
		
	}
	
	@Test
	public void alterarTest() {
		
		ProdutoRN produtoRN = new ProdutoRN();
		Produto produtoPesquisado = produtoRN.pesquisar("Re");
		assertEquals(30.0f, produtoPesquisado.getEstoque(), 0.0001);
		
		produtoPesquisado.setEstoque(40);
		produtoRN.alterar(produtoPesquisado);
		Produto produtoAlterado = produtoRN.pesquisar("Re");
		assertEquals(40.0f, produtoAlterado.getEstoque(), 0.0001);
		
	}
	
	
}
