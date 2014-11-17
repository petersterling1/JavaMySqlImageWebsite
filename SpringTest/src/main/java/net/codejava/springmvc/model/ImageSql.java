package net.codejava.springmvc.model;

import java.sql.Blob;

public class ImageSql {

	
	/*
	 
	CREATE TABLE images (
	   photo_id    int,
	   owner_name  varchar(24),
	   permitted   int,
	   subject     varchar(128),
	   place       varchar(128),
	   timing      date,
	   description varchar(2048),
	   thumbnail   blob,
	   photo       blob,
	   PRIMARY KEY(photo_id),
	   FOREIGN KEY(owner_name) REFERENCES users,
	   FOREIGN KEY(permitted) REFERENCES groups
	);

	 * */
	//              java.util.Date utilDate = new java.util.Date();
    //java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	
	//import java.sql.Blob;
	//import javax.sql.rowset.serial.SerialBlob;

	//byte[] byteArray = .....;
	//Blob blob = new SerialBlob(byteArray);
	
	int photo_id;
	public int getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public int getPermitted() {
		return permitted;
	}
	public void setPermitted(int permitted) {
		this.permitted = permitted;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Blob getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(Blob thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public java.sql.Date getTiming() {
		return timing;
	}
	public void setTiming(java.sql.Date timing) {
		this.timing = timing;
	}
	String owner_name;
	int permitted;
	String subject;
	String place;
	java.sql.Date date;
	java.sql.Date timing;
	String description;
	Blob thumbnail;
	Blob photo;
	
	
	
	
	
}
