package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.new_itemVO;
import vo.sellVO;
import dao.customerDAO;
import dao.new_itemDAO;
import dao.sellDAO;

/**
 * Servlet implementation class dashboard
 */
@WebServlet("/dashboard")
public class dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	customerDAO cusdao = new customerDAO();
	new_itemDAO daoitem = new new_itemDAO();
	new_itemVO voitem = new new_itemVO();
	sellVO vosell = new sellVO();
	sellDAO daosell = new sellDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = request.getParameter("hidden");
		if(s.equals("dashboard_view"))
		{
			List dashboard_view = daosell.display();
			HttpSession session = request.getSession();
			session.setAttribute("dashboardview",dashboard_view);
			response.sendRedirect("main.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
