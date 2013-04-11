package edu.buet.cse.hibernate.ch06.v1.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Advert {
  private Long id;
  private String title;
  private String content;
  private Picture picture;

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

  public String getContent() {
	return content;
  }

  public void setContent(String content) {
	this.content = content;
  }

  public Picture getPicture() {
	return picture;
  }

  public void setPicture(Picture picture) {
	this.picture = picture;
  }
  
  @Override
  public String toString() {
	ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
	builder.append("id", id)
	       .append("title", title)
	       .append("content", content)
	       .append("picture", picture);
	
	return builder.toString();
  }
}
