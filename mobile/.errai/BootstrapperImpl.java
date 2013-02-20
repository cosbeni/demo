package org.jboss.errai.ioc.client;

import com.cosbeni.demo.mobile.App;
import com.cosbeni.demo.mobile.UserForm;
import com.cosbeni.demo.mobile.UserList;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.nav.client.local.PageTransitionProvider;
import org.jboss.errai.ui.shared.ElementWrapperWidget;
import org.jboss.errai.ui.shared.Template;
import org.jboss.errai.ui.shared.TemplateUtil;

public class BootstrapperImpl implements Bootstrapper {
  {
    new CDI().initLookupTable(CDIEventTypeLookup.get());
    new DataBindingModuleBootstrapper().run();
    new JaxrsModuleBootstrapper().run();
  }
  private final Any _1998831462Any_278598817 = new Any() {
    public Class annotationType() {
      return Any.class;
    }
  };
  private final Default _1998831462Default_368514395 = new Default() {
    public Class annotationType() {
      return Default.class;
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1943261299 = new Annotation[] { _1998831462Any_278598817, _1998831462Default_368514395 };
  private final BootstrapperInjectionContext injContext = new BootstrapperInjectionContext();
  private final CreationalContext context = injContext.getRootContext();
  private final CreationalCallback<DataBinderProvider> inj2104_DataBinderProvider_creational = new CreationalCallback<DataBinderProvider>() {
    public DataBinderProvider getInstance(final CreationalContext context) {
      final DataBinderProvider inj2089_DataBinderProvider = new DataBinderProvider();
      context.addBean(context.getBeanReference(DataBinderProvider.class, arrayOf_19635043Annotation_1943261299), inj2089_DataBinderProvider);
      return inj2089_DataBinderProvider;
    }
  };
  private final DataBinderProvider inj2089_DataBinderProvider = inj2104_DataBinderProvider_creational.getInstance(context);
  private final CreationalCallback<RequestDispatcherProvider> inj2105_RequestDispatcherProvider_creational = new CreationalCallback<RequestDispatcherProvider>() {
    public RequestDispatcherProvider getInstance(final CreationalContext context) {
      final RequestDispatcherProvider inj2083_RequestDispatcherProvider = new RequestDispatcherProvider();
      context.addBean(context.getBeanReference(RequestDispatcherProvider.class, arrayOf_19635043Annotation_1943261299), inj2083_RequestDispatcherProvider);
      return inj2083_RequestDispatcherProvider;
    }
  };
  private final RequestDispatcherProvider inj2083_RequestDispatcherProvider = inj2105_RequestDispatcherProvider_creational.getInstance(context);
  private final CreationalCallback<InstanceProvider> inj2106_InstanceProvider_creational = new CreationalCallback<InstanceProvider>() {
    public InstanceProvider getInstance(final CreationalContext context) {
      final InstanceProvider inj2093_InstanceProvider = new InstanceProvider();
      context.addBean(context.getBeanReference(InstanceProvider.class, arrayOf_19635043Annotation_1943261299), inj2093_InstanceProvider);
      return inj2093_InstanceProvider;
    }
  };
  private final InstanceProvider inj2093_InstanceProvider = inj2106_InstanceProvider_creational.getInstance(context);
  private InitializationCallback<Navigation> init_inj2107_Navigation = new InitializationCallback<Navigation>() {
    public void init(final Navigation obj) {
      _136504311_init(obj);
    }
  };
  private final CreationalCallback<Navigation> inj2108_Navigation_creational = new CreationalCallback<Navigation>() {
    public Navigation getInstance(final CreationalContext context) {
      final Navigation inj2107_Navigation = new Navigation();
      context.addBean(context.getBeanReference(Navigation.class, arrayOf_19635043Annotation_1943261299), inj2107_Navigation);
      context.addInitializationCallback(inj2107_Navigation, init_inj2107_Navigation);
      return inj2107_Navigation;
    }
  };
  private final Navigation inj2107_Navigation = inj2108_Navigation_creational.getInstance(context);
  private final CreationalCallback<UserList> inj2111_UserList_creational = new CreationalCallback<UserList>() {
    public UserList getInstance(final CreationalContext context) {
      final UserList inj1906_UserList = new UserList();
      context.addBean(context.getBeanReference(UserList.class, arrayOf_19635043Annotation_1943261299), inj1906_UserList);
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          inj1906_UserList.init();
        }
      });
      context.addInitializationCallback(inj1906_UserList, new InitializationCallback<UserList>() {
        public void init(UserList obj) {
          com_cosbeni_demo_mobile_UserListTemplateResource var1 = GWT.create(com_cosbeni_demo_mobile_UserListTemplateResource.class);
          Element var2 = TemplateUtil.getRootTemplateElement(var1.getContents().getText(), "UserList");
          Map<String, Element> var3 = TemplateUtil.getDataFieldElements(var2);
          Map<String, Widget> var4 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.UserList", "com/cosbeni/demo/mobile/UserList.html", new ElementWrapperWidget(_$560939712_test(inj1906_UserList)), var3, "test");
          var4.put("test", new ElementWrapperWidget(_$560939712_test(inj1906_UserList)));
          TemplateUtil.initWidget(inj1906_UserList, var2, var4.values());
          TemplateUtil.setupWrappedElementEventHandler(inj1906_UserList, var4.get("test"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj1906_UserList.test(event);
            }
          }, ClickEvent.getType());
        }
      });
      return inj1906_UserList;
    }
  };
  private final CreationalCallback<UserForm> inj2112_UserForm_creational = new CreationalCallback<UserForm>() {
    public UserForm getInstance(final CreationalContext context) {
      final UserForm inj1905_UserForm = new UserForm();
      context.addBean(context.getBeanReference(UserForm.class, arrayOf_19635043Annotation_1943261299), inj1905_UserForm);
      context.addInitializationCallback(inj1905_UserForm, new InitializationCallback<UserForm>() {
        public void init(UserForm obj) {
          com_cosbeni_demo_mobile_UserFormTemplateResource var5 = GWT.create(com_cosbeni_demo_mobile_UserFormTemplateResource.class);
          Element var6 = TemplateUtil.getRootTemplateElement(var5.getContents().getText(), "UserForm");
          Map<String, Element> var7 = TemplateUtil.getDataFieldElements(var6);
          Map<String, Widget> var8 = new LinkedHashMap<String, Widget>();
          TemplateUtil.initWidget(inj1905_UserForm, var6, var8.values());
        }
      });
      return inj1905_UserForm;
    }
  };
  private InitializationCallback<App> init_inj2109_App = new InitializationCallback<App>() {
    public void init(final App obj) {
      obj.init();
    }
  };
  private final CreationalCallback<App> inj2110_App_creational = new CreationalCallback<App>() {
    public App getInstance(final CreationalContext context) {
      final App inj2109_App = new App();
      context.addBean(context.getBeanReference(App.class, arrayOf_19635043Annotation_1943261299), inj2109_App);
      _2007837066_navigation(inj2109_App, inj2107_Navigation);
      _2007837066_userList(inj2109_App, inj2111_UserList_creational.getInstance(context));
      _2007837066_userForm(inj2109_App, inj2112_UserForm_creational.getInstance(context));
      context.addInitializationCallback(inj2109_App, init_inj2109_App);
      return inj2109_App;
    }
  };
  private final App inj2109_App = inj2110_App_creational.getInstance(context);
  private final CreationalCallback<EventProvider> inj2113_EventProvider_creational = new CreationalCallback<EventProvider>() {
    public EventProvider getInstance(final CreationalContext context) {
      final EventProvider inj2097_EventProvider = new EventProvider();
      context.addBean(context.getBeanReference(EventProvider.class, arrayOf_19635043Annotation_1943261299), inj2097_EventProvider);
      return inj2097_EventProvider;
    }
  };
  private final EventProvider inj2097_EventProvider = inj2113_EventProvider_creational.getInstance(context);
  private final CreationalCallback<MessageBusProvider> inj2114_MessageBusProvider_creational = new CreationalCallback<MessageBusProvider>() {
    public MessageBusProvider getInstance(final CreationalContext context) {
      final MessageBusProvider inj2081_MessageBusProvider = new MessageBusProvider();
      context.addBean(context.getBeanReference(MessageBusProvider.class, arrayOf_19635043Annotation_1943261299), inj2081_MessageBusProvider);
      return inj2081_MessageBusProvider;
    }
  };
  private final MessageBusProvider inj2081_MessageBusProvider = inj2114_MessageBusProvider_creational.getInstance(context);
  private final CreationalCallback<IOCBeanManagerProvider> inj2115_IOCBeanManagerProvider_creational = new CreationalCallback<IOCBeanManagerProvider>() {
    public IOCBeanManagerProvider getInstance(final CreationalContext context) {
      final IOCBeanManagerProvider inj2087_IOCBeanManagerProvider = new IOCBeanManagerProvider();
      context.addBean(context.getBeanReference(IOCBeanManagerProvider.class, arrayOf_19635043Annotation_1943261299), inj2087_IOCBeanManagerProvider);
      return inj2087_IOCBeanManagerProvider;
    }
  };
  private final IOCBeanManagerProvider inj2087_IOCBeanManagerProvider = inj2115_IOCBeanManagerProvider_creational.getInstance(context);
  private final CreationalCallback<SenderProvider> inj2116_SenderProvider_creational = new CreationalCallback<SenderProvider>() {
    public SenderProvider getInstance(final CreationalContext context) {
      final SenderProvider inj2103_SenderProvider = new SenderProvider();
      context.addBean(context.getBeanReference(SenderProvider.class, arrayOf_19635043Annotation_1943261299), inj2103_SenderProvider);
      return inj2103_SenderProvider;
    }
  };
  private final SenderProvider inj2103_SenderProvider = inj2116_SenderProvider_creational.getInstance(context);
  private final CreationalCallback<InitBallotProvider> inj2117_InitBallotProvider_creational = new CreationalCallback<InitBallotProvider>() {
    public InitBallotProvider getInstance(final CreationalContext context) {
      final InitBallotProvider inj2095_InitBallotProvider = new InitBallotProvider();
      context.addBean(context.getBeanReference(InitBallotProvider.class, arrayOf_19635043Annotation_1943261299), inj2095_InitBallotProvider);
      return inj2095_InitBallotProvider;
    }
  };
  private final InitBallotProvider inj2095_InitBallotProvider = inj2117_InitBallotProvider_creational.getInstance(context);
  private final CreationalCallback<CallerProvider> inj2118_CallerProvider_creational = new CreationalCallback<CallerProvider>() {
    public CallerProvider getInstance(final CreationalContext context) {
      final CallerProvider inj2099_CallerProvider = new CallerProvider();
      context.addBean(context.getBeanReference(CallerProvider.class, arrayOf_19635043Annotation_1943261299), inj2099_CallerProvider);
      return inj2099_CallerProvider;
    }
  };
  private final CallerProvider inj2099_CallerProvider = inj2118_CallerProvider_creational.getInstance(context);
  private final CreationalCallback<PageTransitionProvider> inj2119_PageTransitionProvider_creational = new CreationalCallback<PageTransitionProvider>() {
    public PageTransitionProvider getInstance(final CreationalContext context) {
      final PageTransitionProvider inj2079_PageTransitionProvider = new PageTransitionProvider();
      context.addBean(context.getBeanReference(PageTransitionProvider.class, arrayOf_19635043Annotation_1943261299), inj2079_PageTransitionProvider);
      _395577528_navigation(inj2079_PageTransitionProvider, inj2107_Navigation);
      return inj2079_PageTransitionProvider;
    }
  };
  private final PageTransitionProvider inj2079_PageTransitionProvider = inj2119_PageTransitionProvider_creational.getInstance(context);
  private final CreationalCallback<RootPanelProvider> inj2120_RootPanelProvider_creational = new CreationalCallback<RootPanelProvider>() {
    public RootPanelProvider getInstance(final CreationalContext context) {
      final RootPanelProvider inj2085_RootPanelProvider = new RootPanelProvider();
      context.addBean(context.getBeanReference(RootPanelProvider.class, arrayOf_19635043Annotation_1943261299), inj2085_RootPanelProvider);
      return inj2085_RootPanelProvider;
    }
  };
  private final RootPanelProvider inj2085_RootPanelProvider = inj2120_RootPanelProvider_creational.getInstance(context);
  private final CreationalCallback<ListWidgetProvider> inj2121_ListWidgetProvider_creational = new CreationalCallback<ListWidgetProvider>() {
    public ListWidgetProvider getInstance(final CreationalContext context) {
      final ListWidgetProvider inj2077_ListWidgetProvider = new ListWidgetProvider();
      context.addBean(context.getBeanReference(ListWidgetProvider.class, arrayOf_19635043Annotation_1943261299), inj2077_ListWidgetProvider);
      return inj2077_ListWidgetProvider;
    }
  };
  private final ListWidgetProvider inj2077_ListWidgetProvider = inj2121_ListWidgetProvider_creational.getInstance(context);
  private final CreationalCallback<ErraiEntityManagerProvider> inj2122_ErraiEntityManagerProvider_creational = new CreationalCallback<ErraiEntityManagerProvider>() {
    public ErraiEntityManagerProvider getInstance(final CreationalContext context) {
      final ErraiEntityManagerProvider inj2091_ErraiEntityManagerProvider = new ErraiEntityManagerProvider();
      context.addBean(context.getBeanReference(ErraiEntityManagerProvider.class, arrayOf_19635043Annotation_1943261299), inj2091_ErraiEntityManagerProvider);
      return inj2091_ErraiEntityManagerProvider;
    }
  };
  private final ErraiEntityManagerProvider inj2091_ErraiEntityManagerProvider = inj2122_ErraiEntityManagerProvider_creational.getInstance(context);
  private final CreationalCallback<DisposerProvider> inj2123_DisposerProvider_creational = new CreationalCallback<DisposerProvider>() {
    public DisposerProvider getInstance(final CreationalContext context) {
      final DisposerProvider inj2101_DisposerProvider = new DisposerProvider();
      context.addBean(context.getBeanReference(DisposerProvider.class, arrayOf_19635043Annotation_1943261299), inj2101_DisposerProvider);
      _$1300398733_beanManager(inj2101_DisposerProvider, inj2087_IOCBeanManagerProvider.get());
      return inj2101_DisposerProvider;
    }
  };
  private final DisposerProvider inj2101_DisposerProvider = inj2123_DisposerProvider_creational.getInstance(context);
  public interface com_cosbeni_demo_mobile_UserListTemplateResource extends Template, ClientBundle {
  @Source("com/cosbeni/demo/mobile/UserList.html") public TextResource getContents(); }
  public interface com_cosbeni_demo_mobile_UserFormTemplateResource extends Template, ClientBundle {
  @Source("com/cosbeni/demo/mobile/UserForm.html") public TextResource getContents(); }
  private void declareBeans_0() {
    injContext.addBean(DataBinderProvider.class, DataBinderProvider.class, inj2104_DataBinderProvider_creational, inj2089_DataBinderProvider, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(ContextualTypeProvider.class, DataBinderProvider.class, inj2104_DataBinderProvider_creational, inj2089_DataBinderProvider, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(RequestDispatcherProvider.class, RequestDispatcherProvider.class, inj2105_RequestDispatcherProvider_creational, inj2083_RequestDispatcherProvider, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(Provider.class, RequestDispatcherProvider.class, inj2105_RequestDispatcherProvider_creational, inj2083_RequestDispatcherProvider, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(InstanceProvider.class, InstanceProvider.class, inj2106_InstanceProvider_creational, inj2093_InstanceProvider, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(ContextualTypeProvider.class, InstanceProvider.class, inj2106_InstanceProvider_creational, inj2093_InstanceProvider, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(Navigation.class, Navigation.class, inj2108_Navigation_creational, inj2107_Navigation, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(UserList.class, UserList.class, inj2111_UserList_creational, null, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(Composite.class, UserList.class, inj2111_UserList_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(IsRenderable.class, UserList.class, inj2111_UserList_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(Widget.class, UserList.class, inj2111_UserList_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(EventListener.class, UserList.class, inj2111_UserList_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(HasAttachHandlers.class, UserList.class, inj2111_UserList_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(HasHandlers.class, UserList.class, inj2111_UserList_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(IsWidget.class, UserList.class, inj2111_UserList_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(UIObject.class, UserList.class, inj2111_UserList_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(HasVisibility.class, UserList.class, inj2111_UserList_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(UserForm.class, UserForm.class, inj2112_UserForm_creational, null, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(Composite.class, UserForm.class, inj2112_UserForm_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(IsRenderable.class, UserForm.class, inj2112_UserForm_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(Widget.class, UserForm.class, inj2112_UserForm_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(EventListener.class, UserForm.class, inj2112_UserForm_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(HasAttachHandlers.class, UserForm.class, inj2112_UserForm_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(HasHandlers.class, UserForm.class, inj2112_UserForm_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(IsWidget.class, UserForm.class, inj2112_UserForm_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(UIObject.class, UserForm.class, inj2112_UserForm_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(HasVisibility.class, UserForm.class, inj2112_UserForm_creational, null, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(App.class, App.class, inj2110_App_creational, inj2109_App, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(Composite.class, App.class, inj2110_App_creational, inj2109_App, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(IsRenderable.class, App.class, inj2110_App_creational, inj2109_App, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(Widget.class, App.class, inj2110_App_creational, inj2109_App, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(EventListener.class, App.class, inj2110_App_creational, inj2109_App, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(HasAttachHandlers.class, App.class, inj2110_App_creational, inj2109_App, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(HasHandlers.class, App.class, inj2110_App_creational, inj2109_App, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(IsWidget.class, App.class, inj2110_App_creational, inj2109_App, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(UIObject.class, App.class, inj2110_App_creational, inj2109_App, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(HasVisibility.class, App.class, inj2110_App_creational, inj2109_App, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(EventProvider.class, EventProvider.class, inj2113_EventProvider_creational, inj2097_EventProvider, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(ContextualTypeProvider.class, EventProvider.class, inj2113_EventProvider_creational, inj2097_EventProvider, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(MessageBusProvider.class, MessageBusProvider.class, inj2114_MessageBusProvider_creational, inj2081_MessageBusProvider, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(Provider.class, MessageBusProvider.class, inj2114_MessageBusProvider_creational, inj2081_MessageBusProvider, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(IOCBeanManagerProvider.class, IOCBeanManagerProvider.class, inj2115_IOCBeanManagerProvider_creational, inj2087_IOCBeanManagerProvider, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(Provider.class, IOCBeanManagerProvider.class, inj2115_IOCBeanManagerProvider_creational, inj2087_IOCBeanManagerProvider, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(SenderProvider.class, SenderProvider.class, inj2116_SenderProvider_creational, inj2103_SenderProvider, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(ContextualTypeProvider.class, SenderProvider.class, inj2116_SenderProvider_creational, inj2103_SenderProvider, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(InitBallotProvider.class, InitBallotProvider.class, inj2117_InitBallotProvider_creational, inj2095_InitBallotProvider, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(ContextualTypeProvider.class, InitBallotProvider.class, inj2117_InitBallotProvider_creational, inj2095_InitBallotProvider, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(CallerProvider.class, CallerProvider.class, inj2118_CallerProvider_creational, inj2099_CallerProvider, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(ContextualTypeProvider.class, CallerProvider.class, inj2118_CallerProvider_creational, inj2099_CallerProvider, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(PageTransitionProvider.class, PageTransitionProvider.class, inj2119_PageTransitionProvider_creational, inj2079_PageTransitionProvider, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(ContextualTypeProvider.class, PageTransitionProvider.class, inj2119_PageTransitionProvider_creational, inj2079_PageTransitionProvider, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(RootPanelProvider.class, RootPanelProvider.class, inj2120_RootPanelProvider_creational, inj2085_RootPanelProvider, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(Provider.class, RootPanelProvider.class, inj2120_RootPanelProvider_creational, inj2085_RootPanelProvider, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(ListWidgetProvider.class, ListWidgetProvider.class, inj2121_ListWidgetProvider_creational, inj2077_ListWidgetProvider, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(ContextualTypeProvider.class, ListWidgetProvider.class, inj2121_ListWidgetProvider_creational, inj2077_ListWidgetProvider, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(ErraiEntityManagerProvider.class, ErraiEntityManagerProvider.class, inj2122_ErraiEntityManagerProvider_creational, inj2091_ErraiEntityManagerProvider, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(Provider.class, ErraiEntityManagerProvider.class, inj2122_ErraiEntityManagerProvider_creational, inj2091_ErraiEntityManagerProvider, arrayOf_19635043Annotation_1943261299, null, false);
    injContext.addBean(DisposerProvider.class, DisposerProvider.class, inj2123_DisposerProvider_creational, inj2101_DisposerProvider, arrayOf_19635043Annotation_1943261299, null, true);
    injContext.addBean(ContextualTypeProvider.class, DisposerProvider.class, inj2123_DisposerProvider_creational, inj2101_DisposerProvider, arrayOf_19635043Annotation_1943261299, null, false);
  }

  private native static void _2007837066_userList(App instance, UserList value) /*-{
    instance.@com.cosbeni.demo.mobile.App::userList = value;
  }-*/;

  private native static void _$1300398733_beanManager(DisposerProvider instance, IOCBeanManager value) /*-{
    instance.@org.jboss.errai.ioc.client.api.builtin.DisposerProvider::beanManager = value;
  }-*/;

  private native static AnchorElement _$560939712_test(UserList instance) /*-{
    return instance.@com.cosbeni.demo.mobile.UserList::test;
  }-*/;

  private native static void _$560939712_test(UserList instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.mobile.UserList::test = value;
  }-*/;

  private native static void _395577528_navigation(PageTransitionProvider instance, Navigation value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.PageTransitionProvider::navigation = value;
  }-*/;

  private native static void _2007837066_userForm(App instance, UserForm value) /*-{
    instance.@com.cosbeni.demo.mobile.App::userForm = value;
  }-*/;

  private native static void _2007837066_navigation(App instance, Navigation value) /*-{
    instance.@com.cosbeni.demo.mobile.App::navigation = value;
  }-*/;

  public native static void _136504311_init(Navigation instance) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.Navigation::init()();
  }-*/;

  // The main IOC bootstrap method.
  public BootstrapperInjectionContext bootstrapContainer() {
    declareBeans_0();
    return injContext;
  }
}