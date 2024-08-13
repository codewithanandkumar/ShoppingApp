package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class AdminLogOutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		HttpSession hs=req.getSession();
			hs.removeAttribute("abean");
			hs.removeAttribute("al");
			req.getRequestDispatcher("home.html").forward(req, res);
		
	}
}
