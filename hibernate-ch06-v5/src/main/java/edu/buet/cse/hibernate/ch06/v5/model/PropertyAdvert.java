package edu.buet.cse.hibernate.ch06.v5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "Property_Ad")
@Inheritance(strategy = InheritanceType.JOINED)
public class PropertyAdvert extends Advert {  
  @Column(name = "state", nullable = false)
  private String state;
  
  @Column(name = "zip_code", nullable = false)
  private String zipCode;
  
  @Column(name = "description", nullable = false)
  private String description;
  
  public String getState() {
	return state;
  }

  public void setState(String state) {
	this.state = state;
  }

  public String getZipCode() {
	return zipCode;
  }

  public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
  }

  public String getDescription() {
	return description;
  }

  public void setDescription(String description) {
	this.description = description;
  }
  
  @Override
  public String toString() {
	ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
	builder.append("id", id)
	       .append("title", title)
	       .append("state", state)
	       .append("zipCode", zipCode)
	       .append("description", description);
	
	return builder.toString();
  }
}
