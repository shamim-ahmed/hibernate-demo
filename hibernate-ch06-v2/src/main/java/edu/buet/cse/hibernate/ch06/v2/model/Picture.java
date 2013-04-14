package edu.buet.cse.hibernate.ch06.v2.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Embeddable
public class Picture {
  @Column(name = "pictureCaption", nullable = false)
  private String caption;

  @Column(name = "pictureFileName", nullable = false)
  private String fileName;

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
    builder.append("caption", caption).append("fileName", fileName);

    return builder.toString();
  }
}
