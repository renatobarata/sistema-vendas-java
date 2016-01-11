package com.kurtphpr.sistema.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;

import com.kurtphpr.sistema.vendas.HibernateUtil;

public class ConexaoHibernateFilter implements Filter {

	private SessionFactory sf;
		
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
			this.sf.getCurrentSession().beginTransaction();
			filterChain.doFilter(servletRequest, servletResponse);
			this.sf.getCurrentSession().getTransaction().commit();
			this.sf.getCurrentSession().close();
		} catch (Throwable e) {
			try {
				if(this.sf.getCurrentSession().getTransaction().isActive()) {
					this.sf.getCurrentSession().getTransaction().rollback();
				}
			} catch (Throwable ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
			throw new ServletException();
		}
				
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		// TODO Auto-generated method stub
		this.sf = HibernateUtil.getSession();
		
	}

	
	
}
