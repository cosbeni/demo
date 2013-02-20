package com.cosbeni.demo.client.data;

import com.cosbeni.demo.shared.entity.User;
import com.cosbeni.demo.shared.entity.Group;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class UserRecord extends ListGridRecord {

  public UserRecord(User user) {
    setId(user.getId());
    setRid(user.getRid());
    setUserName(user.getUserName());
    setPassword(user.getPassword());
    setFirstName(user.getFirstName());
    setLastName(user.getLastName());
    setEmail(user.getEmail());
    setGroup(user.getGroup());    
    setFlag(user.getFlag());
    setCommand(user.getCommand());
  }

  public Long getId() {
    return getAttributeAsLong("id");
  }

  public void setId(Long id) {
    setAttribute("id", id);
  }
  
  public Long getRid() {
    return getAttributeAsLong("rid");
  }

  public void setRid(Long rid) {
    setAttribute("rid", rid);
  }
  
  public String getUserName() {
    return getAttributeAsString("userName");
  }

  public void setUserName(String userName) {
    setAttribute("userName", userName);
  }
  
  public String getPassword() {
    return getAttributeAsString("password");
  }

  public void setPassword(String password) {
    setAttribute("password", password);
  }

  public String getFirstName() {
    return getAttributeAsString("firstName");
  }

  public void setFirstName(String firstName) {
    setAttribute("firstName", firstName);
  }
  
  public String getLastName() {
    return getAttributeAsString("lastName");
  }

  public void setLastName(String lastName) {
    setAttribute("lastName", lastName);
  }
  
  public String getEmail() {
    return getAttributeAsString("email");
  }

  public void setEmail(String email) {
    setAttribute("email", email);
  }
  
  public Group getGroup() {
    return (Group)getAttributeAsObject("group");
  }

  public void setGroup(Group group) {
    setAttribute("group", group);
  }
  
  public Boolean getFlag() {
    return getAttributeAsBoolean("flag");
  }

  public void setFlag(Boolean flag) {
    setAttribute("flag", flag);
  }
  
  public String getCommand() {
    return getAttributeAsString("command");
  }

  public void setCommand(String command) {
    setAttribute("command", command);
  }
  
  public User getUser(){
    User user = new User();
    if(getId() != null)
      user.setId(getId());
    user.setRid(getRid());
    user.setUserName(getUserName());
    user.setPassword(getPassword());
    user.setFirstName(getFirstName());
    user.setLastName(getLastName());
    user.setEmail(getEmail());
    user.setGroup(getGroup());
    user.setFlag(getFlag());
    user.setCommand(getCommand());
    return user;    
  }
}
