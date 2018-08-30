package com.nagarro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "images_table")
public class ImageWrapper implements Serializable{
	 private static final long serialVersionUID = 1L;
	 
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "ID", unique = true, nullable = false)
	private int id;
	
	 @Column(name = "image", unique = false, nullable = false, length = 100000)
	private byte[] data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
}
