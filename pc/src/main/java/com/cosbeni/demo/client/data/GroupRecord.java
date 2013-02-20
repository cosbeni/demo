package com.cosbeni.demo.client.data;

import com.cosbeni.demo.shared.entity.Group;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class GroupRecord extends ListGridRecord {

  public GroupRecord(Group group) {
    setId(group.getId());
    setGroupName(group.getGroupName());
    setDescription(group.getDescription());
  }

  public Long getId() {
    return getAttributeAsLong("id");
  }

  public void setId(Long id) {
    setAttribute("id", id);
  }
  
  public String getGroupName() {
    return getAttributeAsString("groupName");
  }

  public void setGroupName(String name) {
    setAttribute("groupName", name);
  }
  
  public String getDescription() {
    return getAttributeAsString("description");
  }

  public void setDescription(String description) {
    setAttribute("description", description);
  }    
  
  public Group getGroup(){
    Group group = new Group();
    if(getId() != null)
      group.setId(getId());
    group.setGroupName(getGroupName());
    group.setDescription(getDescription());
    return group;    
  }
  
}
