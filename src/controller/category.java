package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.categoryDAO;
import vo.categoryVO;

/**
 * Servlet implementation class category
 */
@WebServlet("/category")
public class category extends HttpServlet {
	private static final long serialVersionUID = 1L;
    categoryVO catvo = new categoryVO();
    categoryDAO catdao = new categoryDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public category() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag = request.getParameter("hidden");
		
		if(flag.equals("cat_view"))
		{
			List cat_view = catdao.display();
			HttpSession session = request.getSession();
			session.setAttribute("catview",cat_view);
			response.sendRedirect("cat_list.jsp");
		}
		if(flag.equals("delete"))
		{
			catvo.setId(Integer.parseInt(request.getParameter("id")));
			catdao.delete(catvo);
			response.sendRedirect("cat_list.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag = request.getParameter("hidden");
		if(flag.equals("catinsert"))
		{
			catvo.setCatname(request.getParameter("cat"));
			catdao.insert(catvo);
			response.sendRedirect("cat_list.jsp");
			
		}
	}

}
