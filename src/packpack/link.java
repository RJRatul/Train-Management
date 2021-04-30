package packpack;

import java.sql.*;

import javax.swing.*;

public class link {
	Connection con = null;
	public static Connection dataConnecter()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\Java Project\\RailwayManagementSystem.sqlite");
			
			return connection;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
		
	}

}

