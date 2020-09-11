import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;
import java.sql.*;

public class contactQuery {
	
	public void insertContact(contact cont)
	{
		
		Connection con=myConnection.getConnection();
		PreparedStatement ps;
		try {
			 ps=con.prepareStatement("INSERT INTO mycontact (fname,lname,groupc,phone,email,address,userid) VALUES (?,?,?,?,?,?,?)");
			 ps.setString(1, cont.getFname());
			 ps.setString(2, cont.getLname());
			 ps.setString(3, cont.getGroupc());
			 ps.setString(4, cont.getPhone());
			 ps.setString(5, cont.getEmail());
			 ps.setString(6, cont.getAddress());
			 ps.setInt(7, cont.getUid());
			 
			 if(ps.executeUpdate() != 0)
				{
					JOptionPane.showMessageDialog(null, "New Contact Added");
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Something wrong ");
					
				}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	
	
	public void updateContact(contact cont)
	{
		
		Connection con=myConnection.getConnection();
		PreparedStatement ps;
		String updateQuery="update mycontact SET 'fname'=?,'lname'=?,'groupc'=?,'phone'=?,'email'=?,'address'=? WHERE 'id'= ?";
		
		try {
			 ps=con.prepareStatement(updateQuery);
			 ps.setString(1, cont.getFname());
			 ps.setString(2, cont.getLname());
			 ps.setString(3, cont.getGroupc());
			 ps.setString(4, cont.getPhone());
			 ps.setString(5, cont.getEmail());
			 ps.setString(6, cont.getAddress());
			 ps.setInt(7, cont.getUid());
			 
			 if(ps.executeUpdate() != 0)
				{
					JOptionPane.showMessageDialog(null, "Contact Data edited");
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Something wrong ");
					
				}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	
	//create a list of contact
	public ArrayList<contact> contactList(int userId)
	{
		
		ArrayList<contact> clist = new ArrayList<contact>();
		
		Connection con = myConnection.getConnection();
		
		try {
		Statement st;
		ResultSet rs;
		
		st= con.createStatement();
		rs=st.executeQuery("select id,fname,lname,groupc,phone,email,address from mycontact WHERE userId= "+userId);
		
		contact ct;
		while(rs.next())
		{
			ct = new contact(rs.getInt("id"),
								rs.getString("fname"),
								rs.getString("lname"),
								rs.getString("groupc"),
								rs.getString("phone"),
								rs.getString("email"),
								rs.getString("address"),
								userId);
		
			clist.add(ct);
		}
				
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		
		
		
		return clist;
	}

}
