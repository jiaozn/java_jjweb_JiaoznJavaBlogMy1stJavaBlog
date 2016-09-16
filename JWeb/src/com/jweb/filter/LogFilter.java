package com.jweb.filter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.jweb.log.LogWriter;


public class LogFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
//	private FilterConfig config; 
//    // 实现初始化方法 
//    public void init(FilterConfig config) { 
//        this.config = config; 
//    } 
//    // 实现销毁方法 
//    public void destroy() { 
//        this.config = null; 
//    } 
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		 // 获取ServletContext 对象，用于记录日志 
//        ServletContext context = this.config.getServletContext(); 
        // 将请求转换成HttpServletRequest 请求 
        HttpServletRequest hrequest = (HttpServletRequest) request; 
        // 记录日志 
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);
        LogWriter.method1("\\log.txt", time+":来自- "+hrequest.getRemoteAddr()+" 访问- "+hrequest.getRequestURI());
//        context.log("Filter已经截获到用户的请求的地址: " + hrequest.getServletPath()); 
        try { 
            // Filter 只是链式处理，请求依然转发到目的地址。 
            chain.doFilter(request, response); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
