package edu.buet.cse.hibernate.ch09.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Embeddable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Address {
  @Column(name = "street", nullable = false)
  private String street;
  
  @Column(name = "city", nullable = true)
  private String city;
  
  @Column(name = "country", nullable = false)
  private String country;

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
  
  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
    builder.append("street", street)
           .append("city", city)
           .append("country", country);
    
    return builder.toString();
  }
}
