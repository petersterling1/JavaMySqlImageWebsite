package net.codejava.springmvc.connection;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import net.codejava.springmvc.model.ImageSql;
import net.codejava.springmvc.model.RegisterUser;
import net.codejava.springmvc.model.SigninUser;

public class SqlConnect {
	
	   String m_url = "jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
       //1525:gwynne.cs.ualberta.ca:1521 <CSID>@ohaton.cs.ualberta.ca
       String m_driverName = "oracle.jdbc.driver.OracleDriver";

       String m_userName = "deasis";
       String m_password = "sqlplus1234";
       String createString;
       Connection m_con;
       Statement stmt;
       Class drvClass;
   
	public SqlConnect(String string, String string2) {
	       String m_userName = string;
	       String m_password = string2;
	       try
	       {
	   
	              drvClass = Class.forName(m_driverName);
	              DriverManager.registerDriver((Driver) drvClass.newInstance());

	       } catch(Exception e){
	    	   
	              System.err.print("ClassNotFoundException: ");
	              System.err.println(e.getMessage());
	       }
		// TODO Auto-generated constructor stub
	}//Sqlconnect constructor


	
	public void InsertNewUser(RegisterUser registeruser){
		
	       try
	       {

	              m_con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1525:CRS", m_userName, m_password);
	              //stmt = m_con.createStatement();
	              java.util.Date utilDate = new java.util.Date();
	              java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	              PreparedStatement prep = m_con.prepareStatement("insert into USERS (USER_NAME, PASSWORD, DATE_REGISTERED) VALUES (?,?,?)");
	          	  prep.setString(1,registeruser.getUser_name());
	          	  prep.setString(2,registeruser.getPassword());
	          	  prep.setDate(3,sqlDate);
	              prep.executeUpdate();
	              prep.close();
	              
	             
	              
	              PreparedStatement prep2 = m_con.prepareStatement("insert into PERSONS (USER_NAME, FIRST_NAME, LAST_NAME, ADDRESS, EMAIL, PHONE) VALUES (?,?,?,?,?,?)");
	          	  prep2.setString(1,registeruser.getUser_name());
	          	  prep2.setString(2,registeruser.getFirst_name());
	          	  prep2.setString(3,registeruser.getLast_name());
	          	  prep2.setString(4,registeruser.getAddress());
	          	  prep2.setString(5,registeruser.getEmail());
	          	  prep2.setString(6,registeruser.getPhone());
	          	  
	              prep2.executeUpdate();
	              prep2.close();
	              //stmt.executeUpdate(createString);
	              //stmt.close();
	              
	              // put this into another method
	              m_con.close();
	              
	       } catch(SQLException ex) {
	    	   
	              System.err.println("SQLException: " + ex.getMessage());
	              
	       }
		
	}//statement
	
	public boolean CheckUser(SigninUser signinuser){
		
			ResultSet rs = null;
			PreparedStatement prepStmt = null;
			boolean State = false;
			
	       try
	       {

	              m_con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1525:CRS", m_userName, m_password);

	              PreparedStatement prep = m_con.prepareStatement("insert into USERS (USER_NAME, PASSWORD, DATE_REGISTERED) VALUES (?,?,?)");
	              
	              String countstatement = "select count(*) as total from USERS where USER_NAME = ? and PASSWORD = ?";
	              prepStmt = m_con.prepareStatement(countstatement);	              
	              prepStmt.setString(1, signinuser.getUser_name());
	              prepStmt.setString(2, signinuser.getPassword());
	    
	              rs = prepStmt.executeQuery();
	              
	              if (rs.next()) {
	                  int numberOfRows = rs.getInt(1);
	                  
	                  if (numberOfRows > 0){ 
	                	  State = true; }
	                  
	                  System.out.println("numberOfRows= " + numberOfRows);
	                } 
	              else {
	                	
	                  System.out.println("error: could not get the record counts");
	                }
	              
	 
	              
	              prep.close();
	              
	              m_con.close();
	              
	       } catch(SQLException ex) {
	    	   
	              System.err.println("SQLException: " + ex.getMessage());
	              
	       } finally {
	    	   
	              try{
	              rs.close();
	              prepStmt.close();
	              
	              m_con.close();}catch(SQLException e){ System.err.println("SQLException: " + e.getMessage());}
	              
	              
	       }
           System.out.println("state= " + State);

	       return State;
		
	}//statement
	
	public void InsertNewImage(ImageSql imagerow){
	    System.out.println("insertnewimage method");

		/*
		 
		CREATE TABLE images (
		   1photo_id    int,
		   2owner_name  varchar(24),
		   3permitted   int,
		   4subject     varchar(128),
		   5place       varchar(128),
		   6timing      date,
		   7description varchar(2048),
		   8thumbnail   blob,
		   9photo       blob,
		   PRIMARY KEY(photo_id),
		   FOREIGN KEY(owner_name) REFERENCES users,
		   FOREIGN KEY(permitted) REFERENCES groups
		);

		 * */
		
	       try
	       {

	              m_con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1525:CRS", m_userName, m_password);
	              //stmt = m_con.createStatement();
	             //"insert into USERS (photo_id, owner_name, permitted, subject, place, timing, description, thumbnail, photo) VALUES (?,?,?,?,?,?,?,?,?)"
	              
	              java.util.Date utilDate = new java.util.Date();
	              java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	              PreparedStatement prep = m_con.prepareStatement("insert into IMAGES (PHOTO_ID, OWNER_NAME, PERMITTED, SUBJECT, PLACE, TIMING, DESCRIPTION, THUMBNAIL, PHOTO) VALUES (?,?,?,?,?,?,?,?,?)");
	          	  prep.setInt(1,imagerow.getPhoto_id());
	          	  prep.setString(2,imagerow.getOwner_name());
	          	  prep.setInt(3,imagerow.getPermitted());
	          	  prep.setString(4,imagerow.getSubject());
	          	  prep.setString(5,imagerow.getPlace());
	          	  prep.setDate(6,imagerow.getTiming());
	          	  prep.setString(7,imagerow.getDescription());
	      	    System.out.println("insertnewimage method setBlob(8,..)");
	      	    InputStream ins = imagerow.getThumbnail().getBinaryStream();
	          	  prep.setBinaryStream(8,ins, imagerow.getThumbnail().length());
		      	    System.out.println("insertnewimage method setBlob(9,..)");
	          	  //prep.setBinaryStream(9,ins, imagerow.getThumbnail().length());
		      	  byte[] img = imagerow.getPhoto().getBytes(1, (int)imagerow.getPhoto().length());
		      	    //byte img = imagerow.getPhoto().
		      	  //byte[] scaledImg = img.getImage().getScaledInstance(29, 29, Image.SCALE_DEFAULT);
		      	    InputStream tins = new ByteArrayInputStream(img);

		      	    //InputStream thumbins = imagerow.getThumbnail().getBinaryStream();

		      	  //InputStream k = null;
		          	  prep.setBinaryStream(9,tins, img.length);

	          	  //prep.setBlob(9, (Blob) null);

	      	    System.out.println("execute prepstaement image");

	              prep.executeUpdate();
	              prep.close();
	              
	      	    System.out.println("close image prep statement");

	         
	              //stmt.executeUpdate(createString);
	              //stmt.close();
	              
	              // put this into another method
	              m_con.close();
	              
	       } catch(SQLException ex) {
	    	   
	              System.err.println("SQLException: " + ex.getMessage());
	      	    System.out.println("image exception");

	              
	       }
		    System.out.println("end of sqlconnect insert image");

		
	}//statement
}
	
	

