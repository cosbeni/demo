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
  @NamedQuery(name = "groups", query = "SELECT g FROM Group g"),
  @NamedQuery(name = "groupById", query="SELECT g FROM Group g WHERE g.id = :id")
})
@Table(name = "user_group")
public class Group implements java.io.Serializable {

  public static final ProvidesKey<Group> KEY_PROVIDER = new ProvidesKey<Group>() {
    @Override
    public Object getKey(Group item) {
      return item == null ? null : item.getId();
    }
  };

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  @NotNull(message = "{required.message}")
  @NotEmpty(message = "{required.message}")
  @NotBlank(message = "{required.message}")
  @Column(name = "group_name", columnDefinition = "VARCHAR(255) default ''")  
  private String groupName;
  private String description;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  
  public String getGroupName()
  {
     return groupName;
  }

  public void setGroupName(String name)
  {
     this.groupName = name;
  }
  
  public String getDescription()
  {
     return description;
  }

  public void setDescription(String description)
  {
     this.description = description;
  }
  
}
