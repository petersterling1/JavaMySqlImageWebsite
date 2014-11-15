package net.codejava.springmvc;

import java.util.Map;

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

	SqlConnect sqlcon = new SqlConnect("deasis","sqlplus1234");

	/*
	 * select count from USERS where userid = username , password = password
	 */
    
    @RequestMapping(method = RequestMethod.POST)
    public String processSignin(@ModelAttribute("signinForm") SigninUser signinuser,
            Map<String, Object> model) {

    	
    	SqlConnect sqlcon = new SqlConnect("deasis","sqlplus1234");

    	
        System.out.println("username: " + (signinuser).getClass().getName());
        System.out.println("username: " + signinuser.getUser_name());
        System.out.println("username: " + signinuser.getPassword());

        boolean authenticated = sqlcon.CheckUser(signinuser);

        System.out.println("authenticated= " + authenticated);

         
        return "RegistrationSuccess";
    }
}