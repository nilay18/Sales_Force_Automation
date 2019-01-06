package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.customerVO;
import vo.new_itemVO;
import vo.orderVO;
import vo.sellVO;
import vo.supplierVO;
import dao.customerDAO;
import dao.new_itemDAO;
import dao.orderDAO;
import dao.reportDAO;
import dao.sellDAO;
import dao.supplierDAO;

/**
 * Servlet implementation class report
 */
@WebServlet("/report")
public class report extends HttpServlet {
	private static final long serialVersionUID = 1L;
       customerDAO custdao = new customerDAO();
       customerVO custvo = new customerVO();
       reportDAO repdao = new reportDAO();
       sellVO sellvo = new sellVO();
       sellDAO selldao = new sellDAO();
       new_itemVO itemvo = new new_itemVO();
       new_itemDAO itemdao = new new_itemDAO();
       orderVO ordervo = new orderVO();
       orderDAO orderdao = new orderDAO();
       supplierVO suppliervo = new supplierVO();
       supplierDAO supplierdao = new supplierDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public report() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("hidden");
		if(flag.equals("custload"))
		{
			
			List loadcust = custdao.display();
			HttpSession session = request.getSession();
			session.setAttribute("custload",loadcust);
			
			response.sendRedirect("sales_customer.jsp");
		}
		
		
		
		if(flag.equals("customer_sales_display"))
		{
			
			
			String customer = request.getParameter("customer");
			sellvo.setCustomer(customer);
			List custsales = repdao.display_csales(sellvo);
			HttpSession session = request.getSession();
			session.setAttribute("custsales",custsales);
			response.sendRedirect("sales_customer.jsp");
			
		}
		
		
		
		if(flag.equals("detail_sales"))
		{
				sellvo.setId(Integer.parseInt(request.getParameter("id")));
				List sales_view = selldao.displaysalesdetail(sellvo);
				HttpSession session = request.getSession();
				session.setAttribute("salesview",sales_view);
				RequestDispatcher rd=request.getRequestDispatcher("view_sales.jsp");
				rd.forward(request, response);
				
			
		}
		
		if(flag.equals("detail_order"))
		{
				ordervo.setId(Integer.parseInt(request.getParameter("id")));
				List order_view = orderdao.displayorderdetail(ordervo);
				HttpSession session = request.getSession();
				session.setAttribute("orderview",order_view);
				RequestDispatcher rd=request.getRequestDispatcher("view_order.jsp");
				rd.forward(request, response);
				
			
		}
		
		if(flag.equals("suppload"))
		{
			
			List loadsupp = supplierdao.display();
			HttpSession session = request.getSession();
			session.setAttribute("suppload",loadsupp);
			
			response.sendRedirect("order_supplier.jsp");
		}
		
		if(flag.equals("supplier_order_display"))
		{
			
			
			String supplier = request.getParameter("supplier");
			ordervo.setSupplier(supplier);
			List supporder = repdao.display_sorder(ordervo);
			HttpSession session = request.getSession();
			session.setAttribute("supporder",supporder);
			response.sendRedirect("order_supplier.jsp");
			
		}
		
		if(flag.equals("itemloadsales"))
		{
			
			List loaditem = itemdao.display();
			HttpSession session = request.getSession();
			session.setAttribute("itemload",loaditem);
			
			response.sendRedirect("item_sales.jsp");
		}
		
		if(flag.equals("item_sales_display"))
		{
			
			
			String item = request.getParameter("item");
			sellvo.setIname(item);
			List itemsales = repdao.display_isales(sellvo);
			HttpSession session = request.getSession();
			session.setAttribute("itemsales",itemsales);
			response.sendRedirect("item_sales.jsp");
			
		}
		
		if(flag.equals("itemloadorder"))
		{
			
			List loaditem = itemdao.display();
			HttpSession session = request.getSession();
			session.setAttribute("itemload",loaditem);
			
			response.sendRedirect("item_orders.jsp");
		}
		
		if(flag.equals("item_order_display"))
		{
			
			
			String item = request.getParameter("item");
			ordervo.setIname(item);
			List itemorder = repdao.display_iorder(ordervo);
			HttpSession session = request.getSession();
			session.setAttribute("itemorder",itemorder);
			response.sendRedirect("item_orders.jsp");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
