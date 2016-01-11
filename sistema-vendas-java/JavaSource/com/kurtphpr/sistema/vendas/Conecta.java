package com.kurtphpr.sistema.vendas;

import org.hibernate.Session;

public class Conecta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session sessao = null;
		try {
			sessao = new HibernateUtil().getSession().openSession();
			System.out.println("Conexão iniciada.");
		} finally {
			// TODO: handle finally clause
			sessao.close();
			System.out.println("Conexão encerrada.");
		}

	}

}
