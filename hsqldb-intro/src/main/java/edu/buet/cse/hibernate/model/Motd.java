package edu.buet.cse.hibernate.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Motd {
  private long id;
  private String message;
  
  protected Motd() {
  }
  
  public Motd(long id, String message) {
	this.id = id;
	this.message = message;
  }

  public long getId() {
	return id;
  }

  public void setId(long messageId) {
	this.id = messageId;
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
