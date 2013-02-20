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

import java.util.HashMap;

import com.cosbeni.demo.client.i18n.DemoConstants;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;

public class UserServerDS extends DataSource {

  private DemoConstants demoConstants;

  private static UserServerDS instance = null;

  public static UserServerDS getInstance() {
    if (instance == null) {
      instance = new UserServerDS("UserServerDS");
    }
    return instance;
  }

  public UserServerDS(String id) {

    demoConstants = GWT.create(DemoConstants.class);
    setID(id);
    DataSourceSequenceField idField = new DataSourceSequenceField("id");
    idField.setPrimaryKey(true);
    DataSourceIntegerField ridField = new DataSourceIntegerField("rid");
    DataSourceTextField userNameField = new DataSourceTextField("userName", demoConstants.userName());
    DataSourceTextField passwordField = new DataSourceTextField("password", demoConstants.password());
    passwordField.setHidden(true);
    DataSourceTextField firstNameField = new DataSourceTextField("firstName", demoConstants.firstName());
    DataSourceTextField lastNameField = new DataSourceTextField("lastName", demoConstants.lastName());
    DataSourceTextField emailField = new DataSourceTextField("email", demoConstants.email());
    setFields(idField, ridField,userNameField, passwordField, firstNameField, lastNameField, emailField);
    setClientOnly(true);
  }
}