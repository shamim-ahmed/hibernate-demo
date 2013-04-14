package edu.buet.cse.hibernate.ch07.v1.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Product {
  private Long id;
  private String name;
  private String description;
  private double price;
  private Supplier supplier;

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

  public String getDescription() {
	return description;
  }

  public void setDescription(String description) {
	this.description = description;
  }

  public double getPrice() {
	return price;
  }

  public void setPrice(double price) {
	this.price = price;
  }

  public Supplier getSupplier() {
	return supplier;
  }

  public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
  }
  
  @Override
  public String toString() {
	ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
	builder.append("id", id)
	       .append("name", name)
	       .append("description", description)
	       .append("price", price)
	       .append("supplierName", supplier.getName());
	
	return builder.toString();
  }
}
