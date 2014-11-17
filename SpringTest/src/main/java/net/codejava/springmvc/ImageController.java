package net.codejava.springmvc;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;

import net.codejava.springmvc.connection.SqlConnect;
import net.codejava.springmvc.model.ImageSql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//http://stackoverflow.com/questions/11294168/update-sql-image-in-java
//http://stackoverflow.com/questions/14085511/uploading-images-to-server-in-spring-mvc-and-storing-reference-in-mysql-database
//http://www.coderanch.com/t/305939/JDBC/databases/Insert-image-MySQL-database











import org.springframework.web.multipart.MultipartRequest;

import net.codejava.springmvc.FileValidator;

//http://examples.javacodegeeks.com/enterprise-java/spring/mvc/spring-mvc-file-upload-example/

@Controller
//@RequestMapping("/file.htm")
public class ImageController {
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
	}



