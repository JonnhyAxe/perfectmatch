package com.goyello.esa.model;

import java.io.Serializable;
import java.util.Objects;


public class Message implements Serializable {
	
	
	private Long id;
	
	private String to;
	
	private String body;
	
	public Message() {

	}
	
	public Message(String to, String body) {
		super();
		this.to = to;
		this.body = body;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public int hashCode() {
		return java.util.Objects.hash(getId(), getBody());
	}
	 
	 @Override
	 public boolean equals(Object obj){
	    if (obj == this) {
	      return true;
	    } 
	    if (obj instanceof Message) {
	    	Message other = (Message) obj; 
	      return Objects.equals(id, other.id) && Objects.equals(body, other.body);
	    } 
	    return false;
	}
	
}
