package com.javatpoint;
import javax.servlet.*;
import java.sql.*;

public class MyListener implements ServletContextListener{

	
	public void contextInitialized(ServletContextEvent arg0) {
		int status=0;
		Connection con=null;
		
	try{
		con=GetCon.getCon();
		
		/*Checking if the table pharmacyadmin exists or not */
		DatabaseMetaData dbm = con.getMetaData();
	    ResultSet rs = dbm.getTables(null, null, "pharmacyadmin", null);
		if(!rs.next()) {
			PreparedStatement ps2=con.prepareStatement("CREATE TABLE pharmacyadmin (username VARCHAR(45) NULL,password VARCHAR(45) NULL)");
			ps2.execute();
			ps2 = con.prepareStatement("Insert into PHARMACYADMIN values(?,?)");
		    ps2.setString(1,"admin");
			ps2.setString(2,"admin");	
			ps2.executeUpdate();
		}
		rs.close();
		
		/*Checking if the table distributeradmin exists or not */
		   rs = dbm.getTables(null, null, "distributeradmin", null);
		   if(!rs.next())
		   {
			   PreparedStatement ps3=con.prepareStatement("CREATE TABLE distributeradmin (username VARCHAR(45) NULL,password VARCHAR(45) NULL)");
				ps3.execute();
				
				ps3 = con.prepareStatement("Insert into DISTRIBUTERADMIN values(?,?)");
				ps3.setString(1,"dis");
				ps3.setString(2,"dis");
				ps3.executeUpdate();   
		   }
          rs.close();
          
		 /*Checking if the table newcust4 exists or not */
          rs = dbm.getTables(null, null, "newcust4", null);  
			if(!rs.next())
			{
				PreparedStatement ps4=con.prepareStatement("CREATE TABLE newcust4 (id INT NOT NULL,username VARCHAR(45) NULL,password VARCHAR(45) NULL,repassword VARCHAR(45) NULL,disname VARCHAR(45) NULL,adderess VARCHAR(45) NULL, cityname VARCHAR(45) NULL,statename VARCHAR(45) NULL,country VARCHAR(45) NULL,region VARCHAR(45) NULL,phone INT NULL,email VARCHAR(45) NULL,PRIMARY KEY (id))");
				ps4.execute();
			}
			rs.close();
			
			 
		  /*Checking if the table neworder4 exists or not */
			rs = dbm.getTables(null, null, "neworder4", null);
			if(!rs.next())
			{
				PreparedStatement ps5=con.prepareStatement("CREATE TABLE neworder4 (id INT NOT NULL,prodcode VARCHAR(45) NULL,productname VARCHAR(45) NULL,tax INT NULL,minq INT NULL,orderq INT NULL,discount INT NULL,netcost INT NULL, amount INT NULL,paymode VARCHAR(45) NULL,PRIMARY KEY (id))");
				ps5.execute();		
			}
			

		
		}
		
		
	    catch(Exception e){e.printStackTrace();}
	    }
	    public void contextDestroyed(ServletContextEvent arg0) {
	    	
		System.out.println("project undeployed");
		
	}
}
