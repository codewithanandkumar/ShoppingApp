package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/admin")
public class adminLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		AdminBean ab = new AdminLoginDAO().login(req.getParameter("uname"), req.getParameter("pword"));
		if(ab==null)
		{
			req.setAttribute("msg", "invalid LoginProcess");
			req.getRequestDispatcher("Msg.jsp").forward(req,res);
		}
		else
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("abean", ab);
			req.getRequestDispatcher("AdminLogin.jsp").forward(req,res);
		}
	}
}
