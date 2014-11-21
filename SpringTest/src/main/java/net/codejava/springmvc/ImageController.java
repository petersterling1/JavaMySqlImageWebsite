package net.codejava.springmvc;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import net.codejava.springmvc.connection.SqlConnect;
import net.codejava.springmvc.model.ImageSql;
import net.codejava.springmvc.model.SigninUser;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

//http://stackoverflow.com/questions/11294168/update-sql-image-in-java
//http://stackoverflow.com/questions/14085511/uploading-images-to-server-in-spring-mvc-and-storing-reference-in-mysql-database
//http://www.coderanch.com/t/305939/JDBC/databases/Insert-image-MySQL-database











import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.springmvc.FileValidator;

//http://examples.javacodegeeks.com/enterprise-java/spring/mvc/spring-mvc-file-upload-example/

@Controller
@SessionAttributes({"home","searchqueryobject"})
//@RequestMapping("/file.htm")
public class ImageController {
	
	  @RequestMapping(value ="/signin", method = RequestMethod.POST)
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
	/*
	@Autowired
	FileValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getForm(Model model) {
		File fileModel = new File();
		model.addAttribute("file", fileModel);
		return "file";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String fileUploaded(Model model, @Validated File file,
			BindingResult result) {

		String returnVal = "successFile";
		if (result.hasErrors()) {
			returnVal = "file";
		} else {			
			MultipartFile multipartFile = file.getFile();		}
		return returnVal;
	}*/
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFormUpload( 
	    @RequestParam("file") MultipartFile file) throws IOException{
	if (!file.isEmpty()) {
		
//      java.util.Date utilDate = new java.util.Date();
//java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

//import java.sql.Blob;
//import javax.sql.rowset.serial.SerialBlob;

//byte[] byteArray = .....;
//Blob blob = new SerialBlob(byteArray);
		
		//http://www.mkyong.com/java/how-to-convert-byte-to-bufferedimage-in-java/
		 //convert byte to image
	 byte[] imageInByte;
	 
	 //grab the username in the cookie
	 //find sql commands to find all necessary information
		
	 BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
	 ByteArrayOutputStream out = new ByteArrayOutputStream();
	 ImageIO.write(src, "jpg", out);
	 out.flush();
	 imageInByte = out.toByteArray();
	 out.close();
	 
	 Blob blob = null;
	try {
		blob = new javax.sql.rowset.serial.SerialBlob(imageInByte);
        System.out.println("username: " + (blob).getClass().getName());

        System.out.println("username: " + (blob).getClass().getName());
        System.out.println("username: " + (blob).getClass().getName());
        System.out.println("username: " + (blob).getClass().getName());
        System.out.println("username: " + (blob).getClass().getName());



		
	} catch (SerialException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 //InputStream in = new ByteArrayInputStream(imageInByte);
	 
	 //PreparedSt
	 ImageSql imagerow = new ImageSql();

 	 //image row reference users and groups
	 
	 int photo_id = 1111;
	 String owner_name = "zzzz";
	 int permitted = 1;
	 String subject = null;
	 String place = null;
	 Date timing= null;
	 String description = null;
	 Blob photo = blob;
	 Blob thumbnail= blob;
	 
 	 imagerow.setPhoto_id(photo_id);
 	 imagerow.setOwner_name(owner_name);//
 	 imagerow.setPermitted(permitted);//
 	 imagerow.setSubject(subject);
 	 imagerow.setPlace(place);
 	 imagerow.setTiming(timing);
 	 imagerow.setDescription(description);
 	 imagerow.setPhoto(photo);
 	 imagerow.setThumbnail(thumbnail);
	 
 	 SqlConnect sqlcon = new SqlConnect("deasis","sqlplus1234");
	 sqlcon.InsertNewImage(imagerow); //imagerow is object ImageSql;
	 
	 
	 //"insert into image()
	 //ps.


	 
     //System.out.println("imagetype= " + src.getClass().getName());
	 //connect to sql
	 //ImageSql imagerow = null;;
	 //src --> imagesql
	 //cokie grab stuff from database --> imagerow
 	 //sqlcon.InsertNewImage(imagerow);

	 
	 //File destination = new File("File directory with file name"); // something like C:/Users/tom/Documents/nameBasedOnSomeId.png
	 //ImageIO.write(src, "png", destination);
	 //Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID.
	 }
    System.out.println("image controller return");

	return "test";
	}
	
	//http://stackoverflow.com/questions/23918082/spring-mvc-multiple-files-upload
	@RequestMapping(value="/new", method= RequestMethod.POST)
	public String uploadFiles(MultipartRequest multipartrequest, HttpServletRequest request){

	    List<MultipartFile> images = multipartrequest.getFiles("files");
	//public String uploadFiles(@RequestParam("files") MultipartFile filed,HttpServletRequest request, List<MultipartFile> files){
		 
	//try{
  	    System.out.println("multiple images controller");
  	    images.size();
  	    System.out.println( images.size());

  	    return "test";
  	    //
		}
//
	@RequestMapping(value="/searchquery/{id}/content", method= RequestMethod.GET)
	public ResponseEntity<byte[]> downloadReportTemplateContent(
	        @PathVariable("id") byte[] pic){

	//public String uploadFiles(@RequestParam("files") MultipartFile filed,HttpServletRequest request, List<MultipartFile> files){
		 
	//try{
		
		
		ModelAndView modelandview = new ModelAndView("home1");
  	    SqlConnect sqlcon = new SqlConnect("deasis","sqlplus1234");

  	    String queryphoto1 = "select photo from images";
  	    byte[] picture = sqlcon.grabpicture(queryphoto1);
  	    
  	    HttpHeaders response = new HttpHeaders();

	        //response.setContentType("image/jpeg");
	        response.setContentLength(picture.length);
	        //response.setStatus(HttpServletResponse.SC_OK)


  	    //return "home1";
  	    //
	        return new ResponseEntity<byte[]>(picture,
                    response, HttpStatus.OK);		}
	
	@ResponseBody
	@RequestMapping(value="/searchquery", method= RequestMethod.POST)
	public String searchQuery(@RequestParam("searchfrom") String searchfrom,@RequestParam("searchto") String searchto, @RequestParam("keywords") String keywords, @RequestParam("sort") String sort, Map<String, Object> model, HttpServletRequest request, HttpServletResponse response){

	//public String uploadFiles(@RequestParam("files") MultipartFile filed,HttpServletRequest request, List<MultipartFile> files){
		 
	//try{
		
		//ModelAndView modelandview = new ModelAndView("home1");

  	    System.out.println("search query controller");
  	    System.out.println(searchfrom.getClass().getName());
  	    System.out.println(searchfrom);

  	    System.out.println(searchto.getClass().getName());
  	    System.out.println(searchto);

  	    System.out.println(keywords.getClass().getName());
  	    System.out.println(keywords);

  	    System.out.println(sort.getClass().getName());
  	    System.out.println(sort);

  	    /*
  	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  	  	try {
			java.util.Date datefrom = dateFormat.parse(searchfrom);
	        java.sql.Date sqlDatefrom = new java.sql.Date(datefrom.getTime());
	        
			java.util.Date dateto = dateFormat.parse(searchto);
	        java.sql.Date sqlDateto = new java.sql.Date(dateto.getTime());
	        

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	    
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
  	    System.out.println(sqlDate.getClass().getName());
  	    System.out.println(sqlDate);
  	    System.out.println(utilDate);
  	    
  	    SqlConnect sqlcon = new SqlConnect("deasis","sqlplus1234");

  	    String queryphoto1 = "select photo from images where permitted = 1";
  	    
  	    String[] keywordsarray = keywords.split("\\s+");
  	    System.out.println(keywordsarray);

  	    for ( int i = 0 ; i < keywordsarray.length ; i++ ){
  	    	String queryphoto2;
  	    	if (i == 0){
  	    	    System.out.println(keywordsarray[i]);

  	    		String a = " and subject like" + "\'%" + keywordsarray[i] + "%\'";
  	    		
  	    		queryphoto1 = queryphoto1.concat(a);
  	    		
  	    	    System.out.println(queryphoto1); 	    		
  	    	}
  	    	else
  	    	{
  	    		String c = "or subject like" + "\'%" + keywordsarray[i] + "%\'";
  	    		
  	    	    System.out.println(keywordsarray[i]);
  	    	    
  	    	  queryphoto1 = queryphoto1.concat(c);
  	    	    
  	    	    System.out.println(queryphoto1);
  	    	}	
  	    }
  	    
  	    queryphoto1 = "select photo from images";
  	
  	    
  	    System.out.println("before picture");
  	    
  	    System.out.println("queryphoto1");


  	    byte[] picture = sqlcon.grabpicture(queryphoto1);

  	    System.out.println("after picture");


  	    System.out.println(picture.getClass().getName());
  	    System.out.println(picture);
  	    System.out.println(picture.length);
  	    //ServletOutputStream out = null;

  	    try {
  	        //response.setHeader("Content-Type", "image/png");
  	        response.setContentType("image/jpeg");
  	        response.setContentLength(picture.length);
  	        response.setStatus(HttpServletResponse.SC_OK);
  	        
  	        InputStream ispictures = new ByteArrayInputStream(picture);

  	        BufferedInputStream in =
  	            new BufferedInputStream(ispictures);
  	        
  	        ByteArrayOutputStream byteStream =
  	            new ByteArrayOutputStream(picture.length);
  	        int imageByte;


  	        while((imageByte = in.read()) != -1) {
  	        byteStream.write(imageByte);
  	      }
  	        
  	        in.close();

  	        String persistenceFlag =
  	    	      request.getParameter("usePersistence");
  	    	      boolean usePersistence =
  	    	        ((persistenceFlag == null) ||
  	    	         (!persistenceFlag.equals("no")));
  	    	      
  	      
  	    	if (usePersistence) {
  	    	        response.setContentLength(byteStream.size());
  	    	      } 
  	    	    
  	        //out = response.getOutputStream();
  	        //out.write(picture);
  	      byteStream.writeTo(response.getOutputStream());

    	  	System.out.println("before first return");

  	      response.sendRedirect("home1.jsp");
  	  	System.out.println("aftre first return");


  	        
  	  	    System.out.println("after out write picture");


  		    //out.flush();
  		    //out.close();

  	  	    System.out.println("after out  close");

  	        //response.getOutputStream().write(picture);

  	        //Blob blob = new javax.sql.rowset.serial.SerialBlob(picture); 
  	         * 
  	         */

  	        /*
  	        FileInputStream input = new ByteArrayInputSTream(decodedHeaderFileZip);

  	        
  	        ServletOutputStream out = response.getOutputStream();
  	        IOUtils.copy(picture, out);
  	        IOUtils.closeQuietly(fin);*/

			//response.getOutputStream().write(picture);
			//response.getOutputStream().flush();
			//response.getOutputStream().close();
		/*	
		} 
  	    catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		

		     
		}*/
  	    
	  	System.out.println("before return last line");

  	    return "home1";
  	    //
	  	//return modelandview;
		}
	
	}



