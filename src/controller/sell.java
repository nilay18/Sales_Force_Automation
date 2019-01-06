package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class sell
 */
@WebServlet("/sell")
public class sell extends HttpServlet {
	private static final long serialVersionUID = 1L;
	customerDAO cusdao = new customerDAO();
	new_itemDAO daoitem = new new_itemDAO();
	new_itemVO voitem = new new_itemVO();
	sellVO vosell = new sellVO();
	sellDAO daosell = new sellDAO();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sell() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = request.getParameter("hidden");
		if(s.equals("load"))
		{
			
			List loaditem = daoitem.display();
			List loadcus = cusdao.display();
			HttpSession session = request.getSession();
			session.setAttribute("itemload",loaditem);
			session.setAttribute("cusload",loadcus);
			response.sendRedirect("sell.jsp");
		}
		
		if(s.equals("sales_view"))
		{
			List sales_view = daosell.display();
			HttpSession session = request.getSession();
			session.setAttribute("salesview",sales_view);
			response.sendRedirect("sales_list.jsp");
		}
		
		if(s.equals("salesview_detail"))
		{
			vosell.setId(Integer.parseInt(request.getParameter("id")));
			List sales_view = daosell.displaysalesdetail(vosell);
			HttpSession session = request.getSession();
			session.setAttribute("salesview",sales_view);
			RequestDispatcher rd=request.getRequestDispatcher("view_sales.jsp");
			rd.forward(request, response);
			
		}
		
		if(s.equals("delete"))
		{
			vosell.setId(Integer.parseInt(request.getParameter("id")));
			daosell.delete(vosell);
			response.sendRedirect("sales_list.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = request.getParameter("hidden");

		if(s.equals("insert"))
		{
			Date sell_date = null;
			Double price = null;
			Double cost=null;
			String d1 = request.getParameter("selldate");
			String item = request.getParameter("item");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try
			{
				sell_date = sdf.parse(d1);
				
			}	
			catch(Exception e){}
			voitem.setIname(item);
			List abc = daoitem.total_price(voitem);
			for(int i = 0; i < abc.size(); i++) {
			 price = ((new_itemVO) abc.get(i)).getImrp();
			 cost = ((new_itemVO) abc.get(i)).getIcost();	 
			}
			vosell.setIname(item);
			vosell.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			vosell.setCustomer(request.getParameter("customer"));
			vosell.setSdate(sell_date);
			vosell.setNote(request.getParameter("t1"));
			vosell.setTotal_price((Integer.parseInt(request.getParameter("quantity")))*price);
			vosell.setProfit((Integer.parseInt(request.getParameter("quantity")))*(price-cost));
			daosell.insert(vosell);
			response.sendRedirect("sales_list.jsp");
			
			
		}
		
	}

}
