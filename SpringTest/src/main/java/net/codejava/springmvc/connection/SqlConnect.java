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

import oracle.sql.BLOB;
import net.codejava.springmvc.model.ImageSql;
import net.codejava.springmvc.model.RegisterUser;
import net.codejava.springmvc.model.SigninUser;

public class SqlConnect {
	
	   String m_urlschool = "jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
	   String m_url = "jdbc:oracle:thin:@localhost:1525:CRS";

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

	              m_con = DriverManager.getConnection(m_url, m_userName, m_password);
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

	              m_con = DriverManager.getConnection(m_url, m_userName, m_password);

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
	              else 
	              	{	
	                  System.out.println("error: could not get the record counts");
	                }
	             
	              prep.close();	         
	              //m_con.close();
	              
	       } catch(SQLException ex) {
	    	   
	              System.err.println("SQLException: " + ex.getMessage());
	              
	       } finally {
	    	   
	              try
	              {
	            	  rs.close();
	            	  prepStmt.close();	
	            	  m_con.close();
	            	  
	              }catch(SQLException e){
	            	  System.err.println("SQLException: " + e.getMessage());
	              }            
	       }//finally
           System.out.println("state= " + State);
	       return State;	
	}//statement
	
	public void InsertNewImage(ImageSql imagerow){
	    System.out.println("insertnewimage method");
		
	       try
	       {

	              m_con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1525:CRS", m_userName, m_password);
          
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

	              m_con.close();
	              
	       } catch(SQLException ex) {
	    	   
	              System.err.println("SQLException: " + ex.getMessage());
	      	    System.out.println("image exception");

	              
	       }
		    System.out.println("end of sqlconnect insert image");
	
	}//statement
	

	public byte[] grabpicture(String string){
		
			ResultSet rs = null;
			PreparedStatement prepStmt = null;
			boolean State = false;
			Blob blob = null;
      	    System.out.println("grab picture method");
      	    byte[] allBytesInBlob = null;

	       try
	       {

	              m_con = DriverManager.getConnection(m_url, m_userName, m_password);

	              m_con.createStatement();
	              PreparedStatement stmt = m_con.prepareStatement(string);
	              ResultSet resultSet = stmt.executeQuery();

	              //http://www.jguru.com/faq/view.jsp?EID=1325
	              while (resultSet.next()){
	            	  
	              	  blob = resultSet.getBlob(1);
	                  allBytesInBlob = blob.getBytes(1, (int) blob.length());

	                  //int numberOfRows = rs.getInt(1);
	                  //String name = resultSet.getString(1);
	                  //String description = resultSet.getString(2);
	            	    System.out.println(" if of while in grab picture method");

	                  
	            	    	
	            	    
	            	 /*    
		              if (resultSet.next()) {
		          	
		                } 
		              else 
		              	{	
		                  System.out.println("error: could not get the record counts");
		            	    System.out.println(" else of while of grabpicture method ");

		                }*/
	            	  
	              }
	              resultSet.close();
	              m_con.close();
	              
	       } catch(SQLException ex) {
	    	   
	              System.err.println("SQLException: " + ex.getMessage());
	              
	       } finally {
	    	   
	              try
	              {
	            	    System.out.println("try of finally grabpicture method");

	            	  //rs.close();
	            	  //prepStmt.close();	              
	            	  m_con.close();
	              }catch(SQLException e){ 
	            	  System.err.println("SQLException: " + e.getMessage());
	            	    System.out.println("catch of finally grabpicture method ");

	              }            
	       }//finally
     	    System.out.println("one line before returning from grab picture method  ");

     	    

      	    System.out.println(allBytesInBlob.getClass().getName());
      	    System.out.println(allBytesInBlob);
      	    System.out.println(allBytesInBlob.length);
      	    
	       return allBytesInBlob;	
	}//method
	public boolean makegroup(String username, String groupname){
		
		ResultSet rs = null;
		PreparedStatement prepStmt = null;
		boolean State = false;
	
       try
       {
           System.out.println("begin connection into groups lists");

    	   
              m_con = DriverManager.getConnection(m_url, m_userName, m_password);	              
              String countstatement = "select count(*) as total from GROUPS where USER_NAME = ? and GROUP_NAME = ?";
              //String countstatement = "select count(*) as total from GROUPS where GROUP_NAME = ?";

              prepStmt = m_con.prepareStatement(countstatement);	              
              prepStmt.setString(1, username);
              prepStmt.setString(2, groupname);
    
              System.out.println("before execution check number groups lists");

              rs = prepStmt.executeQuery();
              
              if (rs.next()) {
                  int numberOfRows = rs.getInt(1);
                  
                  if (numberOfRows == 0){ 
                	  State = true; }
                  
                  System.out.println("numberOfRows= " + numberOfRows);
                } 
              else 
              	{	
                  System.out.println("error: could not get the record counts");
                  State = false;
	              prepStmt.close();	 
                  m_con.close();
                  return State;
                }
              
              
              System.out.println("begin insert into groups lists");

              
              java.util.Date utilDate = new java.util.Date();
              java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
              
              PreparedStatement prepstmt2 = m_con.prepareStatement("insert into groups(group_id, user_name, group_name,date_created)  select count(*), ?, ?, ? from groups");
              prepstmt2.setString(1,username);
              prepstmt2.setString(2,groupname);
              prepstmt2.setDate(3,sqlDate);
              prepstmt2.executeUpdate();
              
              System.out.println("success insert into groups");
              State = true;
              
              System.out.println("closing insert into groups");
          
              prepStmt.close();	 
              prepstmt2.close();	 
              m_con.close();
              
              
       } catch(SQLException ex) {
    	   
              System.err.println("SQLException: " + ex.getMessage());
              return false;   
       }
       return State;
		
	}//statement
	
	public boolean joingroup(String registeruser, String groupname){
		
		
			ResultSet rs = null;
			PreparedStatement prepStmt = null;
			boolean State = false;
			int groupid = 0;
		
	       try
	       {
	    	   
	              m_con = DriverManager.getConnection(m_url, m_userName, m_password);	              
	              String countstatement = "select group_id from GROUPS where GROUP_NAME = ?";
	              prepStmt = m_con.prepareStatement(countstatement);	              
	              //prepStmt.setString(1, registeruser);
	              prepStmt.setString(1, groupname);
	    
	              rs = prepStmt.executeQuery();
	              
	              if (rs.next()) {
	                  groupid = rs.getInt(1);
	                  State = true;
	         
	                  System.out.println("groupid= " + groupid);
	                } 
	              else 
	              	{	
	                  System.out.println("error: could not get the record counts");
	                  State = false;
		              prepStmt.close();	 
	                  m_con.close();
	                  return State;
	                }
	              
	              
                  System.out.println("begin insert into groups");

	              
	              java.util.Date utilDate = new java.util.Date();
	              java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                  
	              PreparedStatement prepstmt2 = m_con.prepareStatement("insert into group_lists (group_id, friend_id, date_added, notice) VALUES (?,?,?,?)");

	              prepstmt2.setInt(1,groupid);
	              prepstmt2.setString(2,registeruser);
	              prepstmt2.setDate(3,sqlDate);
	              prepstmt2.setString(4,"");
	              
	              prepstmt2.executeUpdate();
	              
                  System.out.println("success insert into groups");
                  State = true;
                  
                  System.out.println("closing insert into groups");
              
	              prepStmt.close();	 
	              prepstmt2.close();	 
                  m_con.close();
                  
                  
                  
                  
	       } catch(SQLException ex) {
	    	   
	              System.err.println("SQLException: " + ex.getMessage());
	              return false;
	              
	       }
		
	       return State;
	}//statement
	
	
}
	
	

