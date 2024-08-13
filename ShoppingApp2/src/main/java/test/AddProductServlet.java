package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
		ProductBean pb=new ProductBean();
		pb.setCode(req.getParameter("pcode"));
		pb.setName(req.getParameter("pname"));
		pb.setPrice(Double.parseDouble(req.getParameter("pprice")));
		pb.setQty(Integer.parseInt(req.getParameter("pqty")));
		int status = new AddProductDAO().addProduct(pb);
			if(status>0)
			{
				req.setAttribute("msg", "Product Added Succussfully!!");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
			}
		}
		
	}
}
