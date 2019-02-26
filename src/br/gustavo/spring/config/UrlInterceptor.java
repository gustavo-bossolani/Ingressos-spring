package br.gustavo.spring.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class UrlInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String requestUri = request.getRequestURI();
		if (requestUri.endsWith("login") || requestUri.endsWith("logar") || requestUri.endsWith("registrar")
				|| requestUri.endsWith("cliente") || requestUri.endsWith("cliente/add")) {
			return true;
		}
		if (request.getSession().getAttribute("clienteLogado") != null) {
			return true;
		}
		response.sendRedirect("login");
		return false;
	}
}
