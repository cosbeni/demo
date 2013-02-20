package org.jboss.errai.enterprise.client.jaxrs;

import com.cosbeni.demo.shared.entity.Demo;
import com.cosbeni.demo.shared.entity.Group;
import com.cosbeni.demo.shared.entity.User;
import com.cosbeni.demo.shared.service.DemoService;
import com.cosbeni.demo.shared.service.GroupService;
import com.cosbeni.demo.shared.service.UserService;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.URL;
import java.util.List;
import org.jboss.errai.bus.client.api.ErrorCallback;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.bus.client.framework.ProxyProvider;
import org.jboss.errai.bus.client.framework.RemoteServiceProxyFactory;

public class JaxrsProxyLoaderImpl implements JaxrsProxyLoader {
  public void loadProxies() {
    class GroupServiceImpl extends AbstractJaxrsProxy implements GroupService {
      private RemoteCallback remoteCallback;
      private ErrorCallback errorCallback;
      public RemoteCallback getRemoteCallback() {
        return remoteCallback;
      }

      public void setRemoteCallback(RemoteCallback callback) {
        remoteCallback = callback;
      }

      public ErrorCallback getErrorCallback() {
        return errorCallback;
      }

      public void setErrorCallback(ErrorCallback callback) {
        errorCallback = callback;
      }

      public String add(final Group a0) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("group/add");
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        requestBuilder.setHeader("Content-Type", "application/json");
        sendRequest(requestBuilder, MarshallingWrapper.toJSON(a0), new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return String.valueOf(response);
          }
        });
        return null;
      }

      public String update(final Group a0) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("group/update");
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        requestBuilder.setHeader("Content-Type", "application/json");
        sendRequest(requestBuilder, MarshallingWrapper.toJSON(a0), new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return String.valueOf(response);
          }
        });
        return null;
      }

      public String delete(final String a0) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("group/delete/{id}".replace("{id}", URL.encodePathSegment(a0 == null ? "" : a0)));
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        sendRequest(requestBuilder, null, new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return String.valueOf(response);
          }
        });
        return null;
      }

      public List getGroups() {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("group/groups");
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        sendRequest(requestBuilder, null, new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return MarshallingWrapper.fromJSON(response, List.class, Group.class);
          }
        });
        return null;
      }

      public Group getGroup(final String a0) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("group/group/{id}".replace("{id}", URL.encodePathSegment(a0 == null ? "" : a0)));
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        sendRequest(requestBuilder, null, new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return MarshallingWrapper.fromJSON(response, Group.class, null);
          }
        });
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(GroupService.class, new ProxyProvider() {
      public Object getProxy() {
        return new GroupServiceImpl();
      }
    });
    class DemoServiceImpl extends AbstractJaxrsProxy implements DemoService {
      private RemoteCallback remoteCallback;
      private ErrorCallback errorCallback;
      public RemoteCallback getRemoteCallback() {
        return remoteCallback;
      }

      public void setRemoteCallback(RemoteCallback callback) {
        remoteCallback = callback;
      }

      public ErrorCallback getErrorCallback() {
        return errorCallback;
      }

      public void setErrorCallback(ErrorCallback callback) {
        errorCallback = callback;
      }

      public String add(final Demo a0) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("demo/add");
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        requestBuilder.setHeader("Content-Type", "application/json");
        sendRequest(requestBuilder, MarshallingWrapper.toJSON(a0), new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return String.valueOf(response);
          }
        });
        return null;
      }

      public String update(final Demo a0) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("demo/update");
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        requestBuilder.setHeader("Content-Type", "application/json");
        sendRequest(requestBuilder, MarshallingWrapper.toJSON(a0), new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return String.valueOf(response);
          }
        });
        return null;
      }

      public String delete(final String a0) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("demo/delete/{id}".replace("{id}", URL.encodePathSegment(a0 == null ? "" : a0)));
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        sendRequest(requestBuilder, null, new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return String.valueOf(response);
          }
        });
        return null;
      }

      public List getDemos() {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("demo/groups");
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        sendRequest(requestBuilder, null, new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return MarshallingWrapper.fromJSON(response, List.class, Demo.class);
          }
        });
        return null;
      }

      public Demo getDemo(final String a0) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("demo/group/{id}".replace("{id}", URL.encodePathSegment(a0 == null ? "" : a0)));
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        sendRequest(requestBuilder, null, new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return MarshallingWrapper.fromJSON(response, Demo.class, null);
          }
        });
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DemoService.class, new ProxyProvider() {
      public Object getProxy() {
        return new DemoServiceImpl();
      }
    });
    class UserServiceImpl extends AbstractJaxrsProxy implements UserService {
      private RemoteCallback remoteCallback;
      private ErrorCallback errorCallback;
      public RemoteCallback getRemoteCallback() {
        return remoteCallback;
      }

      public void setRemoteCallback(RemoteCallback callback) {
        remoteCallback = callback;
      }

      public ErrorCallback getErrorCallback() {
        return errorCallback;
      }

      public void setErrorCallback(ErrorCallback callback) {
        errorCallback = callback;
      }

      public String add(final User a0) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("user/add");
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        requestBuilder.setHeader("Content-Type", "application/json");
        sendRequest(requestBuilder, MarshallingWrapper.toJSON(a0), new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return String.valueOf(response);
          }
        });
        return null;
      }

      public String update(final User a0) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("user/update");
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        requestBuilder.setHeader("Content-Type", "application/json");
        sendRequest(requestBuilder, MarshallingWrapper.toJSON(a0), new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return String.valueOf(response);
          }
        });
        return null;
      }

      public List getUsers() {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("user/users");
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        sendRequest(requestBuilder, null, new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return MarshallingWrapper.fromJSON(response, List.class, User.class);
          }
        });
        return null;
      }

      public User getUser(final String a0) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("user/user/{id}".replace("{id}", URL.encodePathSegment(a0 == null ? "" : a0)));
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        sendRequest(requestBuilder, null, new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return MarshallingWrapper.fromJSON(response, User.class, null);
          }
        });
        return null;
      }

      public String delete(final String a0) {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append("user/delete/{id}".replace("{id}", URL.encodePathSegment(a0 == null ? "" : a0)));
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, url.toString());
        requestBuilder.setHeader("Accept", "application/json");
        sendRequest(requestBuilder, null, new ResponseDemarshallingCallback() {
          public Object demarshallResponse(String response) {
            return String.valueOf(response);
          }
        });
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(UserService.class, new ProxyProvider() {
      public Object getProxy() {
        return new UserServiceImpl();
      }
    });
  }
}