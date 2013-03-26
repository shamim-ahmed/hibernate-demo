package edu.buet.cse.billboard.model;

public class Phone {
  private Long id;
  private User user;
  private String number;
  private String comment;

  protected Phone() {
  }

  public Phone(Long id, User user, String number, String comment) {
	this.id = id;
	this.user = user;
	this.number = number;
	this.comment = comment;
  }

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
}
