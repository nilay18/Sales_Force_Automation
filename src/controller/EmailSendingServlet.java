package controller;

import java.io.IOException;

import dao.emailDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Iterator;
import java.util.List;

import vo.loginVO;



/**
 * Servlet implementation class EmailSendingServlet
 */
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
    private String port;
    private String user;
    private String pass;
    emailDAO emaildao = new emailDAO();
    
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailSendingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = "localhost";
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
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
		 String recipient = request.getParameter("email");
	     String subject = " PASSWORD RECOVER ";
	     List list = emaildao.authenticate(recipient);
	     
	    Iterator iterator = list.iterator();
		Iterator itr = list.iterator();
		loginVO loginvo =(loginVO)iterator.next();
	     
	     String content = " YOUR USERNAME IS:"+loginvo.getUname()+"\n YOUR PASSWORD IS:"+loginvo.getPass() ;
	     String resultMessage = "";
	     
	     
	     try {
	            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
	                    content);
	            resultMessage = "The e-mail was sent successfully";
	            System.out.println(resultMessage);
	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            resultMessage = "There were an error: " + ex.getMessage();
	            System.out.println(resultMessage);
	            
	        } finally {
	            
	        	getServletContext().getRequestDispatcher("/login_page.jsp").forward(
	                    request, response); 
	        }
	}

}
