package org.jboss.errai.ioc.client;

import com.cosbeni.demo.mobile.App;
import com.cosbeni.demo.mobile.UserForm;
import com.cosbeni.demo.mobile.UserList;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.HasAttachHandlers;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.IsRenderable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Provider;
import org.jboss.errai.common.client.api.extension.InitVotes;
import org.jboss.errai.databinding.client.DataBinderProvider;
import org.jboss.errai.databinding.client.DataBindingModuleBootstrapper;
import org.jboss.errai.enterprise.client.cdi.CDIEventTypeLookup;
import org.jboss.errai.enterprise.client.cdi.EventProvider;
import org.jboss.errai.enterprise.client.cdi.InstanceProvider;
import org.jboss.errai.enterprise.client.cdi.api.CDI;
import org.jboss.errai.enterprise.client.jaxrs.JaxrsModuleBootstrapper;
import org.jboss.errai.ioc.client.api.ContextualTypeProvider;
import org.jboss.errai.ioc.client.api.builtin.CallerProvider;
import org.jboss.errai.ioc.client.api.builtin.DisposerProvider;
import org.jboss.errai.ioc.client.api.builtin.IOCBeanManagerProvider;
import org.jboss.errai.ioc.client.api.builtin.InitBallotProvider;
import org.jboss.errai.ioc.client.api.builtin.MessageBusProvider;
import org.jboss.errai.ioc.client.api.builtin.RequestDispatcherProvider;
import org.jboss.errai.ioc.client.api.builtin.RootPanelProvider;
import org.jboss.errai.ioc.client.api.builtin.SenderProvider;
import org.jboss.errai.ioc.client.container.CreationalCallback;
import org.jboss.errai.ioc.client.container.CreationalContext;
import org.jboss.errai.ioc.client.container.IOCBeanManager;
import org.jboss.errai.ioc.client.container.InitializationCallback;
import org.jboss.errai.jpa.client.local.ErraiEntityManagerProvider;
import org.jboss.errai.ui.client.widget.ListWidgetProvider;
import org.jboss.errai.ui.shared.Template;
import org.jboss.errai.ui.shared.TemplateUtil;

public class BootstrapperImpl implements Bootstrapper {
  {
    new CDI().initLookupTable(CDIEventTypeLookup.get());
    new DataBindingModuleBootstrapper().run();
    new JaxrsModuleBootstrapper().run();
  }
  private final Any _1998831462Any_308783804 = new Any() {
    public Class annotationType() {
      return Any.class;
    }
  };
  private final Default _1998831462Default_1726233882 = new Default() {
    public Class annotationType() {
      return Default.class;
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_960558090 = new Annotation[] { _1998831462Any_308783804, _1998831462Default_1726233882 };
  private final BootstrapperInjectionContext injContext = new BootstrapperInjectionContext();
  private final CreationalContext context = injContext.getRootContext();
  private final CreationalCallback<DataBinderProvider> inj57139_DataBinderProvider_creational = new CreationalCallback<DataBinderProvider>() {
    public DataBinderProvider getInstance(final CreationalContext context) {
      final DataBinderProvider inj57124_DataBinderProvider = new DataBinderProvider();
      context.addBean(context.getBeanReference(DataBinderProvider.class, arrayOf_19635043Annotation_960558090), inj57124_DataBinderProvider);
      return inj57124_DataBinderProvider;
    }
  };
  private final DataBinderProvider inj57124_DataBinderProvider = inj57139_DataBinderProvider_creational.getInstance(context);
  private final CreationalCallback<RequestDispatcherProvider> inj57140_RequestDispatcherProvider_creational = new CreationalCallback<RequestDispatcherProvider>() {
    public RequestDispatcherProvider getInstance(final CreationalContext context) {
      final RequestDispatcherProvider inj57118_RequestDispatcherProvider = new RequestDispatcherProvider();
      context.addBean(context.getBeanReference(RequestDispatcherProvider.class, arrayOf_19635043Annotation_960558090), inj57118_RequestDispatcherProvider);
      return inj57118_RequestDispatcherProvider;
    }
  };
  private final RequestDispatcherProvider inj57118_RequestDispatcherProvider = inj57140_RequestDispatcherProvider_creational.getInstance(context);
  private final CreationalCallback<InstanceProvider> inj57141_InstanceProvider_creational = new CreationalCallback<InstanceProvider>() {
    public InstanceProvider getInstance(final CreationalContext context) {
      final InstanceProvider inj57128_InstanceProvider = new InstanceProvider();
      context.addBean(context.getBeanReference(InstanceProvider.class, arrayOf_19635043Annotation_960558090), inj57128_InstanceProvider);
      return inj57128_InstanceProvider;
    }
  };
  private final InstanceProvider inj57128_InstanceProvider = inj57141_InstanceProvider_creational.getInstance(context);
  private InitializationCallback<UserList> init_inj56941_UserList = new InitializationCallback<UserList>() {
    public void init(final UserList obj) {
      obj.init();
    }
  };
  private final CreationalCallback<UserList> inj57144_UserList_creational = new CreationalCallback<UserList>() {
    public UserList getInstance(final CreationalContext context) {
      final UserList inj56941_UserList = new UserList();
      context.addBean(context.getBeanReference(UserList.class, arrayOf_19635043Annotation_960558090), inj56941_UserList);
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          inj56941_UserList.afterInit();
        }
      });
      context.addInitializationCallback(inj56941_UserList, new InitializationCallback<UserList>() {
        public void init(UserList obj) {
          com_cosbeni_demo_mobile_UserListTemplateResource var209 = GWT.create(com_cosbeni_demo_mobile_UserListTemplateResource.class);
          Element var210 = TemplateUtil.getRootTemplateElement(var209.getContents().getText(), "UserList");
          Map<String, Element> var211 = TemplateUtil.getDataFieldElements(var210);
          Map<String, Widget> var212 = new LinkedHashMap<String, Widget>();
          TemplateUtil.initWidget(inj56941_UserList, var210, var212.values());
        }
      });
      context.addInitializationCallback(inj56941_UserList, init_inj56941_UserList);
      return inj56941_UserList;
    }
  };
  private InitializationCallback<UserForm> init_inj56940_UserForm = new InitializationCallback<UserForm>() {
    public void init(final UserForm obj) {
      obj.init();
    }
  };
  private final CreationalCallback<UserForm> inj57145_UserForm_creational = new CreationalCallback<UserForm>() {
    public UserForm getInstance(final CreationalContext context) {
      final UserForm inj56940_UserForm = new UserForm();
      context.addBean(context.getBeanReference(UserForm.class, arrayOf_19635043Annotation_960558090), inj56940_UserForm);
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          inj56940_UserForm.afterInit();
        }
      });
      context.addInitializationCallback(inj56940_UserForm, new InitializationCallback<UserForm>() {
        public void init(UserForm obj) {
          com_cosbeni_demo_mobile_UserFormTemplateResource var213 = GWT.create(com_cosbeni_demo_mobile_UserFormTemplateResource.class);
          Element var214 = TemplateUtil.getRootTemplateElement(var213.getContents().getText(), "UserForm");
          Map<String, Element> var215 = TemplateUtil.getDataFieldElements(var214);
          Map<String, Widget> var216 = new LinkedHashMap<String, Widget>();
          TemplateUtil.initWidget(inj56940_UserForm, var214, var216.values());
        }
      });
      context.addInitializationCallback(inj56940_UserForm, init_inj56940_UserForm);
      return inj56940_UserForm;
    }
  };
  private InitializationCallback<App> init_inj57142_App = new InitializationCallback<App>() {
    public void init(final App obj) {
      obj.init();
    }
  };
  private final CreationalCallback<App> inj57143_App_creational = new CreationalCallback<App>() {
    public App getInstance(final CreationalContext context) {
      final App inj57142_App = new App();
      context.addBean(context.getBeanReference(App.class, arrayOf_19635043Annotation_960558090), inj57142_App);
      _2007837066_userList(inj57142_App, inj57144_UserList_creational.getInstance(context));
      _2007837066_userForm(inj57142_App, inj57145_UserForm_creational.getInstance(context));
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          inj57142_App.afterInit();
        }
      });
      context.addInitializationCallback(inj57142_App, init_inj57142_App);
      return inj57142_App;
    }
  };
  private final App inj57142_App = inj57143_App_creational.getInstance(context);
  private final CreationalCallback<EventProvider> inj57146_EventProvider_creational = new CreationalCallback<EventProvider>() {
    public EventProvider getInstance(final CreationalContext context) {
      final EventProvider inj57132_EventProvider = new EventProvider();
      context.addBean(context.getBeanReference(EventProvider.class, arrayOf_19635043Annotation_960558090), inj57132_EventProvider);
      return inj57132_EventProvider;
    }
  };
  private final EventProvider inj57132_EventProvider = inj57146_EventProvider_creational.getInstance(context);
  private final CreationalCallback<MessageBusProvider> inj57147_MessageBusProvider_creational = new CreationalCallback<MessageBusProvider>() {
    public MessageBusProvider getInstance(final CreationalContext context) {
      final MessageBusProvider inj57116_MessageBusProvider = new MessageBusProvider();
      context.addBean(context.getBeanReference(MessageBusProvider.class, arrayOf_19635043Annotation_960558090), inj57116_MessageBusProvider);
      return inj57116_MessageBusProvider;
    }
  };
  private final MessageBusProvider inj57116_MessageBusProvider = inj57147_MessageBusProvider_creational.getInstance(context);
  private final CreationalCallback<IOCBeanManagerProvider> inj57148_IOCBeanManagerProvider_creational = new CreationalCallback<IOCBeanManagerProvider>() {
    public IOCBeanManagerProvider getInstance(final CreationalContext context) {
      final IOCBeanManagerProvider inj57122_IOCBeanManagerProvider = new IOCBeanManagerProvider();
      context.addBean(context.getBeanReference(IOCBeanManagerProvider.class, arrayOf_19635043Annotation_960558090), inj57122_IOCBeanManagerProvider);
      return inj57122_IOCBeanManagerProvider;
    }
  };
  private final IOCBeanManagerProvider inj57122_IOCBeanManagerProvider = inj57148_IOCBeanManagerProvider_creational.getInstance(context);
  private final CreationalCallback<SenderProvider> inj57149_SenderProvider_creational = new CreationalCallback<SenderProvider>() {
    public SenderProvider getInstance(final CreationalContext context) {
      final SenderProvider inj57138_SenderProvider = new SenderProvider();
      context.addBean(context.getBeanReference(SenderProvider.class, arrayOf_19635043Annotation_960558090), inj57138_SenderProvider);
      return inj57138_SenderProvider;
    }
  };
  private final SenderProvider inj57138_SenderProvider = inj57149_SenderProvider_creational.getInstance(context);
  private final CreationalCallback<InitBallotProvider> inj57150_InitBallotProvider_creational = new CreationalCallback<InitBallotProvider>() {
    public InitBallotProvider getInstance(final CreationalContext context) {
      final InitBallotProvider inj57130_InitBallotProvider = new InitBallotProvider();
      context.addBean(context.getBeanReference(InitBallotProvider.class, arrayOf_19635043Annotation_960558090), inj57130_InitBallotProvider);
      return inj57130_InitBallotProvider;
    }
  };
  private final InitBallotProvider inj57130_InitBallotProvider = inj57150_InitBallotProvider_creational.getInstance(context);
  private final CreationalCallback<CallerProvider> inj57151_CallerProvider_creational = new CreationalCallback<CallerProvider>() {
    public CallerProvider getInstance(final CreationalContext context) {
      final CallerProvider inj57134_CallerProvider = new CallerProvider();
      context.addBean(context.getBeanReference(CallerProvider.class, arrayOf_19635043Annotation_960558090), inj57134_CallerProvider);
      return inj57134_CallerProvider;
    }
  };
  private final CallerProvider inj57134_CallerProvider = inj57151_CallerProvider_creational.getInstance(context);
  private final CreationalCallback<RootPanelProvider> inj57152_RootPanelProvider_creational = new CreationalCallback<RootPanelProvider>() {
    public RootPanelProvider getInstance(final CreationalContext context) {
      final RootPanelProvider inj57120_RootPanelProvider = new RootPanelProvider();
      context.addBean(context.getBeanReference(RootPanelProvider.class, arrayOf_19635043Annotation_960558090), inj57120_RootPanelProvider);
      return inj57120_RootPanelProvider;
    }
  };
  private final RootPanelProvider inj57120_RootPanelProvider = inj57152_RootPanelProvider_creational.getInstance(context);
  private final CreationalCallback<ListWidgetProvider> inj57153_ListWidgetProvider_creational = new CreationalCallback<ListWidgetProvider>() {
    public ListWidgetProvider getInstance(final CreationalContext context) {
      final ListWidgetProvider inj57114_ListWidgetProvider = new ListWidgetProvider();
      context.addBean(context.getBeanReference(ListWidgetProvider.class, arrayOf_19635043Annotation_960558090), inj57114_ListWidgetProvider);
      return inj57114_ListWidgetProvider;
    }
  };
  private final ListWidgetProvider inj57114_ListWidgetProvider = inj57153_ListWidgetProvider_creational.getInstance(context);
  private final CreationalCallback<ErraiEntityManagerProvider> inj57154_ErraiEntityManagerProvider_creational = new CreationalCallback<ErraiEntityManagerProvider>() {
    public ErraiEntityManagerProvider getInstance(final CreationalContext context) {
      final ErraiEntityManagerProvider inj57126_ErraiEntityManagerProvider = new ErraiEntityManagerProvider();
      context.addBean(context.getBeanReference(ErraiEntityManagerProvider.class, arrayOf_19635043Annotation_960558090), inj57126_ErraiEntityManagerProvider);
      return inj57126_ErraiEntityManagerProvider;
    }
  };
  private final ErraiEntityManagerProvider inj57126_ErraiEntityManagerProvider = inj57154_ErraiEntityManagerProvider_creational.getInstance(context);
  private final CreationalCallback<DisposerProvider> inj57155_DisposerProvider_creational = new CreationalCallback<DisposerProvider>() {
    public DisposerProvider getInstance(final CreationalContext context) {
      final DisposerProvider inj57136_DisposerProvider = new DisposerProvider();
      context.addBean(context.getBeanReference(DisposerProvider.class, arrayOf_19635043Annotation_960558090), inj57136_DisposerProvider);
      _$1300398733_beanManager(inj57136_DisposerProvider, inj57122_IOCBeanManagerProvider.get());
      return inj57136_DisposerProvider;
    }
  };
  private final DisposerProvider inj57136_DisposerProvider = inj57155_DisposerProvider_creational.getInstance(context);
  public interface com_cosbeni_demo_mobile_UserListTemplateResource extends Template, ClientBundle {
  @Source("com/cosbeni/demo/mobile/UserList.html") public TextResource getContents(); }
  public interface com_cosbeni_demo_mobile_UserFormTemplateResource extends Template, ClientBundle {
  @Source("com/cosbeni/demo/mobile/UserForm.html") public TextResource getContents(); }
  private void declareBeans_0() {
    injContext.addBean(DataBinderProvider.class, DataBinderProvider.class, inj57139_DataBinderProvider_creational, inj57124_DataBinderProvider, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(ContextualTypeProvider.class, DataBinderProvider.class, inj57139_DataBinderProvider_creational, inj57124_DataBinderProvider, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(RequestDispatcherProvider.class, RequestDispatcherProvider.class, inj57140_RequestDispatcherProvider_creational, inj57118_RequestDispatcherProvider, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(Provider.class, RequestDispatcherProvider.class, inj57140_RequestDispatcherProvider_creational, inj57118_RequestDispatcherProvider, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(InstanceProvider.class, InstanceProvider.class, inj57141_InstanceProvider_creational, inj57128_InstanceProvider, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(ContextualTypeProvider.class, InstanceProvider.class, inj57141_InstanceProvider_creational, inj57128_InstanceProvider, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(UserList.class, UserList.class, inj57144_UserList_creational, null, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(Composite.class, UserList.class, inj57144_UserList_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(IsRenderable.class, UserList.class, inj57144_UserList_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(Widget.class, UserList.class, inj57144_UserList_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(EventListener.class, UserList.class, inj57144_UserList_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(HasAttachHandlers.class, UserList.class, inj57144_UserList_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(HasHandlers.class, UserList.class, inj57144_UserList_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(IsWidget.class, UserList.class, inj57144_UserList_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(UIObject.class, UserList.class, inj57144_UserList_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(HasVisibility.class, UserList.class, inj57144_UserList_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(UserForm.class, UserForm.class, inj57145_UserForm_creational, null, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(Composite.class, UserForm.class, inj57145_UserForm_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(IsRenderable.class, UserForm.class, inj57145_UserForm_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(Widget.class, UserForm.class, inj57145_UserForm_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(EventListener.class, UserForm.class, inj57145_UserForm_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(HasAttachHandlers.class, UserForm.class, inj57145_UserForm_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(HasHandlers.class, UserForm.class, inj57145_UserForm_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(IsWidget.class, UserForm.class, inj57145_UserForm_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(UIObject.class, UserForm.class, inj57145_UserForm_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(HasVisibility.class, UserForm.class, inj57145_UserForm_creational, null, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(App.class, App.class, inj57143_App_creational, inj57142_App, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(Composite.class, App.class, inj57143_App_creational, inj57142_App, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(IsRenderable.class, App.class, inj57143_App_creational, inj57142_App, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(Widget.class, App.class, inj57143_App_creational, inj57142_App, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(EventListener.class, App.class, inj57143_App_creational, inj57142_App, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(HasAttachHandlers.class, App.class, inj57143_App_creational, inj57142_App, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(HasHandlers.class, App.class, inj57143_App_creational, inj57142_App, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(IsWidget.class, App.class, inj57143_App_creational, inj57142_App, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(UIObject.class, App.class, inj57143_App_creational, inj57142_App, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(HasVisibility.class, App.class, inj57143_App_creational, inj57142_App, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(EventProvider.class, EventProvider.class, inj57146_EventProvider_creational, inj57132_EventProvider, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(ContextualTypeProvider.class, EventProvider.class, inj57146_EventProvider_creational, inj57132_EventProvider, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(MessageBusProvider.class, MessageBusProvider.class, inj57147_MessageBusProvider_creational, inj57116_MessageBusProvider, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(Provider.class, MessageBusProvider.class, inj57147_MessageBusProvider_creational, inj57116_MessageBusProvider, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(IOCBeanManagerProvider.class, IOCBeanManagerProvider.class, inj57148_IOCBeanManagerProvider_creational, inj57122_IOCBeanManagerProvider, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(Provider.class, IOCBeanManagerProvider.class, inj57148_IOCBeanManagerProvider_creational, inj57122_IOCBeanManagerProvider, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(SenderProvider.class, SenderProvider.class, inj57149_SenderProvider_creational, inj57138_SenderProvider, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(ContextualTypeProvider.class, SenderProvider.class, inj57149_SenderProvider_creational, inj57138_SenderProvider, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(InitBallotProvider.class, InitBallotProvider.class, inj57150_InitBallotProvider_creational, inj57130_InitBallotProvider, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(ContextualTypeProvider.class, InitBallotProvider.class, inj57150_InitBallotProvider_creational, inj57130_InitBallotProvider, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(CallerProvider.class, CallerProvider.class, inj57151_CallerProvider_creational, inj57134_CallerProvider, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(ContextualTypeProvider.class, CallerProvider.class, inj57151_CallerProvider_creational, inj57134_CallerProvider, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(RootPanelProvider.class, RootPanelProvider.class, inj57152_RootPanelProvider_creational, inj57120_RootPanelProvider, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(Provider.class, RootPanelProvider.class, inj57152_RootPanelProvider_creational, inj57120_RootPanelProvider, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(ListWidgetProvider.class, ListWidgetProvider.class, inj57153_ListWidgetProvider_creational, inj57114_ListWidgetProvider, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(ContextualTypeProvider.class, ListWidgetProvider.class, inj57153_ListWidgetProvider_creational, inj57114_ListWidgetProvider, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(ErraiEntityManagerProvider.class, ErraiEntityManagerProvider.class, inj57154_ErraiEntityManagerProvider_creational, inj57126_ErraiEntityManagerProvider, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(Provider.class, ErraiEntityManagerProvider.class, inj57154_ErraiEntityManagerProvider_creational, inj57126_ErraiEntityManagerProvider, arrayOf_19635043Annotation_960558090, null, false);
    injContext.addBean(DisposerProvider.class, DisposerProvider.class, inj57155_DisposerProvider_creational, inj57136_DisposerProvider, arrayOf_19635043Annotation_960558090, null, true);
    injContext.addBean(ContextualTypeProvider.class, DisposerProvider.class, inj57155_DisposerProvider_creational, inj57136_DisposerProvider, arrayOf_19635043Annotation_960558090, null, false);
  }

  private native static void _2007837066_userList(App instance, UserList value) /*-{
    instance.@com.cosbeni.demo.mobile.App::userList = value;
  }-*/;

  private native static void _$1300398733_beanManager(DisposerProvider instance, IOCBeanManager value) /*-{
    instance.@org.jboss.errai.ioc.client.api.builtin.DisposerProvider::beanManager = value;
  }-*/;

  private native static void _2007837066_userForm(App instance, UserForm value) /*-{
    instance.@com.cosbeni.demo.mobile.App::userForm = value;
  }-*/;

  // The main IOC bootstrap method.
  public BootstrapperInjectionContext bootstrapContainer() {
    declareBeans_0();
    return injContext;
  }
}