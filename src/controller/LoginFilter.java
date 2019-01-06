package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;




import dao.loginDAO;
import vo.loginVO;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain 

chain) throws IOException, ServletException {
		
		HttpSession session =((HttpServletRequest) request).getSession();
		RequestDispatcher requestDispatcher;
		String uri = ((HttpServletRequest)request).getRequestURI();
		
		if(uri.contains("login_page")||uri.contains("/css") || uri.contains("/js")|| 

uri.contains("/avatars")||uri.contains("/registration")|| uri.contains("/font")|| uri.contains("/forgot") || uri.contains("/Email"))
		{
			
			chain.doFilter(request,response);
			
		}
		else if(uri.contains("doLogin") )
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			loginVO lv=new loginVO();
			lv.setUname(username);
			lv.setPass(password);
			
			loginDAO ld=new loginDAO();
			List list=new ArrayList();
			
			list=ld.authenticate(lv);
			
			
			
			
				if(list != null && list.size()>=1){
				
				Iterator iterator = list.iterator();
				Iterator itr = list.iterator();
				loginVO user =(loginVO)iterator.next();
				String y = user.getUname();
				String z = user.getRights();
				String a = user.getSec_ques();
				String b = user.getSec_ans();
				
				session.setAttribute("userID",y);
				session.setAttribute("rights", z);
				session.setAttribute("question", a);
				session.setAttribute("answer", b);
				
				int userid = user.getUserid();
				
				session.setAttribute("userid", userid);
				
				requestDispatcher = request.getRequestDispatcher("main.jsp");  
				requestDispatcher.forward(request,response);  
				
				
		}
				else if (list.size()==0)
				{
					
					String s = " WRONG USERNAME OR PASSWORD";
					session.setAttribute("login",s);
					requestDispatcher = request.getRequestDispatcher("login_page.jsp");  
					requestDispatcher.forward(request,response);  
					
				}
		}
				
		else if(session.getAttribute("userID") != null)
		{
			chain.doFilter(request, response);
			
		}
		else
		{
			requestDispatcher = request.getRequestDispatcher("login_page.jsp"); 
			requestDispatcher.forward(request,response); 

		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
