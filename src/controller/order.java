package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.loginVO;
import vo.new_itemVO;
import vo.orderVO;
import vo.shippingVO;
import vo.supplierVO;
import dao.new_itemDAO;
import dao.orderDAO;
import dao.shippingDAO;
import dao.supplierDAO;

/**
 * Servlet implementation class order
 */
@WebServlet("/order")
public class order extends HttpServlet {
	private static final long serialVersionUID = 1L;
	new_itemVO voitem  = new new_itemVO(); 
    new_itemDAO daoitem = new new_itemDAO();
    orderVO ordervo = new orderVO();
    orderDAO orderdao = new orderDAO();
    supplierVO vos = new supplierVO();
    shippingVO vosh = new shippingVO();
    supplierDAO suppdao = new supplierDAO();
    shippingDAO shipdao = new shippingDAO();
    
    
    
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public order() {
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
			List loadsupp = suppdao.display();
			List loadship = shipdao.display();
			HttpSession session = request.getSession();
			session.setAttribute("itemload",loaditem);
			session.setAttribute("suppload",loadsupp);
			session.setAttribute("shipload",loadship);
			response.sendRedirect("order_page.jsp");
		}
		
		if(s.equals("orderview"))
		{
			HttpSession session = request.getSession();
			String rights = (String)session.getAttribute("rights");
			
			if(rights.equals("admin"))
			{
			
			List order_view = orderdao.companydisplay("supplier");
			session.setAttribute("orderview",order_view);
			response.sendRedirect("order_list.jsp");
			}
			else if(rights.equals("supplier"))
			{
				
				Integer userid =  Integer.parseInt(session.getAttribute("userid").toString());
				List order_view = orderdao.distributordisplay(userid);
				session.setAttribute("orderview",order_view);
				response.sendRedirect("order_list.jsp");
			}
			else if(rights.equals("distributor"))
			{
				
				Integer userid =  Integer.parseInt(session.getAttribute("userid").toString());
				List order_view = orderdao.distributordisplay(userid);
				session.setAttribute("orderview",order_view);
				response.sendRedirect("order_list.jsp");
			}
		}
		
		if(s.equals("orderviewdist"))
		{
			
			HttpSession session = request.getSession();
			int userid = (int) session.getAttribute("userid");
			List list = orderdao.knowname(userid);
			Iterator iterator = list.iterator();
			Iterator itr = list.iterator();
			loginVO suppname =(loginVO)iterator.next();
			String name = suppname.getSuppliername();
			System.out.println("zzzzzzzzzzzzzzzz"+name);
			List order_view = orderdao.supplierdisplay(name);
			session.setAttribute("orderview",order_view);
			response.sendRedirect("order_list.jsp");
			
			
			
		}
		if(s.equals("order_detail"))
		{
			ordervo.setId(Integer.parseInt(request.getParameter("id")));
			List order_view = orderdao.displayorderdetail(ordervo);
			HttpSession session = request.getSession();
			session.setAttribute("orderview",order_view);
			RequestDispatcher rd=request.getRequestDispatcher("view_order.jsp");
			rd.forward(request, response);
			
		}
		
		
		if(s.equals("delete"))
		{
			ordervo.setId(Integer.parseInt(request.getParameter("id")));
			orderdao.delete(ordervo);
			response.sendRedirect("order_list.jsp");
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
			HttpSession session = request.getSession();
			int userid = (int) session.getAttribute("userid");
			String right = (String)session.getAttribute("rights");
			Date issue = null;
			Date receipt = null;
			Double itemcost= null;
			String d1 = request.getParameter("issuedate");
			String d2 = request.getParameter("receiptdate");
			String item = request.getParameter("item");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try
			{
				issue = sdf.parse(d1);
				receipt = sdf.parse(d2);
			}	
			catch(Exception e){}
			voitem.setIname(item);
			List abc = daoitem.total_cost(voitem);
			for(int i = 0; i < abc.size(); i++) {
			 itemcost = ((new_itemVO) abc.get(i)).getIcost();
			}
			ordervo.setUserid(userid);
			ordervo.setSupplier(request.getParameter("supplier"));
			ordervo.setIssue(issue);
			ordervo.setExpected(receipt);
			ordervo.setShipping(request.getParameter("shipby"));
			ordervo.setIname(item);
			ordervo.setRights(right);
			ordervo.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			ordervo.setNote(request.getParameter("t1"));
			ordervo.setTotal_cost((itemcost)*(Integer.parseInt(request.getParameter("quantity"))));
			orderdao.insert(ordervo);
			response.sendRedirect("order_list.jsp");
		}
	}

}
