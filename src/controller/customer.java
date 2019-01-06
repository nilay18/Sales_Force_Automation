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

import dao.customerDAO;
import vo.customerVO;

/**
 * Servlet implementation class customer
 */
@WebServlet("/customer")
public class customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	customerDAO customDAO = new customerDAO();
	customerVO customVO = new customerVO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("hidden");
		if(flag.equals("custom_view"))
		{
			List customer_view = customDAO.display();
			HttpSession session = request.getSession();
			session.setAttribute("customerview",customer_view);
			response.sendRedirect("customer_list.jsp");
			
			
		}
		if(flag.equals("customdetail"))
		{
			customVO.setId(Integer.parseInt(request.getParameter("id")));
			List customer_view = customDAO.displaycustomerdetail(customVO);
			HttpSession session = request.getSession();
			session.setAttribute("customerview_detail",customer_view);
			response.sendRedirect("viewcustomer.jsp");
		}
		
		if(flag.equals("delete"))
		{
			customVO.setId(Integer.parseInt(request.getParameter("id")));
			customDAO.delete(customVO);
			response.sendRedirect("customer_list.jsp");
		}
		
		if(flag.equals("edit"))
		{
			customVO.setId(Integer.parseInt(request.getParameter("id")));
			List editcustomer = customDAO.displaycustomerdetail(customVO);
			HttpSession session = request.getSession();
			session.setAttribute("edit_customer",editcustomer);
			response.sendRedirect("editcustomer.jsp");
			
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("hidden");
		
		if(flag.equals("insert"))
		{
			customVO.setBaddress(request.getParameter("t1"));
			customVO.setContact(request.getParameter("cpname"));
			customVO.setCustomer(request.getParameter("customer"));
			customVO.setEmail(request.getParameter("email"));
			customVO.setFax(request.getParameter("fax"));
			customVO.setNote(request.getParameter("t3"));
			customVO.setPhone(request.getParameter("phone1"));
			customVO.setPhonealt(request.getParameter("phone2"));
			customVO.setSaddress(request.getParameter("t2"));
			customDAO.insert(customVO);
			response.sendRedirect("customer_list.jsp");
			
			
		}
		
		if(flag.equals("update"))
		{
			customVO.setBaddress(request.getParameter("t1"));
			customVO.setContact(request.getParameter("cpname"));
			customVO.setCustomer(request.getParameter("customer"));
			customVO.setEmail(request.getParameter("email"));
			customVO.setFax(request.getParameter("fax"));
			customVO.setNote(request.getParameter("t3"));
			customVO.setPhone(request.getParameter("phone1"));
			customVO.setPhonealt(request.getParameter("phone2"));
			customVO.setSaddress(request.getParameter("t2"));
			customDAO.update(customVO);
			response.sendRedirect("customer_list.jsp");
			
			
			
		}
	}

}
