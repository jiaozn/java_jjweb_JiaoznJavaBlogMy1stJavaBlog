package com.jjweb.util;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jjweb.model.CounterSession;

import com.jjweb.model.CounterSessionDAO;
//@Repository
public class SessionCounterListener implements HttpSessionListener{
	private static final Logger log = LoggerFactory
			.getLogger("SessionCounterLogger");
	//@Resource
	private CounterSessionDAO counterSessionDAO;//=new CounterSessionDAO();
	private CounterSession counterSession;
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		 HttpSession session=event.getSession(); 
		counterSessionDAO=(CounterSessionDAO) this.getObjectFromApplication(session.getServletContext(), "CounterSessionDAO");  
		System.out.println("3---sessionCreated=====>getSession.getAttribute");
		String vIp=(String) event.getSession().getServletContext().getAttribute("vIp");//getAttribute("vIp");
		System.out.println("4---finish"+vIp);
		counterSession=new CounterSession();
		counterSession.setIp(vIp);
		counterSession.setTime(new Timestamp(new Date().getTime()));
		counterSessionDAO.save(counterSession);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public CounterSessionDAO getCounterSessionDAO() {
		return counterSessionDAO;
	}

	public void setCounterSessionDAO(CounterSessionDAO counterSessionDAO) {
		this.counterSessionDAO = counterSessionDAO;
	}

	public CounterSession getCounterSession() {
		return counterSession;
	}

	public void setCounterSession(CounterSession counterSession) {
		this.counterSession = counterSession;
	}
	
	 private Object getObjectFromApplication(ServletContext servletContext,String beanName){  
	        //通过WebApplicationContextUtils 得到Spring容器的实例。  
	        ApplicationContext application=WebApplicationContextUtils.getWebApplicationContext(servletContext);  
	        //返回Bean的实例。  
	        return application.getBean(beanName);  
	    }
}
