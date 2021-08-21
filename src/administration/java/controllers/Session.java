package administration.java.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Session implements Filter {

	private ArrayList<String> paths = new ArrayList<String>();

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String path = request.getServletPath();
		for (String string : paths) {
			if (path.startsWith(string))
				arg2.doFilter(arg0, arg1);
		}

		if (request.getSession().getAttribute("user") != null) {
			if (path.equals("/home")) {
				arg2.doFilter(request, response);
			} else if (path.equals("/") || path.equals("/login") || path.equals("/*")) {
				response.sendRedirect(request.getServletContext().getContextPath() + "/home");
			} else {
				arg2.doFilter(arg0, arg1);
			}
		} else {
			if (path.equals("/login"))
				arg2.doFilter(request, response);
			else
				response.sendRedirect(request.getServletContext().getContextPath() + "/login");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		paths.add("/bootstrap");
		paths.add("/css");
		paths.add("/dataTable");
		paths.add("/otherFiles");
		paths.add("/plugins");
		paths.add("/scss");
		paths.add("/vendor");
	}

}
