package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;






import vo.loginVO;
import dao.loginDAO;
import dao.passwordDAO;
/**
 * Servlet implementation class editpassword
 */
@WebServlet("/editpassword")
public class editpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       passwordDAO dao = new passwordDAO();
       loginVO lv = new loginVO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editpassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher;
		String flag = request.getParameter("hidden");
		 if(flag.equals("verify"))
		 {
			 
			 String current = request.getParameter("currentpass");
			 HttpSession session=request.getSession();
			 String s1=(String)session.getAttribute("userID");
			 
			 lv.setUname(s1);
			 lv.setPass(current);
		
			 loginDAO ld=new loginDAO();
			 List list=new ArrayList();
		
			 list=ld.authenticate(lv);
		
			 
		
		
			 	if(list != null && list.size()>=1){
			 		requestDispatcher = request.getRequestDispatcher("changepass.jsp");  
			 		requestDispatcher.forward(request,response);
			 	}
			else if (list.size()==0)
			{
				
				String s = "Enter Correct Password";
				session.setAttribute("login",s);
				requestDispatcher = request.getRequestDispatcher("edit_password.jsp");  
				requestDispatcher.forward(request,response);  
				
			}
		 }
		 
		 if(flag.equals("change"))
		 {
			 String first = request.getParameter("password");
			 String second = request.getParameter("repassword");
			 HttpSession session=request.getSession();
			 if(first.equals(second))
			 {
				
				 lv.setUname((String)session.getAttribute("userID"));
				 lv.setPass(first);
				 lv.setRights((String)session.getAttribute("rights"));
				 lv.setSec_ques((String)session.getAttribute("question"));
				 lv.setSec_ans((String)session.getAttribute("answer"));
				 lv.setUserid((Integer)session.getAttribute("userid"));
				 dao.update(lv);
				 response.sendRedirect("main.jsp");
				 
			 }
			 else
			 {
				 String s = "Both the entries not same!!";
					session.setAttribute("login",s);
					requestDispatcher = request.getRequestDispatcher("changepass.jsp");  
					requestDispatcher.forward(request,response);  
			 }
		 }
		 
		 

}
}
