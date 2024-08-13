package test;
import java.sql.*;

import com.anand.DAO.DBConnection;
public class AdminLoginDAO {
	public AdminBean ab=null;
	
	public AdminBean login(String uname, String pword)
	{
		try
		{
		Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select *from Admin63 where uname=? and pword=?");
				ps.setString(1, uname);
				ps.setString(2, pword);
			ResultSet status = ps.executeQuery();
			while(status.next())
			{
				ab=new AdminBean();
				ab.setUname(status.getString(1));
				ab.setPword(status.getString(2));
				ab.setFname(status.getString(3));
				ab.setLname(status.getString(4));
				ab.setAddr(status.getString(5));
				ab.setMid(status.getString(6));
				ab.setPhno(Long.parseLong(status.getString(7)));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ab;
	}
}
