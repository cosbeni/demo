package com.cosbeni.demo.shared.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import org.jboss.errai.enterprise.client.cdi.api.Conversational;

import com.cosbeni.demo.shared.validation.Email;
import com.google.gwt.view.client.ProvidesKey;

@Conversational
@Portable
@XmlRootElement
@Bindable
@Entity
@NamedQueries({
  @NamedQuery(name = "users", query = "SELECT u FROM User u WHERE u.flag = true ORDER BY u.id"),
  @NamedQuery(name = "rids", query = "SELECT u FROM User u WHERE u.rid > 0"),
  @NamedQuery(name = "adds", query = "SELECT u FROM User u WHERE u.command = 'ADD' ORDER BY u.id"),  
  @NamedQuery(name = "updates", query = "SELECT u FROM User u WHERE u.command = 'UPDATE' ORDER BY u.id"),  
  @NamedQuery(name = "deletes", query = "SELECT u FROM User u WHERE u.command = 'DELETE' ORDER BY u.id")  
})
@Table(name = "user")
public class User implements java.io.Serializable {

  public static final ProvidesKey<User> KEY_PROVIDER = new ProvidesKey<User>() {
    @Override
    public Object getKey(User item) {
      return item == null ? null : item.getId();
    }
  };

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  private Long rid = 0L;
  @NotNull(message = "{required.message}")
  @NotEmpty(message = "{required.message}")
  @NotBlank(message = "{required.message}")
  @Column(name = "username", columnDefinition = "VARCHAR(255) default ''")  
  private String userName;
  @NotNull
  @Size(min = 6, message = "{password.min.size.message}")
  private String password;  
  @Column(name = "firstname", columnDefinition = "VARCHAR(255) default ''")
  private String firstName;
  @NotNull(message = "{required.message}")
  @NotEmpty(message = "{required.message}")
  @NotBlank(message = "{required.message}")  
  @Column(name = "lastname", columnDefinition = "VARCHAR(255) default ''")
  private String lastName;
  @NotNull(message = "{required.message}")
  @NotEmpty(message = "{required.message}")
  @NotBlank(message = "{required.message}")
  @Email(message = "{email.message}")
  private String email;
  @ManyToOne
  @JoinColumn(name = "user_group")
  private Group group;
  private Boolean flag = true;
  private String command;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  
  public Long getRid() {
    return this.rid;
  }

  public void setRid(Long rid) {
    this.rid = rid;
  }

  public String getUserName()
  {
     return userName;
  }

  public void setUserName(String name)
  {
     this.userName = name;
  }

  public String getPassword()
  {
     return password;
  }

  public void setPassword(String password)
  {
     this.password = password;
  }

  public String getFirstName()
  {
     return firstName;
  }

  public void setFirstName(String firstName)
  {
     this.firstName = firstName;
  }

  public String getLastName()
  {
     return lastName;
  }

  public void setLastName(String lastName)
  {
     this.lastName = lastName;
  }

  public String getEmail()
  {
     return email;
  }

  public void setEmail(String email)
  {
     this.email = email;
  }
  
  public Group getGroup(){
    return group;
  }
  
  public void setGroup(Group group){
    this.group = group;
  }

  public Boolean getFlag() {
    return flag;
  }

  public void setFlag(Boolean flag) {
    this.flag = flag;
  }

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }
  
}
