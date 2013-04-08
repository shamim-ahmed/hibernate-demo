package edu.buet.cse.bookshop.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Access(AccessType.FIELD)
@Table(name = "Book")
@SecondaryTable(name = "Metadata", pkJoinColumns = {@PrimaryKeyJoinColumn(name = "id")})
public class Book {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "title", nullable = false)
  private String title;
  
  @Column(name = "pages", nullable = false)
  private int pageCount;

  @Column(name = "isbn", table = "Metadata", nullable = false, unique = true)
  private String isbn;
  
  @Column(name = "category", table = "Metadata", nullable = false)
  private String category;

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
  
  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
  
  @Override
  public String toString() {
	ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
	builder.append("id", id)
	       .append("title", title)
	       .append("pageCount", pageCount)
	       .append("isbn", isbn)
	       .append("category", category);
	
	return builder.toString();
  }
}
