package com.paipeng.application;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.paipeng.jpa.service.LottoService;


public class SessionInterceptor implements Filter {
	@Inject
	private Logger log;
	
	@Inject 
	private LottoService userRepository;
	
	//@Inject 
	//private SessionData sessionData;
	private static ThreadLocal<String> sessionTokenThreadLocal = new ThreadLocal<String>();
	
	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		String methodName = context.getMethod().getName();
		log.log(Level.INFO, "SessionInterceptor intercept method name\n\n\n " + methodName + "\n-------------------------------------->");

		if ("isInitialized".equals(methodName) 
				|| "register".equals(methodName) 
				|| "checkIfActive".equals(methodName)) {
			
		} else {
			Object[] parameters = context.getParameters();
			String sessionToken = sessionTokenThreadLocal.get();
			log.log(Level.INFO, "token: " + sessionToken);
			if (sessionToken != null) {
				
				
			} else {
				log.log(Level.SEVERE, "SessionIntercept token invalid");
			}
		}		
		return context.proceed();		
	}
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		log.log(Level.INFO, "SessionInterceptor doFilter sessionToken " + req.getParameter("sessionToken"));
		log.log(Level.INFO, "SessionInterceptor doFilter token " + req.getParameter("token"));
		sessionTokenThreadLocal.set(req.getParameter("sessionToken"));
		log.log(Level.INFO, "SessionInterceptor doFilter");
		chain.doFilter(req, res);
		log.log(Level.INFO, "SessionInterceptor doFilter done");		
		sessionTokenThreadLocal.set(null);		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}



	     
	  
	
	

	
	

