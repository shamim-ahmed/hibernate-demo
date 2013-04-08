package edu.buet.cse.bookshop.v2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Author")
public class Author {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "first_name", nullable = false)
  private String firstName;
  
  @Column(name = "last_name", nullable = false)
  private String lastName;
  
  @ManyToMany
  @Cascade(CascadeType.SAVE_UPDATE)
  @JoinTable(name = "Book_Author", 
             joinColumns = {@JoinColumn(name = "author_id", nullable = false)},
             inverseJoinColumns = {@JoinColumn(name = "book_id", nullable = false)})
  private Set<Book> books = new HashSet<>();

  public Long getId() {
	return id;
  }

  public void setId(Long id) {
	this.id = id;
  }

  public String getFirstName() {
	return firstName;
  }

  public void setFirstName(String firstName) {
	this.firstName = firstName;
  }

  public String getLastName() {
	return lastName;
  }

  public void setLastName(String lastName) {
	this.lastName = lastName;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }
  
  @Override
  public String toString() {
	ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
	builder.append("id", id)
	       .append("firstName", firstName)
	       .append("lastName", lastName)
	       .append("bookCount", books.size());

	return builder.toString();
  }
}
