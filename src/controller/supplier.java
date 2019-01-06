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

import vo.supplierVO;
import dao.supplierDAO;
import vo.loginVO;
import dao.loginDAO;

/**
 * 
 * Servlet implementation class supplier
 */
@WebServlet("/supplier")
public class supplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	supplierVO suppvo = new supplierVO();
	supplierDAO suppdao = new supplierDAO();
	loginVO loginvo = new loginVO();
	loginDAO logindao = new loginDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String flag = request.getParameter("hidden");

			if(flag.equals("supplier_view"))
			{
				List supplier_view = suppdao.display();
				HttpSession session = request.getSession();
				session.setAttribute("supplierview",supplier_view);
				response.sendRedirect("supplier_list.jsp");
			}
			
			if(flag.equals("supplierdetail_view"))
			{
				suppvo.setIds(Integer.parseInt(request.getParameter("id")));
				List supplier_view = suppdao.displaysupplierdetail(suppvo);
				HttpSession session = request.getSession();
				session.setAttribute("supplierview_detail",supplier_view);
				RequestDispatcher rd=request.getRequestDispatcher("view_supplier.jsp");
				rd.forward(request, response);
				
			}
			
			if(flag.equals("delete"))
			{
				suppvo.setIds(Integer.parseInt(request.getParameter("id")));
				suppdao.delete(suppvo);
				response.sendRedirect("supplier_list.jsp");
			}
			if(flag.equals("edit"))
			{
				suppvo.setIds(Integer.parseInt(request.getParameter("id")));
				List editsupplier = suppdao.displaysupplierdetail(suppvo);
				HttpSession session = request.getSession();
				session.setAttribute("edit_supplier",editsupplier);
				
				response.sendRedirect("editsupplier.jsp");
				
				
				
			}
			
			
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		 String flag = request.getParameter("hidden");
		 
		 
		 
		 
		 if(flag.equals("suppinsert"))
		 {
			    HttpSession session = request.getSession();
			    int userid = (int) session.getAttribute("userid");
			 	loginvo.setRights("supplier");
			 	loginvo.setUname(request.getParameter("username"));
			 	loginvo.setPass(request.getParameter("password"));
			 	loginvo.setSuppliername(request.getParameter("supplier"));
			 	logindao.insert(loginvo);
			 	suppvo.setAddress(request.getParameter("t1"));
				suppvo.setContact(request.getParameter("cpname"));
				suppvo.setEmail(request.getParameter("email"));
				suppvo.setFax(request.getParameter("fax"));
				
				
				suppvo.setPhone(request.getParameter("phone1"));
				suppvo.setPhonealt(request.getParameter("phone2"));
				suppvo.setSupplier(request.getParameter("supplier"));
				
				suppdao.insert(suppvo);
				response.sendRedirect("supplier_list.jsp");
		
		
		 }
		 
		 
		 if(flag.equals("update"))
			{
			 	suppvo.setAddress(request.getParameter("t1"));
				suppvo.setContact(request.getParameter("cpname"));
				suppvo.setEmail(request.getParameter("email"));
				suppvo.setFax(request.getParameter("fax"));
				
				suppvo.setPhone(request.getParameter("phone1"));
				suppvo.setPhonealt(request.getParameter("phone2"));
				suppvo.setSupplier(request.getParameter("supplier"));
				
				suppdao.update(suppvo);
				response.sendRedirect("supplier_list.jsp");
				
			}
		
	}
}

