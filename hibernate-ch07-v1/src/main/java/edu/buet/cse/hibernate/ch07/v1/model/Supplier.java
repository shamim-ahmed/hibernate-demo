package edu.buet.cse.hibernate.ch07.v1.model;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Supplier {
  private Long id;
  private String name;
  private Set<Product> products = new HashSet<>();

  public Long getId() {
	return id;
  }

  public void setId(Long id) {
	this.id = id;
  }

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public Set<Product> getProducts() {
	return products;
  }

  public void setProducts(Set<Product> products) {
	this.products = products;
  }
  
  @Override
  public String toString() {
	ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
	builder.append("id", id)
	       .append("name", name)
	       .append("productCount", products.size());
	
	return builder.toString();
		
  }
}
