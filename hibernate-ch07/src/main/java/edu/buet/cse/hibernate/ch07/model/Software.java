package edu.buet.cse.hibernate.ch07.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Software extends Product {
  private String version;

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
    builder.append("id", getId()).append("name", getName()).append("description", getDescription())
        .append("price", getPrice()).append("supplierName", getSupplier().getName()).append("version", getVersion());

    return builder.toString();
  }
}
