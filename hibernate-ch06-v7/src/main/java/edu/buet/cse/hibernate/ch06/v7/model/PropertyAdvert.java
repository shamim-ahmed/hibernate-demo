package edu.buet.cse.hibernate.ch06.v7.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@DiscriminatorValue(value = "property")
public class PropertyAdvert extends Advert {
  @Column(name = "state")
  private String state;
  
  @Column(name = "zip_code")
  private String zipCode;
  
  @Column(name = "description")
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
