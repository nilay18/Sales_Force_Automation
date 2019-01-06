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

import vo.categoryVO;
import vo.new_itemVO;
import vo.supplierVO;
import dao.categoryDAO;
import dao.new_itemDAO;
import dao.supplierDAO;

/**
 * Servlet implementation class item
 */
@WebServlet("/item")
public class item extends HttpServlet {
	private static final long serialVersionUID = 1L;
    new_itemVO vo  = new new_itemVO(); 
    new_itemDAO dao = new new_itemDAO();
    categoryDAO catdao = new categoryDAO();
    categoryVO catvo = new categoryVO();
    supplierVO suppvo = new supplierVO();
    supplierDAO suppdao = new supplierDAO();
   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public item() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		 String flag = request.getParameter("hidden");
	
		if(flag.equals("item_view"))
		{
			List item_view = dao.display();
			HttpSession session = request.getSession();
			session.setAttribute("itemview",item_view);
			response.sendRedirect("items_list.jsp");
		}
		
		if(flag.equals("itemdetail_view"))
		{
			vo.setId(Integer.parseInt(request.getParameter("id")));
			List item_view = dao.displayitemdetail(vo);
			HttpSession session = request.getSession();
			session.setAttribute("itemview_detail",item_view);
			RequestDispatcher rd=request.getRequestDispatcher("view_item.jsp");
			rd.forward(request, response);
			
		}
		
		if(flag.equals("load"))
		{
			
			List loadcat = catdao.display();
			List loadsupp = suppdao.display();
			HttpSession session = request.getSession();
			session.setAttribute("catload",loadcat);
			session.setAttribute("suppload", loadsupp);
			response.sendRedirect("new_item.jsp");
		}
		
		if(flag.equals("delete"))
		{
			vo.setId(Integer.parseInt(request.getParameter("id")));
			dao.delete(vo);
			response.sendRedirect("items_list.jsp");
		}
		
		if(flag.equals("edit"))
		{
			vo.setId(Integer.parseInt(request.getParameter("id")));
			List edititem = dao.displayitemdetail(vo);
			HttpSession session = request.getSession();
			session.setAttribute("edit_item",edititem);
			List loadcat = catdao.display();
			
			session.setAttribute("catload",loadcat);
			response.sendRedirect("edititem.jsp");
			
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String flag = request.getParameter("hidden");
		 if(flag.equals("item_insert"))
		{
			
			vo.setIname(request.getParameter("item"));
			vo.setIcategory(request.getParameter("cat"));
			vo.setIcost(Double.parseDouble(request.getParameter("uncost")));
			vo.setIdesc(request.getParameter("t1"));
			vo.setImrp(Double.parseDouble(request.getParameter("unprice")));
			vo.setInote(request.getParameter("t2"));
			vo.setIsupplier(request.getParameter("supplier"));
			vo.setIwebsite(request.getParameter("itweb"));
			dao.insert(vo);
			response.sendRedirect("items_list.jsp");
			
			
			
		}
		 
		 if(flag.equals("update"))
			{
				vo.setIname(request.getParameter("item"));
				vo.setIcategory(request.getParameter("cat"));
				vo.setIcost(Double.parseDouble(request.getParameter("uncost")));
				vo.setIdesc(request.getParameter("t1"));
				vo.setImrp(Double.parseDouble(request.getParameter("unprice")));
				vo.setInote(request.getParameter("t2"));
				vo.setIsupplier(request.getParameter("supplier"));
				vo.setIwebsite(request.getParameter("itweb"));
				dao.update(vo);
				response.sendRedirect("items_list.jsp");
				
			}
		
		
		
	}

}
