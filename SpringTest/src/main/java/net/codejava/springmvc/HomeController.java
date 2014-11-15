package net.codejava.springmvc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home1";
	}
	
	@RequestMapping(value= "/test",method=RequestMethod.GET)
	public String test(Model model){
	    String greetings = "Greetings, Spring MVC!";
	    model.addAttribute("message", greetings);
	 
	    return "test";
	}
	
	@RequestMapping(value= "/landing1",method=RequestMethod.GET)
	public String landing(Model model){
	    String greetings = "Greetings, Spring MVC!";
	    model.addAttribute("message", greetings);
	    
	  /*
	 //===
	       String m_url = "jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
	       //1525:gwynne.cs.ualberta.ca:1521 <CSID>@ohaton.cs.ualberta.ca

	       String m_driverName = "oracle.jdbc.driver.OracleDriver";
	       String m_userName = "";

	       String m_password = "";
	       Connection m_con;
	       String createString;
	       createString = "create table TOFFEES " +

	              "(T_NAME VARCHAR(32), " +

	              "SUP_ID INTEGER, " +

	              "PRICE FLOAT, " +

	              "SALES INTEGER, " +

	              "TOTAL INTEGER)";
	       Statement stmt;
	       try
	       {
	              Class drvClass = Class.forName(m_driverName);
	              DriverManager.registerDriver((Driver)
	              drvClass.newInstance());
	       } catch(Exception e)

	       {
	              System.err.print("ClassNotFoundException: ");
	              System.err.println(e.getMessage());
	       }
	       try
	       {
	              m_con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1525:CRS", m_userName,
	              m_password);
	              stmt = m_con.createStatement();
	              stmt.executeUpdate(createString);
	              stmt.close();
	              m_con.close();
	       } catch(SQLException ex) {
	              System.err.println("SQLException: " +
	              ex.getMessage());
	       }
	       */
	    
	 //===
	    
	    
	    return "landing";
	}
	
}
