package net.codejava.springmvc;

import java.util.Locale;
import java.util.Map;

import net.codejava.springmvc.connection.SqlConnect;
import net.codejava.springmvc.model.RegisterUser;
import net.codejava.springmvc.model.SigninUser;
import net.codejava.springmvc.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value ={"/registration","/"})
public class RegistrationController {

//http://www.codejava.net/frameworks/spring/spring-mvc-form-handling-tutorial-and-example
	
	@RequestMapping(method = RequestMethod.GET)
    public String viewRegistration( Map<String, Object> model) {
		RegisterUser newuser = new RegisterUser();
		SigninUser signinuser = new SigninUser();
        model.put("userForm", newuser);
        model.put("signinForm", signinuser);

		
    	return "landing2";
    }
	
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") RegisterUser newuser,
            Map<String, Object> model) {
         

    	SqlConnect sqlcon = new SqlConnect("deasis","sqlplus1234");
    	sqlcon.InsertNewUser(newuser);
    	
  
    	
        System.out.println("username: " + (newuser).getClass().getName());
        System.out.println("username: " + newuser.getUser_name().getClass().getName());
        System.out.println("password: " + newuser.getPassword().getClass().getName());
        System.out.println("email: " + newuser.getEmail().getClass().getName());
        System.out.println("first name: " + newuser.getFirst_name().getClass().getName());
        System.out.println("last name: " + newuser.getLast_name().getClass().getName());
        System.out.println("address: " + newuser.getAddress().getClass().getName());
        System.out.println("phone: " + newuser.getPhone().getClass().getName());

         
        return "RegistrationSuccess";
    }
    /*
    @RequestMapping(method = RequestMethod.POST)
    public String processSignin(@ModelAttribute("signinForm") SigninUser signinuser,
            Map<String, Object> model) {

    	
        System.out.println("username: " + (signinuser).getClass().getName());
        System.out.println("username: " + signinuser.getUser_name());
        System.out.println("username: " + signinuser.getPassword());


         
        return "RegistrationSuccess";
    }*/
}
