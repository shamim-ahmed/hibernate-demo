package edu.buet.cse.billboard.model;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Category {
  private Long id;
  private String title;
  private Set<Advert> adverts = new HashSet<>();

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

  public Set<Advert> getAdverts() {
	return adverts;
  }

  public void setAdverts(Set<Advert> adverts) {
	this.adverts = adverts;
  }
  
  @Override
  public String toString() {
	ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
	builder.append("id", id)
	       .append("title", title)
	       .append("advertCount", adverts.size());
	
	return builder.toString();
  }
}
