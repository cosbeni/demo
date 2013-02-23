/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.cosbeni.demo.client.data;

import com.cosbeni.demo.client.i18n.DemoConstants;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;

public class GroupDS extends DataSource {

  private DemoConstants demoConstants;

  private static GroupDS instance = null;

  public static GroupDS getInstance() {
    if (instance == null) {
      instance = new GroupDS("GroupDS");
    }
    return instance;
  }

  public GroupDS(String id) {

    demoConstants = GWT.create(DemoConstants.class);
    setID(id);
    DataSourceSequenceField idField = new DataSourceSequenceField("id",demoConstants.id());
    idField.setHidden(true);
    idField.setPrimaryKey(true);

    DataSourceTextField nameField = new DataSourceTextField("groupName", demoConstants.groupName());
    DataSourceTextField descriptionField = new DataSourceTextField("description", demoConstants.description());

    setFields(idField, nameField, descriptionField);
    setClientOnly(true);
  }
}