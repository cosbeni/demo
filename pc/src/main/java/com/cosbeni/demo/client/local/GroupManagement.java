package com.cosbeni.demo.client.local;

import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.ioc.client.api.Caller;

import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageHiding;
import org.jboss.errai.ui.nav.client.local.PageShowing;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.SinkNative;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cosbeni.demo.client.data.GroupDS;
import com.cosbeni.demo.client.data.GroupRecord;
import com.cosbeni.demo.client.i18n.DemoConstants;
import com.cosbeni.demo.shared.entity.Group;
import com.cosbeni.demo.shared.entity.User;
import com.cosbeni.demo.shared.service.GroupService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.ListDataProvider;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;

/**
 * Main application entry point.
 */

@Page
@Templated("#GroupManagement")
public class GroupManagement extends Composite {
  
  final String serverPath = "/demo-server/rest";

  @Inject
  EntityManager em;

  @Inject
  private Caller<GroupService> groupService;

  @DataField
  ListGrid groupsTable = new ListGrid();

  private ListDataProvider<User> dataProvider = new ListDataProvider<User>();

  @Inject
  @DataField
  private Label groupBox;

  @Inject
  @DataField
  private Label info;

  @DataField
  private HeadingElement infoMessage = Document.get().createHElement(4);

  @Inject
  @DataField
  private Label alert;

  @DataField
  private HeadingElement alertMessage = Document.get().createHElement(4);

  @Inject
  @DataField
  private Label idBox;

  @DataField
  private LabelElement id = DOM.createLabel().cast();

  @DataField
  private LabelElement idLabel = DOM.createLabel().cast();

  @Inject
  @DataField
  private Label groupNameBox;

  @Inject
  @DataField
  private TextBox groupName;

  @DataField
  private LabelElement groupNameLabel = DOM.createLabel().cast();

  @Inject
  @DataField
  private Label descriptionBox;

  @Inject
  @DataField
  private TextArea description;

  @DataField
  private LabelElement descriptionLabel = DOM.createLabel().cast();

  @Inject
  @DataField
  private Button add;

  @Inject
  @DataField
  private Button update;

  @Inject
  @DataField
  private Button delete;
  
  @Inject
  @DataField  
  private Button cancel;

  @Inject
  @DataField
  private Button deleteConfirm;
  
  @Inject
  @DataField
  private Button deleteCancel;

  private DemoConstants demoConstants;

  private Group group = new Group();
  
  private GroupManagement groupManagement;

  @PageShowing
  private void preparePage() {
    groupManagement = this;
    this.setVisible(false);
    demoConstants = GWT.create(DemoConstants.class);
    groupBox.setVisible(true);
    add.setText(demoConstants.add());
    add.setVisible(true);
    update.setText(demoConstants.update());
    update.setVisible(false);
    delete.setText(demoConstants.delete());
    delete.setVisible(false);
    cancel.setText(demoConstants.cancel());
    cancel.setVisible(false);
    deleteConfirm.setText(demoConstants.delete());
    deleteCancel.setText(demoConstants.cancel());    
    alert.setVisible(false);
    info.setVisible(false);   
    groupsTable.setShowFilterEditor(true);
    groupsTable.setFilterOnKeypress(true);
    groupsTable.addSelectionChangedHandler(new SelectionChangedHandler() {
      public void onSelectionChanged(SelectionEvent event) {
        GroupRecord g = (GroupRecord) groupsTable.getSelectedRecord();
        if (g != null) {
          group = g.getGroup();
          toWidget();
          add.setVisible(false);
          update.setVisible(true);
          delete.setVisible(true);
          cancel.setVisible(true);         
        }
      }
    });
    RestClient.setApplicationRoot(serverPath);
    RestClient.setJacksonMarshallingActive(false);
    groupService.call(groupGroups).getGroups();
  }

  @PageHiding
  private void unpreparePage() {
  }

  final private RemoteCallback<List<Group>> groupGroups = new RemoteCallback<List<Group>>() {
    @Override
    public void callback(List<Group> result) {     
      ArrayList<GroupRecord> groups = new ArrayList<GroupRecord>();
      for (Group g : result) {
        groups.add(new GroupRecord(g));
      }
      GroupDS.getInstance().setTestData(groups.toArray(new GroupRecord[groups.size()]));
      groupManagement.setVisible(true);
      groupsTable.setWidth(570);
      groupsTable.setDataSource(GroupDS.getInstance());
      groupsTable.fetchData();
    }
  };

  @EventHandler("add")
  public void add(ClickEvent e) {
    RestClient.setApplicationRoot(serverPath);
    RestClient.setJacksonMarshallingActive(false);
    group = toGroupValue();
    groupService.call(groupAdd).add(group);
  }

  @EventHandler("update")
  public void update(ClickEvent e) {
    RestClient.setApplicationRoot(serverPath);
    RestClient.setJacksonMarshallingActive(false);
    group = toGroupValue();
    groupService.call(groupUpdate).update(group);
  }

  @EventHandler("delete")
  public void delete(ClickEvent e) {
    groupBox.setVisible(false);
    alert.setVisible(true);
  }
  
  @EventHandler("cancel")
  public void cancel(ClickEvent e) {
    group = new Group();
    toWidget();
    groupBox.setVisible(true);
    add.setVisible(true);
    update.setVisible(false);
    delete.setVisible(false);
    cancel.setVisible(false);
    alert.setVisible(false);
    info.setVisible(false);
  }
  
  @EventHandler("deleteConfirm")
  public void deleteConfirm(ClickEvent e) {
    RestClient.setApplicationRoot(serverPath);
    RestClient.setJacksonMarshallingActive(false);
    group = toGroupValue();
    groupService.call(groupDelete).delete(group.getId().toString());
  }

  @EventHandler("deleteCancel")
  public void deleteCancel(ClickEvent e) {
    group = new Group();
    toWidget();
    groupBox.setVisible(true);
    add.setVisible(true);
    update.setVisible(false);
    delete.setVisible(false);
    cancel.setVisible(false);
    alert.setVisible(false);
    info.setVisible(false);
  }

  public Group toGroupValue() {
    Group result = new Group();
    if (!id.getInnerText().equals("")) {
      result.setId(new Long(id.getInnerText()));
    }
    result.setGroupName(groupName.getValue());
    result.setDescription(description.getValue());
    return result;
  }

  public void toWidget() {
    if (group.getId() != null) {
      id.setInnerText(group.getId().toString());
    } else {
      id.setInnerText("");
    }
    groupName.setValue(group.getGroupName());
    description.setValue(group.getDescription());
    add.setVisible(false);
  }

  final public RemoteCallback<String> groupAdd = new RemoteCallback<String>() {
    @Override
    public void callback(String result) {
      if (result.equals("OK")) {
        groupService.call(groupGroups).getGroups();
      }
    }
  };

  final public RemoteCallback<String> groupUpdate = new RemoteCallback<String>() {
    @Override
    public void callback(String result) {
      if (result.equals("OK")) {
        groupService.call(groupGroups).getGroups();
      }
    }
  };
  
  final public RemoteCallback<String> groupDelete = new RemoteCallback<String>() {
    @Override
    public void callback(String result) {
      if (result.equals("OK")) {
        groupService.call(groupGroups).getGroups();
        group = new Group();
        toWidget();
        groupBox.setVisible(true);
        add.setVisible(true);
        update.setVisible(false);
        delete.setVisible(false);
        cancel.setVisible(false);
        alert.setVisible(false);
        info.setVisible(false);
      }
    }
  };

}
