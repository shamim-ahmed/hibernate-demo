package edu.buet.cse.hibernate.ch06.v3.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PersonalAdvert extends Advert {
  private Date dateOfBirth;
  private Sex sex;
  private String message;

  public Date getDateOfBirth() {
	return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
  }

  public Sex getSex() {
	return sex;
  }

  public void setSex(Sex sex) {
	this.sex = sex;
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
	       .append("title", title)
	       .append("dateOfBirth", dateOfBirth)
	       .append("sex", sex)
	       .append("message", message);
	
	return builder.toString();
  }
}
