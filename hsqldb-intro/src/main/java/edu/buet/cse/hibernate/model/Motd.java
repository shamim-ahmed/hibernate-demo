package edu.buet.cse.hibernate.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Motd {
  private Long id;
  private String message;
  
  protected Motd() {
  }
  
  public Motd(Long id, String message) {
	this.id = id;
	this.message = message;
  }

  public Long getId() {
	return id;
  }

  public void setId(Long id) {
	this.id = id;
  }

  public String getMessage() {
	return message;
  }

  public void setMessage(String message) {
	this.message = message;
  }
  
  @Override
  public String toString() {
	ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
	builder.append("id", id)
	       .append("message", message);
	return builder.toString();
  }
}
