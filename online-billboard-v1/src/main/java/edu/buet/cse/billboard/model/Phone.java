package edu.buet.cse.billboard.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Phone {
  private Long id;
  private User user;
  private String number;
  private String comment;

  public Long getId() {
	return id;
  }

  public void setId(Long id) {
	this.id = id;
  }

  public User getUser() {
	return user;
  }

  public void setUser(User user) {
	this.user = user;
  }

  public String getNumber() {
	return number;
  }

  public void setNumber(String number) {
	this.number = number;
  }

  public String getComment() {
	return comment;
  }

  public void setComment(String comment) {
	this.comment = comment;
  }
  
  @Override
  public String toString() {
	ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
	builder.append("id", id)
	       .append("username", user.getName())
	       .append("number", number)
	       .append("comment", comment);
	
	return builder.toString();
  }
}
