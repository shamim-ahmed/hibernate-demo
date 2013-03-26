package edu.buet.cse.billboard.model;

public class Advert {
  private Long id;
  private String title;
  private String message;
  private User user;

  protected Advert() {
  }

  public Advert(Long id, String title, String message, User user) {
	this.id = id;
	this.title = title;
	this.message = message;
	this.user = user;
  }

  public Long getId() {
	return id;
  }

  public void setId(Long id) {
	this.id = id;
  }

  public String getTitle() {
	return title;
  }

  public void setTitle(String title) {
	this.title = title;
  }

  public String getMessage() {
	return message;
  }

  public void setMessage(String message) {
	this.message = message;
  }

  public User getUser() {
	return user;
  }

  public void setUser(User user) {
	this.user = user;
  }
}
