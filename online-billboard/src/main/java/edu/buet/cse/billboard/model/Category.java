package edu.buet.cse.billboard.model;

import java.util.List;

public class Category {
  private Long id;
  private String title;
  private List<Advert> adverts;

  protected Category() {
  }

  public Category(Long id, String title, List<Advert> adverts) {
	this.id = id;
	this.title = title;
	this.adverts = adverts;
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

  public List<Advert> getAdverts() {
	return adverts;
  }

  public void setAdverts(List<Advert> adverts) {
	this.adverts = adverts;
  }
}
