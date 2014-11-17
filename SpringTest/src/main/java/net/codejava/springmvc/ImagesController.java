package net.codejava.springmvc;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//@Controller
public class ImagesController {
	
	
	//@RequestMapping(value="/new", method= RequestMethod.POST)
	public String uploadFiles(@RequestParam("files") MultipartFile filed,HttpServletRequest request, List<MultipartFile> files){
	 
	//try{
  	    System.out.println("multiple images controller");
  	    files.size();
  	    //

		/*
	   for(MultipartFile file: files){
	     if(file != null && file.getSize() > 0 && file.getSize() < 1048576){ // side in bytes -> 1 mb
	     byte[] bytes = file.getBytes();
	     String fileContentType = file.getContentType();
	     System.out.println("******* FILE CONTENT TYPE: " + fileContentType);
	     if(fileContentType.contains("image")){
	        BufferedImage bufferedImage =ImageIO.read(file.getInputStream());
	        File localFile = new File(request.getServletContext().getRealPath("images")+"/pictures/"+file.getOriginalFilename());
	        boolean dir = localFile.mkdirs();
	        file.transferTo(localFile);
	      }
	    }
	  }*/
	//}catch(IOException iox){
	//    System.out.println("***** FILE UPLOAD ERROR ******: " + iox.getMessage());
//	}
	return "test";
	
	

}
	
}
