package edu.buet.cse.billboard.v2.model;

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
@Table(name = "Category")
public class Category {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "title")
  private String title;
  
  @ManyToMany
  @Cascade(value = CascadeType.SAVE_UPDATE)
  @JoinTable(name = "Advert_Category", 
             joinColumns = {@JoinColumn(name = "category_id", nullable = false)},
             inverseJoinColumns = {@JoinColumn(name = "advert_id", nullable = false)})
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
