package edu.buet.cse.hibernate.ch06.v7.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "Advert")
@DiscriminatorValue(value = "personal")
public class PersonalAdvert extends Advert {
  @Column(name = "birth_date")
  private Date dateOfBirth;

  @Column(name = "sex")
  private Sex sex;

  @Column(name = "message")
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
    builder.append("id", id).append("title", title).append("dateOfBirth", dateOfBirth).append("sex", sex)
        .append("message", message);

    return builder.toString();
  }
}
