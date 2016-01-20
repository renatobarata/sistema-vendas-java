package com.kurtphpr.sistema.venda;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.kurtphpr.sistema.cliente.Cliente;
import com.kurtphpr.sistema.produto.Produto;
import com.kurtphpr.sistema.produto.ProdutoRN;

@ManagedBean(name = "vendaBean")
@ViewScoped
public class VendaBean {

	private Cliente clienteSelecionado;
	private Produto produtoSelecionado = new Produto();
	private List<Produto> carrinhoCompras = new ArrayList<Produto>();
	private float valorTotal;
	
	public void getBuscaProduto() {
		ProdutoRN produtoRN = new ProdutoRN();
		Produto produtoPesquisado = new Produto();
		if(this.produtoSelecionado.getDescricao() != null || this.produtoSelecionado.getDescricao().equals("")) {
			produtoPesquisado = produtoRN.pesquisar(this.produtoSelecionado.getDescricao());
			if(produtoPesquisado != null) {
				this.carrinhoCompras.add(produtoPesquisado);
				calculaTotal();
			}
		}
	}
	
	private void calculaTotal() {
		if(this.carrinhoCompras.isEmpty()) {
			for (Produto produto : this.carrinhoCompras) {
				valorTotal =+ produto.getValor();
			}
		}
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}
	
	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}
	
	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
	public List<Produto> getCarrinhoCompras() {
		return carrinhoCompras;
	}
	
	public void setCarrinhoCompras(List<Produto> carrinhoCompras) {
		this.carrinhoCompras = carrinhoCompras;
	}
	
	public float getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
		
	
}
