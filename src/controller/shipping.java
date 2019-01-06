package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.shippingVO;
import dao.shippingDAO;

/**
 * Servlet implementation class shipping
 */
@WebServlet("/shipping")
public class shipping extends HttpServlet {
	private static final long serialVersionUID = 1L;
	shippingVO suppvo =new shippingVO();
	shippingDAO suppdao =new shippingDAO();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shipping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("hidden");
		
		if(flag.equals("carrier_view"))
		{
			List carrier_view = suppdao.display();
			HttpSession session = request.getSession();
			session.setAttribute("carrierview",carrier_view);
			response.sendRedirect("shipping_carrier.jsp");
		}
		
		if(flag.equals("delete"))
		{
			suppvo.setId(Integer.parseInt(request.getParameter("id")));;
			suppdao.delete(suppvo);
			response.sendRedirect("shipping_carrier.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("hidden");
		if(flag.equals("carrierinsert"))
		{
			suppvo.setShipping(request.getParameter("shipcompany"));
			suppdao.insert(suppvo);
			response.sendRedirect("shipping_carrier.jsp");
			
		}
	}

}
