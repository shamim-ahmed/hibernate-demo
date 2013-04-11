package edu.buet.cse.hibernate.ch06.v5.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "Personal_Ad")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonalAdvert extends Advert {
  @Column(name = "birth_date", nullable = false)
  private Date dateOfBirth;
  
  @Column(name = "sex", nullable = false)
  private Sex sex;
  
  @Column(name = "message", nullable = true)
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
