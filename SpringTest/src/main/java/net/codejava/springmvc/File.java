package net.codejava.springmvc;

import org.springframework.web.multipart.MultipartFile;

public class File {

	MultipartFile file;
	
	public File(){}
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}	
	
}
