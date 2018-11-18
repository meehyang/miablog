package com.mia.miablog;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//인터셉터 만들기 (인터셉터는 자바가 아닌 스프링이 지원하는 기능 )
public class SessionHandlerInterceptor extends HandlerInterceptorAdapter{
	//상속받아서 메서드 확장 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionUserName") == null) {
			//System.out.println("세션값은 "+session.getAttribute("sessionUserName"));
			response.sendRedirect("/miablog/admin/login/login");
			return false;
		}
		return true; 
	}
}
