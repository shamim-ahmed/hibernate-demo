package edu.buet.cse.billboard.v2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "Phone")
public class Phone {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  
  @Column(name = "number", nullable = false)
  private String number;
  
  @Column(name = "comment", nullable = false)
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
