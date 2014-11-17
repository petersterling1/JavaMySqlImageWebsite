package net.codejava.springmvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.codejava.springmvc.connection.SqlConnect;
import net.codejava.springmvc.model.RegisterUser;
import net.codejava.springmvc.model.SigninUser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value ="/signin")
public class LoginController {
	//
	SqlConnect sqlcon = new SqlConnect("deasis","sqlplus1234");

	/*
	 * select count from USERS where userid = username , password = password
	 */
    
    @RequestMapping(method = RequestMethod.POST)
    public String processSignin(@ModelAttribute("signinForm") SigninUser signinuser,
            Map<String, Object> model, HttpServletResponse response, HttpServletRequest request) throws IOException {

    	
    	SqlConnect sqlcon = new SqlConnect("deasis","sqlplus1234");

    	
        System.out.println("username: " + (signinuser).getClass().getName());
        System.out.println("username: " + signinuser.getUser_name());
        System.out.println("username: " + signinuser.getPassword());

        boolean authenticated = sqlcon.CheckUser(signinuser);
        boolean itsgood = true;
        System.out.println("authenticated= " + authenticated);

        
        //could try Boolean too....
        if(itsgood == (authenticated)){
        	
            Cookie loginCookie = new Cookie("user",signinuser.getUser_name());
            //setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30*60);
            response.addCookie(loginCookie);
            
            //response.sendRedirect("SigninSuccess.jsp");
            //find jsp
            return "home1";

            
        }//if
        else{
        	
        	/*
        	 RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        	 */
            System.out.println("hahaha= " );
            System.out.println("hahaha= " );

            System.out.println("hahaha= " );

            System.out.println("hahaha= " );
            //find jsp
            return "home";


            
        }// else


         
    }
}