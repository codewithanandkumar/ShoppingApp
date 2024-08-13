package test;
import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProductServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs=req.getSession();
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Msg.jsp").forward(req,res);
		}
		else
		{
			ArrayList<ProductBean> al = new VeiwProductDAO().retrieve();
			if(al==null)System.out.println("yes anand it is null");
				hs.setAttribute("al", al);
				req.getRequestDispatcher("ViewProduct.jsp").forward(req,res);
		}
	}
}
