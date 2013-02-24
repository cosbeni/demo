package org.jboss.errai.databinding.client;

import com.cosbeni.demo.shared.entity.Group;
import com.cosbeni.demo.shared.entity.User;
import org.jboss.errai.databinding.client.api.InitialState;

public class BindableProxyLoaderImpl implements BindableProxyLoader {
  public void loadBindableProxies() {
    class GroupProxy extends Group implements BindableProxy {
      private BindableProxyAgent<Group> agent;
      public GroupProxy(InitialState initialState) {
        this(new Group(), initialState);
      }

      public GroupProxy(Group target, InitialState initialState) {
        agent = new BindableProxyAgent<Group>(this, target, initialState);
        agent.propertyTypes.put("id", new PropertyType(Long.class, false));
        agent.propertyTypes.put("groupName", new PropertyType(String.class, false));
        agent.propertyTypes.put("description", new PropertyType(String.class, false));
      }

      public BindableProxyAgent getProxyAgent() {
        return agent;
      }

      public void updateWidgets() {
        agent.syncState(InitialState.FROM_MODEL);
      }

      public Group unwrap() {
        return agent.target;
      }

      public boolean equals(Object obj) {
        if (obj instanceof GroupProxy) {
          obj = ((GroupProxy) obj).unwrap();
        }
        return agent.target.equals(obj);
      }

      public int hashCode() {
        return agent.target.hashCode();
      }

      public String toString() {
        return agent.target.toString();
      }

      public Long getId() {
        return agent.target.getId();
      }

      public void setId(Long id) {
        Long oldValue = agent.target.getId();
        agent.target.setId(id);
        agent.updateWidgetAndFireEvent("id", oldValue, id);
      }

      public String getGroupName() {
        return agent.target.getGroupName();
      }

      public void setGroupName(String groupName) {
        String oldValue = agent.target.getGroupName();
        agent.target.setGroupName(groupName);
        agent.updateWidgetAndFireEvent("groupName", oldValue, groupName);
      }

      public String getDescription() {
        return agent.target.getDescription();
      }

      public void setDescription(String description) {
        String oldValue = agent.target.getDescription();
        agent.target.setDescription(description);
        agent.updateWidgetAndFireEvent("description", oldValue, description);
      }

      public Object get(String property) {
        if (property.equals("id")) {
          return getId();
        }
        if (property.equals("groupName")) {
          return getGroupName();
        }
        if (property.equals("description")) {
          return getDescription();
        }
        throw new NonExistingPropertyException(property);
      }

      public void set(String property, Object value) {
        if (property.equals("id")) {
          agent.target.setId((Long) value);
          return;
        }
        if (property.equals("groupName")) {
          agent.target.setGroupName((String) value);
          return;
        }
        if (property.equals("description")) {
          agent.target.setDescription((String) value);
          return;
        }
        throw new NonExistingPropertyException(property);
      }
    }
    BindableProxyFactory.addBindableProxy(Group.class, new BindableProxyProvider() {
      public BindableProxy getBindableProxy(Object model, InitialState state) {
        return new GroupProxy((Group) model, state);
      }
      public BindableProxy getBindableProxy(InitialState state) {
        return new GroupProxy(state);
      }
    });
    class UserProxy extends User implements BindableProxy {
      private BindableProxyAgent<User> agent;
      public UserProxy(InitialState initialState) {
        this(new User(), initialState);
      }

      public UserProxy(User target, InitialState initialState) {
        agent = new BindableProxyAgent<User>(this, target, initialState);
        agent.propertyTypes.put("id", new PropertyType(Long.class, false));
        agent.propertyTypes.put("lastName", new PropertyType(String.class, false));
        agent.propertyTypes.put("flag", new PropertyType(Boolean.class, false));
        agent.propertyTypes.put("email", new PropertyType(String.class, false));
        agent.propertyTypes.put("rid", new PropertyType(Long.class, false));
        agent.propertyTypes.put("command", new PropertyType(String.class, false));
        agent.propertyTypes.put("userName", new PropertyType(String.class, false));
        agent.propertyTypes.put("group", new PropertyType(Group.class, true));
        agent.propertyTypes.put("firstName", new PropertyType(String.class, false));
        agent.propertyTypes.put("password", new PropertyType(String.class, false));
      }

      public BindableProxyAgent getProxyAgent() {
        return agent;
      }

      public void updateWidgets() {
        agent.syncState(InitialState.FROM_MODEL);
      }

      public User unwrap() {
        return agent.target;
      }

      public boolean equals(Object obj) {
        if (obj instanceof UserProxy) {
          obj = ((UserProxy) obj).unwrap();
        }
        return agent.target.equals(obj);
      }

      public int hashCode() {
        return agent.target.hashCode();
      }

      public String toString() {
        return agent.target.toString();
      }

      public Long getId() {
        return agent.target.getId();
      }

      public void setId(Long id) {
        Long oldValue = agent.target.getId();
        agent.target.setId(id);
        agent.updateWidgetAndFireEvent("id", oldValue, id);
      }

      public String getLastName() {
        return agent.target.getLastName();
      }

      public void setLastName(String lastName) {
        String oldValue = agent.target.getLastName();
        agent.target.setLastName(lastName);
        agent.updateWidgetAndFireEvent("lastName", oldValue, lastName);
      }

      public Boolean getFlag() {
        return agent.target.getFlag();
      }

      public void setFlag(Boolean flag) {
        Boolean oldValue = agent.target.getFlag();
        agent.target.setFlag(flag);
        agent.updateWidgetAndFireEvent("flag", oldValue, flag);
      }

      public String getEmail() {
        return agent.target.getEmail();
      }

      public void setEmail(String email) {
        String oldValue = agent.target.getEmail();
        agent.target.setEmail(email);
        agent.updateWidgetAndFireEvent("email", oldValue, email);
      }

      public Long getRid() {
        return agent.target.getRid();
      }

      public void setRid(Long rid) {
        Long oldValue = agent.target.getRid();
        agent.target.setRid(rid);
        agent.updateWidgetAndFireEvent("rid", oldValue, rid);
      }

      public String getCommand() {
        return agent.target.getCommand();
      }

      public void setCommand(String command) {
        String oldValue = agent.target.getCommand();
        agent.target.setCommand(command);
        agent.updateWidgetAndFireEvent("command", oldValue, command);
      }

      public String getUserName() {
        return agent.target.getUserName();
      }

      public void setUserName(String userName) {
        String oldValue = agent.target.getUserName();
        agent.target.setUserName(userName);
        agent.updateWidgetAndFireEvent("userName", oldValue, userName);
      }

      public Group getGroup() {
        return agent.target.getGroup();
      }

      public void setGroup(Group group) {
        if (agent.binders.containsKey("group")) {
          group = (Group) agent.binders.get("group").setModel(group);
          set("group", group);
        }
        Group oldValue = agent.target.getGroup();
        agent.target.setGroup(group);
        agent.updateWidgetAndFireEvent("group", oldValue, group);
      }

      public String getFirstName() {
        return agent.target.getFirstName();
      }

      public void setFirstName(String firstName) {
        String oldValue = agent.target.getFirstName();
        agent.target.setFirstName(firstName);
        agent.updateWidgetAndFireEvent("firstName", oldValue, firstName);
      }

      public String getPassword() {
        return agent.target.getPassword();
      }

      public void setPassword(String password) {
        String oldValue = agent.target.getPassword();
        agent.target.setPassword(password);
        agent.updateWidgetAndFireEvent("password", oldValue, password);
      }

      public Object get(String property) {
        if (property.equals("id")) {
          return getId();
        }
        if (property.equals("lastName")) {
          return getLastName();
        }
        if (property.equals("flag")) {
          return getFlag();
        }
        if (property.equals("email")) {
          return getEmail();
        }
        if (property.equals("rid")) {
          return getRid();
        }
        if (property.equals("command")) {
          return getCommand();
        }
        if (property.equals("userName")) {
          return getUserName();
        }
        if (property.equals("group")) {
          return getGroup();
        }
        if (property.equals("firstName")) {
          return getFirstName();
        }
        if (property.equals("password")) {
          return getPassword();
        }
        throw new NonExistingPropertyException(property);
      }

      public void set(String property, Object value) {
        if (property.equals("id")) {
          agent.target.setId((Long) value);
          return;
        }
        if (property.equals("lastName")) {
          agent.target.setLastName((String) value);
          return;
        }
        if (property.equals("flag")) {
          agent.target.setFlag((Boolean) value);
          return;
        }
        if (property.equals("email")) {
          agent.target.setEmail((String) value);
          return;
        }
        if (property.equals("rid")) {
          agent.target.setRid((Long) value);
          return;
        }
        if (property.equals("command")) {
          agent.target.setCommand((String) value);
          return;
        }
        if (property.equals("userName")) {
          agent.target.setUserName((String) value);
          return;
        }
        if (property.equals("group")) {
          agent.target.setGroup((Group) value);
          return;
        }
        if (property.equals("firstName")) {
          agent.target.setFirstName((String) value);
          return;
        }
        if (property.equals("password")) {
          agent.target.setPassword((String) value);
          return;
        }
        throw new NonExistingPropertyException(property);
      }
    }
    BindableProxyFactory.addBindableProxy(User.class, new BindableProxyProvider() {
      public BindableProxy getBindableProxy(Object model, InitialState state) {
        return new UserProxy((User) model, state);
      }
      public BindableProxy getBindableProxy(InitialState state) {
        return new UserProxy(state);
      }
    });
  }
}