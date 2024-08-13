package test;

import java.util.*;

import com.anand.DAO.DBConnection;

import java.sql.*;

public class VeiwProductDAO {
	ArrayList<ProductBean> pb=new ArrayList<ProductBean>();
	public ArrayList<ProductBean> retrieve()
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select *from Product63");
			ResultSet status = ps.executeQuery();
			while(status.next())
			{
				ProductBean p1=new ProductBean();
				p1.setCode(status.getString(1));
				p1.setName(status.getString(2));
				p1.setPrice(Double.parseDouble(status.getString(3)));
				p1.setQty(Integer.parseInt(status.getString(4)));
				pb.add(p1);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pb;
	}
	
}
