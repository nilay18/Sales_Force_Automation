package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.profitDAO;



/**
 * Servlet implementation class profit
 */
@WebServlet("/profit")
public class profit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    profitDAO profitdao = new profitDAO();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = request.getParameter("hidden");
		if(s.equals("profit_today"))
		{
			System.out.println("hello");
			List profit_view = profitdao.today_profit();
			HttpSession session = request.getSession();
			session.setAttribute("profitview",profit_view);
			response.sendRedirect("profit.jsp");
			System.out.println("bye");
		}
		if(s.equals("profit_yesterday"))
		{
			List profit_view = profitdao.yes_profit();
			HttpSession session = request.getSession();
			session.setAttribute("profitview",profit_view);
			response.sendRedirect("profit.jsp");
		}
		
		if(s.equals("profit_week"))
		{
			List profit_view = profitdao.week_profit();
			HttpSession session = request.getSession();
			session.setAttribute("profitview",profit_view);
			response.sendRedirect("profit.jsp");
		}
		
		if(s.equals("profit_month"))
		{
			List profit_view = profitdao.month_profit();
			HttpSession session = request.getSession();
			session.setAttribute("profitview",profit_view);
			response.sendRedirect("profit.jsp");
		}
		
		if(s.equals("profit_lastmonth"))
		{
			List profit_view = profitdao.lastmon_profit();
			HttpSession session = request.getSession();
			session.setAttribute("profitview",profit_view);
			response.sendRedirect("profit.jsp");
		}
		
		if(s.equals("profit_year"))
		{
			List profit_view = profitdao.year_profit();
			HttpSession session = request.getSession();
			session.setAttribute("profitview",profit_view);
			response.sendRedirect("profit.jsp");
		}
		
		if(s.equals("profit_lastyear"))
		{
			List profit_view = profitdao.lastyear_profit();
			HttpSession session = request.getSession();
			session.setAttribute("profitview",profit_view);
			response.sendRedirect("profit.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
