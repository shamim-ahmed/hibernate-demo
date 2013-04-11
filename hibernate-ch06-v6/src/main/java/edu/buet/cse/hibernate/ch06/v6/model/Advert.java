package edu.buet.cse.hibernate.ch06.v6.model;

public abstract class Advert {
  protected Long id;
  protected String title;

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
}
