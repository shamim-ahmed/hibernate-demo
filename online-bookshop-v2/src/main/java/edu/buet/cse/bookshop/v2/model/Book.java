package edu.buet.cse.bookshop.v2.model;

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
@Table(name = "Book")
public class Book {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "title", nullable = false)
  private String title;
  
  @Column(name = "pages", nullable = false)
  private int pageCount;
  
  @ManyToOne
  @JoinColumn(name = "publisher_id", nullable = true)
  private Publisher publisher;

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

  public int getPageCount() {
	return pageCount;
  }

  public void setPageCount(int pageCount) {
	this.pageCount = pageCount;
  }
  
  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }
  
  @Override
  public String toString() {
	ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
	builder.append("id", id)
	       .append("title", title)
	       .append("pageCount", pageCount)
	       .append("publisher", publisher != null ? publisher.getName() : "");
	
	return builder.toString();
  }
}
