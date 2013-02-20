package com.cosbeni.demo.shared.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;

import com.google.gwt.view.client.ProvidesKey;


@Portable
@XmlRootElement
@Bindable
@Entity
@NamedQueries({
  @NamedQuery(name = "demos", query = "SELECT d FROM Demo d"),
  @NamedQuery(name = "demoById", query="SELECT d FROM Demo d WHERE d.id = :id")
})
@Table(name = "demo")
public class Demo implements java.io.Serializable {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  @NotNull(message = "{required.message}")
  @NotEmpty(message = "{required.message}")
  @NotBlank(message = "{required.message}")
  @Column(name = "username", columnDefinition = "VARCHAR(255) default ''")  
  private String username;
  private String data1;
  private String data2;
  private String data3;
  private String data4;
  private String data5;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  
  public String getUsername()
  {
     return username;
  }

  public void setUsername(String username)
  {
     this.username = username;
  }

  public String getData1() {
    return data1;
  }

  public void setData1(String data1) {
    this.data1 = data1;
  }

  public String getData2() {
    return data2;
  }

  public void setData2(String data2) {
    this.data2 = data2;
  }

  public String getData3() {
    return data3;
  }

  public void setData3(String data3) {
    this.data3 = data3;
  }

  public String getData4() {
    return data4;
  }

  public void setData4(String data4) {
    this.data4 = data4;
  }

  public String getData5() {
    return data5;
  }

  public void setData5(String data5) {
    this.data5 = data5;
  }
  
}
