package com.kurtphpr.sistema.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.kurtphpr.sistema.util.HibernateUtil;

public abstract class TestHeranca {

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
	
}
