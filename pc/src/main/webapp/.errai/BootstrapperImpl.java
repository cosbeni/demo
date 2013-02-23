package org.jboss.errai.ioc.client;

import com.cosbeni.demo.client.local.App;
import com.cosbeni.demo.client.local.DashBoard;
import com.cosbeni.demo.client.local.GroupManagement;
import com.cosbeni.demo.client.local.Language;
import com.cosbeni.demo.client.local.Menu;
import com.cosbeni.demo.client.local.UserManagement;
import com.cosbeni.demo.shared.service.GroupService;
import com.cosbeni.demo.shared.service.UserService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasAllDragAndDropHandlers;
import com.google.gwt.event.dom.client.HasAllFocusHandlers;
import com.google.gwt.event.dom.client.HasAllGestureHandlers;
import com.google.gwt.event.dom.client.HasAllKeyHandlers;
import com.google.gwt.event.dom.client.HasAllMouseHandlers;
import com.google.gwt.event.dom.client.HasAllTouchHandlers;
import com.google.gwt.event.dom.client.HasBlurHandlers;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasDoubleClickHandlers;
import com.google.gwt.event.dom.client.HasDragEndHandlers;
import com.google.gwt.event.dom.client.HasDragEnterHandlers;
import com.google.gwt.event.dom.client.HasDragHandlers;
import com.google.gwt.event.dom.client.HasDragLeaveHandlers;
import com.google.gwt.event.dom.client.HasDragOverHandlers;
import com.google.gwt.event.dom.client.HasDragStartHandlers;
import com.google.gwt.event.dom.client.HasDropHandlers;
import com.google.gwt.event.dom.client.HasFocusHandlers;
import com.google.gwt.event.dom.client.HasGestureChangeHandlers;
import com.google.gwt.event.dom.client.HasGestureEndHandlers;
import com.google.gwt.event.dom.client.HasGestureStartHandlers;
import com.google.gwt.event.dom.client.HasKeyDownHandlers;
import com.google.gwt.event.dom.client.HasKeyPressHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.event.dom.client.HasMouseDownHandlers;
import com.google.gwt.event.dom.client.HasMouseMoveHandlers;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.HasMouseUpHandlers;
import com.google.gwt.event.dom.client.HasMouseWheelHandlers;
import com.google.gwt.event.dom.client.HasTouchCancelHandlers;
import com.google.gwt.event.dom.client.HasTouchEndHandlers;
import com.google.gwt.event.dom.client.HasTouchMoveHandlers;
import com.google.gwt.event.dom.client.HasTouchStartHandlers;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.HasAttachHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.i18n.client.AutoDirectionHandler.Target;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.i18n.shared.HasDirectionEstimator;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.client.HasSafeHtml;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ButtonBase;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasAutoHorizontalAlignment;
import com.google.gwt.user.client.ui.HasDirectionalText;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasFocus;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.HasWordWrap;
import com.google.gwt.user.client.ui.IsRenderable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LabelBase;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SourcesChangeEvents;
import com.google.gwt.user.client.ui.SourcesClickEvents;
import com.google.gwt.user.client.ui.SourcesFocusEvents;
import com.google.gwt.user.client.ui.SourcesKeyboardEvents;
import com.google.gwt.user.client.ui.SourcesMouseEvents;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.ValueBoxBase;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.widgets.grid.ListGrid;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import org.jboss.errai.databinding.client.DataBinderProvider;
import org.jboss.errai.databinding.client.DataBindingModuleBootstrapper;
import org.jboss.errai.enterprise.client.cdi.CDIEventTypeLookup;
import org.jboss.errai.enterprise.client.cdi.EventProvider;
import org.jboss.errai.enterprise.client.cdi.InstanceProvider;
import org.jboss.errai.enterprise.client.cdi.api.CDI;
import org.jboss.errai.enterprise.client.jaxrs.JaxrsModuleBootstrapper;
import org.jboss.errai.ioc.client.api.Caller;
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
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.ElementWrapperWidget;
import org.jboss.errai.ui.shared.Template;
import org.jboss.errai.ui.shared.TemplateUtil;

public class BootstrapperImpl implements Bootstrapper {
  {
    new CDI().initLookupTable(CDIEventTypeLookup.get());
    new DataBindingModuleBootstrapper().run();
    new JaxrsModuleBootstrapper().run();
  }
  private final Any _1998831462Any_2010710784 = new Any() {
    public Class annotationType() {
      return Any.class;
    }
  };
  private final Default _1998831462Default_1542341782 = new Default() {
    public Class annotationType() {
      return Default.class;
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_418727585 = new Annotation[] { _1998831462Any_2010710784, _1998831462Default_1542341782 };
  private final BootstrapperInjectionContext injContext = new BootstrapperInjectionContext();
  private final CreationalContext context = injContext.getRootContext();
  private final CreationalCallback<DataBinderProvider> inj73305_DataBinderProvider_creational = new CreationalCallback<DataBinderProvider>() {
    public DataBinderProvider getInstance(final CreationalContext context) {
      final DataBinderProvider inj73292_DataBinderProvider = new DataBinderProvider();
      context.addBean(context.getBeanReference(DataBinderProvider.class, arrayOf_19635043Annotation_418727585), inj73292_DataBinderProvider);
      return inj73292_DataBinderProvider;
    }
  };
  private final DataBinderProvider inj73292_DataBinderProvider = inj73305_DataBinderProvider_creational.getInstance(context);
  private final CreationalCallback<RequestDispatcherProvider> inj73306_RequestDispatcherProvider_creational = new CreationalCallback<RequestDispatcherProvider>() {
    public RequestDispatcherProvider getInstance(final CreationalContext context) {
      final RequestDispatcherProvider inj73284_RequestDispatcherProvider = new RequestDispatcherProvider();
      context.addBean(context.getBeanReference(RequestDispatcherProvider.class, arrayOf_19635043Annotation_418727585), inj73284_RequestDispatcherProvider);
      return inj73284_RequestDispatcherProvider;
    }
  };
  private final RequestDispatcherProvider inj73284_RequestDispatcherProvider = inj73306_RequestDispatcherProvider_creational.getInstance(context);
  private final CreationalCallback<InstanceProvider> inj73307_InstanceProvider_creational = new CreationalCallback<InstanceProvider>() {
    public InstanceProvider getInstance(final CreationalContext context) {
      final InstanceProvider inj73294_InstanceProvider = new InstanceProvider();
      context.addBean(context.getBeanReference(InstanceProvider.class, arrayOf_19635043Annotation_418727585), inj73294_InstanceProvider);
      return inj73294_InstanceProvider;
    }
  };
  private final InstanceProvider inj73294_InstanceProvider = inj73307_InstanceProvider_creational.getInstance(context);
  private final CreationalCallback<EventProvider> inj73308_EventProvider_creational = new CreationalCallback<EventProvider>() {
    public EventProvider getInstance(final CreationalContext context) {
      final EventProvider inj73298_EventProvider = new EventProvider();
      context.addBean(context.getBeanReference(EventProvider.class, arrayOf_19635043Annotation_418727585), inj73298_EventProvider);
      return inj73298_EventProvider;
    }
  };
  private final EventProvider inj73298_EventProvider = inj73308_EventProvider_creational.getInstance(context);
  private InitializationCallback<Navigation> init_inj73309_Navigation = new InitializationCallback<Navigation>() {
    public void init(final Navigation obj) {
      _136504311_init(obj);
    }
  };
  private final CreationalCallback<Navigation> inj73310_Navigation_creational = new CreationalCallback<Navigation>() {
    public Navigation getInstance(final CreationalContext context) {
      final Navigation inj73309_Navigation = new Navigation();
      context.addBean(context.getBeanReference(Navigation.class, arrayOf_19635043Annotation_418727585), inj73309_Navigation);
      context.addInitializationCallback(inj73309_Navigation, init_inj73309_Navigation);
      return inj73309_Navigation;
    }
  };
  private final Navigation inj73309_Navigation = inj73310_Navigation_creational.getInstance(context);
  private final CreationalCallback<MessageBusProvider> inj73311_MessageBusProvider_creational = new CreationalCallback<MessageBusProvider>() {
    public MessageBusProvider getInstance(final CreationalContext context) {
      final MessageBusProvider inj73282_MessageBusProvider = new MessageBusProvider();
      context.addBean(context.getBeanReference(MessageBusProvider.class, arrayOf_19635043Annotation_418727585), inj73282_MessageBusProvider);
      return inj73282_MessageBusProvider;
    }
  };
  private final MessageBusProvider inj73282_MessageBusProvider = inj73311_MessageBusProvider_creational.getInstance(context);
  private final CreationalCallback<IOCBeanManagerProvider> inj73312_IOCBeanManagerProvider_creational = new CreationalCallback<IOCBeanManagerProvider>() {
    public IOCBeanManagerProvider getInstance(final CreationalContext context) {
      final IOCBeanManagerProvider inj73288_IOCBeanManagerProvider = new IOCBeanManagerProvider();
      context.addBean(context.getBeanReference(IOCBeanManagerProvider.class, arrayOf_19635043Annotation_418727585), inj73288_IOCBeanManagerProvider);
      return inj73288_IOCBeanManagerProvider;
    }
  };
  private final IOCBeanManagerProvider inj73288_IOCBeanManagerProvider = inj73312_IOCBeanManagerProvider_creational.getInstance(context);
  private final CreationalCallback<SenderProvider> inj73313_SenderProvider_creational = new CreationalCallback<SenderProvider>() {
    public SenderProvider getInstance(final CreationalContext context) {
      final SenderProvider inj73304_SenderProvider = new SenderProvider();
      context.addBean(context.getBeanReference(SenderProvider.class, arrayOf_19635043Annotation_418727585), inj73304_SenderProvider);
      return inj73304_SenderProvider;
    }
  };
  private final SenderProvider inj73304_SenderProvider = inj73313_SenderProvider_creational.getInstance(context);
  private final CreationalCallback<InitBallotProvider> inj73314_InitBallotProvider_creational = new CreationalCallback<InitBallotProvider>() {
    public InitBallotProvider getInstance(final CreationalContext context) {
      final InitBallotProvider inj73296_InitBallotProvider = new InitBallotProvider();
      context.addBean(context.getBeanReference(InitBallotProvider.class, arrayOf_19635043Annotation_418727585), inj73296_InitBallotProvider);
      return inj73296_InitBallotProvider;
    }
  };
  private final InitBallotProvider inj73296_InitBallotProvider = inj73314_InitBallotProvider_creational.getInstance(context);
  private final CreationalCallback<CallerProvider> inj73315_CallerProvider_creational = new CreationalCallback<CallerProvider>() {
    public CallerProvider getInstance(final CreationalContext context) {
      final CallerProvider inj73300_CallerProvider = new CallerProvider();
      context.addBean(context.getBeanReference(CallerProvider.class, arrayOf_19635043Annotation_418727585), inj73300_CallerProvider);
      return inj73300_CallerProvider;
    }
  };
  private final CallerProvider inj73300_CallerProvider = inj73315_CallerProvider_creational.getInstance(context);
  private final CreationalCallback<PageTransitionProvider> inj73316_PageTransitionProvider_creational = new CreationalCallback<PageTransitionProvider>() {
    public PageTransitionProvider getInstance(final CreationalContext context) {
      final PageTransitionProvider inj73280_PageTransitionProvider = new PageTransitionProvider();
      context.addBean(context.getBeanReference(PageTransitionProvider.class, arrayOf_19635043Annotation_418727585), inj73280_PageTransitionProvider);
      _395577528_navigation(inj73280_PageTransitionProvider, inj73309_Navigation);
      return inj73280_PageTransitionProvider;
    }
  };
  private final PageTransitionProvider inj73280_PageTransitionProvider = inj73316_PageTransitionProvider_creational.getInstance(context);
  private final CreationalCallback<RootPanelProvider> inj73317_RootPanelProvider_creational = new CreationalCallback<RootPanelProvider>() {
    public RootPanelProvider getInstance(final CreationalContext context) {
      final RootPanelProvider inj73286_RootPanelProvider = new RootPanelProvider();
      context.addBean(context.getBeanReference(RootPanelProvider.class, arrayOf_19635043Annotation_418727585), inj73286_RootPanelProvider);
      return inj73286_RootPanelProvider;
    }
  };
  private final RootPanelProvider inj73286_RootPanelProvider = inj73317_RootPanelProvider_creational.getInstance(context);
  private final CreationalCallback<ListWidgetProvider> inj73318_ListWidgetProvider_creational = new CreationalCallback<ListWidgetProvider>() {
    public ListWidgetProvider getInstance(final CreationalContext context) {
      final ListWidgetProvider inj73278_ListWidgetProvider = new ListWidgetProvider();
      context.addBean(context.getBeanReference(ListWidgetProvider.class, arrayOf_19635043Annotation_418727585), inj73278_ListWidgetProvider);
      return inj73278_ListWidgetProvider;
    }
  };
  private final ListWidgetProvider inj73278_ListWidgetProvider = inj73318_ListWidgetProvider_creational.getInstance(context);
  private final CreationalCallback<ErraiEntityManagerProvider> inj73319_ErraiEntityManagerProvider_creational = new CreationalCallback<ErraiEntityManagerProvider>() {
    public ErraiEntityManagerProvider getInstance(final CreationalContext context) {
      final ErraiEntityManagerProvider inj73290_ErraiEntityManagerProvider = new ErraiEntityManagerProvider();
      context.addBean(context.getBeanReference(ErraiEntityManagerProvider.class, arrayOf_19635043Annotation_418727585), inj73290_ErraiEntityManagerProvider);
      return inj73290_ErraiEntityManagerProvider;
    }
  };
  private final ErraiEntityManagerProvider inj73290_ErraiEntityManagerProvider = inj73319_ErraiEntityManagerProvider_creational.getInstance(context);
  private final CreationalCallback<DisposerProvider> inj73320_DisposerProvider_creational = new CreationalCallback<DisposerProvider>() {
    public DisposerProvider getInstance(final CreationalContext context) {
      final DisposerProvider inj73302_DisposerProvider = new DisposerProvider();
      context.addBean(context.getBeanReference(DisposerProvider.class, arrayOf_19635043Annotation_418727585), inj73302_DisposerProvider);
      _$1300398733_beanManager(inj73302_DisposerProvider, inj73288_IOCBeanManagerProvider.get());
      return inj73302_DisposerProvider;
    }
  };
  private final DisposerProvider inj73302_DisposerProvider = inj73320_DisposerProvider_creational.getInstance(context);
  private InitializationCallback<DashBoard> init_inj71153_DashBoard = new InitializationCallback<DashBoard>() {
    public void init(final DashBoard obj) {
      obj.init();
    }
  };
  private final CreationalCallback<DashBoard> inj73323_DashBoard_creational = new CreationalCallback<DashBoard>() {
    public DashBoard getInstance(final CreationalContext context) {
      final DashBoard inj71153_DashBoard = new DashBoard();
      context.addBean(context.getBeanReference(DashBoard.class, arrayOf_19635043Annotation_418727585), inj71153_DashBoard);
      context.addInitializationCallback(inj71153_DashBoard, new InitializationCallback<DashBoard>() {
        public void init(DashBoard obj) {
          com_cosbeni_demo_client_local_DashBoardTemplateResource var541 = GWT.create(com_cosbeni_demo_client_local_DashBoardTemplateResource.class);
          Element var542 = TemplateUtil.getRootTemplateElement(var541.getContents().getText(), "DashBoard");
          Map<String, Element> var543 = TemplateUtil.getDataFieldElements(var542);
          Map<String, Widget> var544 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.DashBoard", "com/cosbeni/demo/client/local/DashBoard.html", new ElementWrapperWidget(_$700623165_language(inj71153_DashBoard)), var543, "language");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.DashBoard", "com/cosbeni/demo/client/local/DashBoard.html", new ElementWrapperWidget(_$700623165_menu(inj71153_DashBoard)), var543, "menu");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.DashBoard", "com/cosbeni/demo/client/local/DashBoard.html", new ElementWrapperWidget(_$700623165_main(inj71153_DashBoard)), var543, "main");
          var544.put("language", new ElementWrapperWidget(_$700623165_language(inj71153_DashBoard)));
          var544.put("menu", new ElementWrapperWidget(_$700623165_menu(inj71153_DashBoard)));
          var544.put("main", new ElementWrapperWidget(_$700623165_main(inj71153_DashBoard)));
          TemplateUtil.initWidget(inj71153_DashBoard, var542, var544.values());
          TemplateUtil.setupWrappedElementEventHandler(inj71153_DashBoard, var544.get("language"), new MouseOverHandler() {
            public void onMouseOver(MouseOverEvent event) {
              inj71153_DashBoard.language(event);
            }
          }, MouseOverEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj71153_DashBoard, var544.get("language"), new MouseOutHandler() {
            public void onMouseOut(MouseOutEvent event) {
              inj71153_DashBoard.language(event);
            }
          }, MouseOutEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj71153_DashBoard, var544.get("menu"), new MouseOverHandler() {
            public void onMouseOver(MouseOverEvent event) {
              inj71153_DashBoard.menu(event);
            }
          }, MouseOverEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj71153_DashBoard, var544.get("menu"), new MouseOutHandler() {
            public void onMouseOut(MouseOutEvent event) {
              inj71153_DashBoard.menu(event);
            }
          }, MouseOutEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj71153_DashBoard, var544.get("main"), new MouseOverHandler() {
            public void onMouseOver(MouseOverEvent event) {
              inj71153_DashBoard.main(event);
            }
          }, MouseOverEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj71153_DashBoard, var544.get("main"), new MouseOutHandler() {
            public void onMouseOut(MouseOutEvent event) {
              inj71153_DashBoard.main(event);
            }
          }, MouseOutEvent.getType());
        }
      });
      context.addInitializationCallback(inj71153_DashBoard, init_inj71153_DashBoard);
      return inj71153_DashBoard;
    }
  };
  private final CreationalCallback<Label> inj73325_Label_creational = new CreationalCallback<Label>() {
    public Label getInstance(final CreationalContext context) {
      final Label inj72922_Label = new Label();
      context.addBean(context.getBeanReference(Label.class, arrayOf_19635043Annotation_418727585), inj72922_Label);
      return inj72922_Label;
    }
  };
  private final CreationalCallback<TextBox> inj73326_TextBox_creational = new CreationalCallback<TextBox>() {
    public TextBox getInstance(final CreationalContext context) {
      final TextBox inj72844_TextBox = new TextBox();
      context.addBean(context.getBeanReference(TextBox.class, arrayOf_19635043Annotation_418727585), inj72844_TextBox);
      return inj72844_TextBox;
    }
  };
  private final CreationalCallback<ListBox> inj73327_ListBox_creational = new CreationalCallback<ListBox>() {
    public ListBox getInstance(final CreationalContext context) {
      final ListBox inj72877_ListBox = new ListBox();
      context.addBean(context.getBeanReference(ListBox.class, arrayOf_19635043Annotation_418727585), inj72877_ListBox);
      return inj72877_ListBox;
    }
  };
  private final CreationalCallback<Button> inj73328_Button_creational = new CreationalCallback<Button>() {
    public Button getInstance(final CreationalContext context) {
      final Button inj72892_Button = new Button();
      context.addBean(context.getBeanReference(Button.class, arrayOf_19635043Annotation_418727585), inj72892_Button);
      return inj72892_Button;
    }
  };
  private final CreationalCallback<UserManagement> inj73324_UserManagement_creational = new CreationalCallback<UserManagement>() {
    public UserManagement getInstance(final CreationalContext context) {
      final UserManagement inj71152_UserManagement = new UserManagement();
      context.addBean(context.getBeanReference(UserManagement.class, arrayOf_19635043Annotation_418727585), inj71152_UserManagement);
      _$251511937_em(inj71152_UserManagement, inj73290_ErraiEntityManagerProvider.get());
      _$251511937_userService(inj71152_UserManagement, inj73300_CallerProvider.provide(new Class[] { UserService.class }, null));
      _$251511937_groupService(inj71152_UserManagement, inj73300_CallerProvider.provide(new Class[] { GroupService.class }, null));
      _$251511937_userBox(inj71152_UserManagement, inj73325_Label_creational.getInstance(context));
      _$251511937_info(inj71152_UserManagement, inj73325_Label_creational.getInstance(context));
      _$251511937_alert(inj71152_UserManagement, inj73325_Label_creational.getInstance(context));
      _$251511937_idBox(inj71152_UserManagement, inj73325_Label_creational.getInstance(context));
      _$251511937_ridBox(inj71152_UserManagement, inj73325_Label_creational.getInstance(context));
      _$251511937_userNameBox(inj71152_UserManagement, inj73325_Label_creational.getInstance(context));
      _$251511937_userName(inj71152_UserManagement, inj73326_TextBox_creational.getInstance(context));
      _$251511937_passwordBox(inj71152_UserManagement, inj73325_Label_creational.getInstance(context));
      _$251511937_password(inj71152_UserManagement, inj73326_TextBox_creational.getInstance(context));
      _$251511937_firstNameBox(inj71152_UserManagement, inj73325_Label_creational.getInstance(context));
      _$251511937_firstName(inj71152_UserManagement, inj73326_TextBox_creational.getInstance(context));
      _$251511937_lastNameBox(inj71152_UserManagement, inj73325_Label_creational.getInstance(context));
      _$251511937_lastName(inj71152_UserManagement, inj73326_TextBox_creational.getInstance(context));
      _$251511937_emailBox(inj71152_UserManagement, inj73325_Label_creational.getInstance(context));
      _$251511937_email(inj71152_UserManagement, inj73326_TextBox_creational.getInstance(context));
      _$251511937_groupBox(inj71152_UserManagement, inj73325_Label_creational.getInstance(context));
      _$251511937_group(inj71152_UserManagement, inj73327_ListBox_creational.getInstance(context));
      _$251511937_add(inj71152_UserManagement, inj73328_Button_creational.getInstance(context));
      _$251511937_update(inj71152_UserManagement, inj73328_Button_creational.getInstance(context));
      _$251511937_delete(inj71152_UserManagement, inj73328_Button_creational.getInstance(context));
      _$251511937_cancel(inj71152_UserManagement, inj73328_Button_creational.getInstance(context));
      _$251511937_deleteConfirm(inj71152_UserManagement, inj73328_Button_creational.getInstance(context));
      _$251511937_deleteCancel(inj71152_UserManagement, inj73328_Button_creational.getInstance(context));
      _$251511937_pullGroup(inj71152_UserManagement, inj73328_Button_creational.getInstance(context));
      _$251511937_pushUser(inj71152_UserManagement, inj73328_Button_creational.getInstance(context));
      _$251511937_pullUserLocal(inj71152_UserManagement, inj73328_Button_creational.getInstance(context));
      _$251511937_pullUserServer(inj71152_UserManagement, inj73328_Button_creational.getInstance(context));
      context.addInitializationCallback(inj71152_UserManagement, new InitializationCallback<UserManagement>() {
        public void init(UserManagement obj) {
          com_cosbeni_demo_client_local_UserManagementTemplateResource var545 = GWT.create(com_cosbeni_demo_client_local_UserManagementTemplateResource.class);
          Element var546 = TemplateUtil.getRootTemplateElement(var545.getContents().getText(), "UserManagement");
          Map<String, Element> var547 = TemplateUtil.getDataFieldElements(var546);
          Map<String, Widget> var548 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_usersClientTable(inj71152_UserManagement), var547, "usersClientTable");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_usersServerTable(inj71152_UserManagement), var547, "usersServerTable");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_userBox(inj71152_UserManagement), var547, "userBox");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_info(inj71152_UserManagement), var547, "info");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_infoMessage(inj71152_UserManagement)), var547, "infoMessage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_alert(inj71152_UserManagement), var547, "alert");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_alertMessage(inj71152_UserManagement)), var547, "alertMessage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_idBox(inj71152_UserManagement), var547, "idBox");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_id(inj71152_UserManagement)), var547, "id");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_idLabel(inj71152_UserManagement)), var547, "idLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_ridBox(inj71152_UserManagement), var547, "ridBox");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_rid(inj71152_UserManagement)), var547, "rid");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_ridLabel(inj71152_UserManagement)), var547, "ridLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_userNameBox(inj71152_UserManagement), var547, "userNameBox");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_userName(inj71152_UserManagement), var547, "userName");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_userNameLabel(inj71152_UserManagement)), var547, "userNameLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_userNameMessage(inj71152_UserManagement)), var547, "userNameMessage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_passwordBox(inj71152_UserManagement), var547, "passwordBox");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_password(inj71152_UserManagement), var547, "password");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_passwordLabel(inj71152_UserManagement)), var547, "passwordLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_passwordMessage(inj71152_UserManagement)), var547, "passwordMessage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_firstNameBox(inj71152_UserManagement), var547, "firstNameBox");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_firstName(inj71152_UserManagement), var547, "firstName");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_firstNameLabel(inj71152_UserManagement)), var547, "firstNameLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_firstNameMessage(inj71152_UserManagement)), var547, "firstNameMessage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_lastNameBox(inj71152_UserManagement), var547, "lastNameBox");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_lastName(inj71152_UserManagement), var547, "lastName");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_lastNameLabel(inj71152_UserManagement)), var547, "lastNameLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_lastNameMessage(inj71152_UserManagement)), var547, "lastNameMessage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_emailBox(inj71152_UserManagement), var547, "emailBox");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_email(inj71152_UserManagement), var547, "email");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_emailLabel(inj71152_UserManagement)), var547, "emailLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_emailMessage(inj71152_UserManagement)), var547, "emailMessage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_groupBox(inj71152_UserManagement), var547, "groupBox");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_group(inj71152_UserManagement), var547, "group");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", new ElementWrapperWidget(_$251511937_groupLabel(inj71152_UserManagement)), var547, "groupLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_add(inj71152_UserManagement), var547, "add");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_update(inj71152_UserManagement), var547, "update");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_delete(inj71152_UserManagement), var547, "delete");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_cancel(inj71152_UserManagement), var547, "cancel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_deleteConfirm(inj71152_UserManagement), var547, "deleteConfirm");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_deleteCancel(inj71152_UserManagement), var547, "deleteCancel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_pullGroup(inj71152_UserManagement), var547, "pullGroup");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_pushUser(inj71152_UserManagement), var547, "pushUser");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_pullUserLocal(inj71152_UserManagement), var547, "pullUserLocal");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.UserManagement", "com/cosbeni/demo/client/local/UserManagement.html", _$251511937_pullUserServer(inj71152_UserManagement), var547, "pullUserServer");
          var548.put("usersClientTable", _$251511937_usersClientTable(inj71152_UserManagement));
          var548.put("usersServerTable", _$251511937_usersServerTable(inj71152_UserManagement));
          var548.put("userBox", _$251511937_userBox(inj71152_UserManagement));
          var548.put("info", _$251511937_info(inj71152_UserManagement));
          var548.put("infoMessage", new ElementWrapperWidget(_$251511937_infoMessage(inj71152_UserManagement)));
          var548.put("alert", _$251511937_alert(inj71152_UserManagement));
          var548.put("alertMessage", new ElementWrapperWidget(_$251511937_alertMessage(inj71152_UserManagement)));
          var548.put("idBox", _$251511937_idBox(inj71152_UserManagement));
          var548.put("id", new ElementWrapperWidget(_$251511937_id(inj71152_UserManagement)));
          var548.put("idLabel", new ElementWrapperWidget(_$251511937_idLabel(inj71152_UserManagement)));
          var548.put("ridBox", _$251511937_ridBox(inj71152_UserManagement));
          var548.put("rid", new ElementWrapperWidget(_$251511937_rid(inj71152_UserManagement)));
          var548.put("ridLabel", new ElementWrapperWidget(_$251511937_ridLabel(inj71152_UserManagement)));
          var548.put("userNameBox", _$251511937_userNameBox(inj71152_UserManagement));
          var548.put("userName", _$251511937_userName(inj71152_UserManagement));
          var548.put("userNameLabel", new ElementWrapperWidget(_$251511937_userNameLabel(inj71152_UserManagement)));
          var548.put("userNameMessage", new ElementWrapperWidget(_$251511937_userNameMessage(inj71152_UserManagement)));
          var548.put("passwordBox", _$251511937_passwordBox(inj71152_UserManagement));
          var548.put("password", _$251511937_password(inj71152_UserManagement));
          var548.put("passwordLabel", new ElementWrapperWidget(_$251511937_passwordLabel(inj71152_UserManagement)));
          var548.put("passwordMessage", new ElementWrapperWidget(_$251511937_passwordMessage(inj71152_UserManagement)));
          var548.put("firstNameBox", _$251511937_firstNameBox(inj71152_UserManagement));
          var548.put("firstName", _$251511937_firstName(inj71152_UserManagement));
          var548.put("firstNameLabel", new ElementWrapperWidget(_$251511937_firstNameLabel(inj71152_UserManagement)));
          var548.put("firstNameMessage", new ElementWrapperWidget(_$251511937_firstNameMessage(inj71152_UserManagement)));
          var548.put("lastNameBox", _$251511937_lastNameBox(inj71152_UserManagement));
          var548.put("lastName", _$251511937_lastName(inj71152_UserManagement));
          var548.put("lastNameLabel", new ElementWrapperWidget(_$251511937_lastNameLabel(inj71152_UserManagement)));
          var548.put("lastNameMessage", new ElementWrapperWidget(_$251511937_lastNameMessage(inj71152_UserManagement)));
          var548.put("emailBox", _$251511937_emailBox(inj71152_UserManagement));
          var548.put("email", _$251511937_email(inj71152_UserManagement));
          var548.put("emailLabel", new ElementWrapperWidget(_$251511937_emailLabel(inj71152_UserManagement)));
          var548.put("emailMessage", new ElementWrapperWidget(_$251511937_emailMessage(inj71152_UserManagement)));
          var548.put("groupBox", _$251511937_groupBox(inj71152_UserManagement));
          var548.put("group", _$251511937_group(inj71152_UserManagement));
          var548.put("groupLabel", new ElementWrapperWidget(_$251511937_groupLabel(inj71152_UserManagement)));
          var548.put("add", _$251511937_add(inj71152_UserManagement));
          var548.put("update", _$251511937_update(inj71152_UserManagement));
          var548.put("delete", _$251511937_delete(inj71152_UserManagement));
          var548.put("cancel", _$251511937_cancel(inj71152_UserManagement));
          var548.put("deleteConfirm", _$251511937_deleteConfirm(inj71152_UserManagement));
          var548.put("deleteCancel", _$251511937_deleteCancel(inj71152_UserManagement));
          var548.put("pullGroup", _$251511937_pullGroup(inj71152_UserManagement));
          var548.put("pushUser", _$251511937_pushUser(inj71152_UserManagement));
          var548.put("pullUserLocal", _$251511937_pullUserLocal(inj71152_UserManagement));
          var548.put("pullUserServer", _$251511937_pullUserServer(inj71152_UserManagement));
          TemplateUtil.initWidget(inj71152_UserManagement, var546, var548.values());
          ((HasClickHandlers) var548.get("add")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71152_UserManagement.add(event);
            }
          });
          ((HasClickHandlers) var548.get("update")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71152_UserManagement.update(event);
            }
          });
          ((HasClickHandlers) var548.get("delete")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71152_UserManagement.delete(event);
            }
          });
          ((HasClickHandlers) var548.get("cancel")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71152_UserManagement.cancel(event);
            }
          });
          ((HasClickHandlers) var548.get("deleteConfirm")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71152_UserManagement.deleteConfirm(event);
            }
          });
          ((HasClickHandlers) var548.get("deleteCancel")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71152_UserManagement.deleteCancel(event);
            }
          });
          ((HasClickHandlers) var548.get("pullUserLocal")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71152_UserManagement.pullUserLocal(event);
            }
          });
          ((HasClickHandlers) var548.get("pullUserServer")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71152_UserManagement.pullUserServer(event);
            }
          });
          ((HasClickHandlers) var548.get("pushUser")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71152_UserManagement.pushUser(event);
            }
          });
          ((HasClickHandlers) var548.get("pullGroup")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71152_UserManagement.pullGroup(event);
            }
          });
        }
      });
      return inj71152_UserManagement;
    }
  };
  private final CreationalCallback<TextArea> inj73330_TextArea_creational = new CreationalCallback<TextArea>() {
    public TextArea getInstance(final CreationalContext context) {
      final TextArea inj72915_TextArea = new TextArea();
      context.addBean(context.getBeanReference(TextArea.class, arrayOf_19635043Annotation_418727585), inj72915_TextArea);
      return inj72915_TextArea;
    }
  };
  private final CreationalCallback<GroupManagement> inj73329_GroupManagement_creational = new CreationalCallback<GroupManagement>() {
    public GroupManagement getInstance(final CreationalContext context) {
      final GroupManagement inj71150_GroupManagement = new GroupManagement();
      context.addBean(context.getBeanReference(GroupManagement.class, arrayOf_19635043Annotation_418727585), inj71150_GroupManagement);
      _$1783685839_em(inj71150_GroupManagement, inj73290_ErraiEntityManagerProvider.get());
      _$1783685839_groupService(inj71150_GroupManagement, inj73300_CallerProvider.provide(new Class[] { GroupService.class }, null));
      _$1783685839_groupBox(inj71150_GroupManagement, inj73325_Label_creational.getInstance(context));
      _$1783685839_info(inj71150_GroupManagement, inj73325_Label_creational.getInstance(context));
      _$1783685839_alert(inj71150_GroupManagement, inj73325_Label_creational.getInstance(context));
      _$1783685839_idBox(inj71150_GroupManagement, inj73325_Label_creational.getInstance(context));
      _$1783685839_groupNameBox(inj71150_GroupManagement, inj73325_Label_creational.getInstance(context));
      _$1783685839_groupName(inj71150_GroupManagement, inj73326_TextBox_creational.getInstance(context));
      _$1783685839_descriptionBox(inj71150_GroupManagement, inj73325_Label_creational.getInstance(context));
      _$1783685839_description(inj71150_GroupManagement, inj73330_TextArea_creational.getInstance(context));
      _$1783685839_add(inj71150_GroupManagement, inj73328_Button_creational.getInstance(context));
      _$1783685839_update(inj71150_GroupManagement, inj73328_Button_creational.getInstance(context));
      _$1783685839_delete(inj71150_GroupManagement, inj73328_Button_creational.getInstance(context));
      _$1783685839_cancel(inj71150_GroupManagement, inj73328_Button_creational.getInstance(context));
      _$1783685839_deleteConfirm(inj71150_GroupManagement, inj73328_Button_creational.getInstance(context));
      _$1783685839_deleteCancel(inj71150_GroupManagement, inj73328_Button_creational.getInstance(context));
      context.addInitializationCallback(inj71150_GroupManagement, new InitializationCallback<GroupManagement>() {
        public void init(GroupManagement obj) {
          com_cosbeni_demo_client_local_GroupManagementTemplateResource var549 = GWT.create(com_cosbeni_demo_client_local_GroupManagementTemplateResource.class);
          Element var550 = TemplateUtil.getRootTemplateElement(var549.getContents().getText(), "GroupManagement");
          Map<String, Element> var551 = TemplateUtil.getDataFieldElements(var550);
          Map<String, Widget> var552 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", _$1783685839_groupsTable(inj71150_GroupManagement), var551, "groupsTable");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", _$1783685839_groupBox(inj71150_GroupManagement), var551, "groupBox");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", _$1783685839_info(inj71150_GroupManagement), var551, "info");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", new ElementWrapperWidget(_$1783685839_infoMessage(inj71150_GroupManagement)), var551, "infoMessage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", _$1783685839_alert(inj71150_GroupManagement), var551, "alert");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", new ElementWrapperWidget(_$1783685839_alertMessage(inj71150_GroupManagement)), var551, "alertMessage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", _$1783685839_idBox(inj71150_GroupManagement), var551, "idBox");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", new ElementWrapperWidget(_$1783685839_id(inj71150_GroupManagement)), var551, "id");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", new ElementWrapperWidget(_$1783685839_idLabel(inj71150_GroupManagement)), var551, "idLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", _$1783685839_groupNameBox(inj71150_GroupManagement), var551, "groupNameBox");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", _$1783685839_groupName(inj71150_GroupManagement), var551, "groupName");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", new ElementWrapperWidget(_$1783685839_groupNameLabel(inj71150_GroupManagement)), var551, "groupNameLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", _$1783685839_descriptionBox(inj71150_GroupManagement), var551, "descriptionBox");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", _$1783685839_description(inj71150_GroupManagement), var551, "description");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", new ElementWrapperWidget(_$1783685839_descriptionLabel(inj71150_GroupManagement)), var551, "descriptionLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", _$1783685839_add(inj71150_GroupManagement), var551, "add");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", _$1783685839_update(inj71150_GroupManagement), var551, "update");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", _$1783685839_delete(inj71150_GroupManagement), var551, "delete");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", _$1783685839_cancel(inj71150_GroupManagement), var551, "cancel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", _$1783685839_deleteConfirm(inj71150_GroupManagement), var551, "deleteConfirm");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.GroupManagement", "com/cosbeni/demo/client/local/GroupManagement.html", _$1783685839_deleteCancel(inj71150_GroupManagement), var551, "deleteCancel");
          var552.put("groupsTable", _$1783685839_groupsTable(inj71150_GroupManagement));
          var552.put("groupBox", _$1783685839_groupBox(inj71150_GroupManagement));
          var552.put("info", _$1783685839_info(inj71150_GroupManagement));
          var552.put("infoMessage", new ElementWrapperWidget(_$1783685839_infoMessage(inj71150_GroupManagement)));
          var552.put("alert", _$1783685839_alert(inj71150_GroupManagement));
          var552.put("alertMessage", new ElementWrapperWidget(_$1783685839_alertMessage(inj71150_GroupManagement)));
          var552.put("idBox", _$1783685839_idBox(inj71150_GroupManagement));
          var552.put("id", new ElementWrapperWidget(_$1783685839_id(inj71150_GroupManagement)));
          var552.put("idLabel", new ElementWrapperWidget(_$1783685839_idLabel(inj71150_GroupManagement)));
          var552.put("groupNameBox", _$1783685839_groupNameBox(inj71150_GroupManagement));
          var552.put("groupName", _$1783685839_groupName(inj71150_GroupManagement));
          var552.put("groupNameLabel", new ElementWrapperWidget(_$1783685839_groupNameLabel(inj71150_GroupManagement)));
          var552.put("descriptionBox", _$1783685839_descriptionBox(inj71150_GroupManagement));
          var552.put("description", _$1783685839_description(inj71150_GroupManagement));
          var552.put("descriptionLabel", new ElementWrapperWidget(_$1783685839_descriptionLabel(inj71150_GroupManagement)));
          var552.put("add", _$1783685839_add(inj71150_GroupManagement));
          var552.put("update", _$1783685839_update(inj71150_GroupManagement));
          var552.put("delete", _$1783685839_delete(inj71150_GroupManagement));
          var552.put("cancel", _$1783685839_cancel(inj71150_GroupManagement));
          var552.put("deleteConfirm", _$1783685839_deleteConfirm(inj71150_GroupManagement));
          var552.put("deleteCancel", _$1783685839_deleteCancel(inj71150_GroupManagement));
          TemplateUtil.initWidget(inj71150_GroupManagement, var550, var552.values());
          ((HasClickHandlers) var552.get("add")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71150_GroupManagement.add(event);
            }
          });
          ((HasClickHandlers) var552.get("update")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71150_GroupManagement.update(event);
            }
          });
          ((HasClickHandlers) var552.get("delete")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71150_GroupManagement.delete(event);
            }
          });
          ((HasClickHandlers) var552.get("cancel")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71150_GroupManagement.cancel(event);
            }
          });
          ((HasClickHandlers) var552.get("deleteConfirm")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71150_GroupManagement.deleteConfirm(event);
            }
          });
          ((HasClickHandlers) var552.get("deleteCancel")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71150_GroupManagement.deleteCancel(event);
            }
          });
        }
      });
      return inj71150_GroupManagement;
    }
  };
  private InitializationCallback<Language> init_inj71149_Language = new InitializationCallback<Language>() {
    public void init(final Language obj) {
      obj.init();
    }
  };
  private final CreationalCallback<Language> inj73331_Language_creational = new CreationalCallback<Language>() {
    public Language getInstance(final CreationalContext context) {
      final Language inj71149_Language = new Language();
      context.addBean(context.getBeanReference(Language.class, arrayOf_19635043Annotation_418727585), inj71149_Language);
      context.addInitializationCallback(inj71149_Language, new InitializationCallback<Language>() {
        public void init(Language obj) {
          com_cosbeni_demo_client_local_LanguageTemplateResource var553 = GWT.create(com_cosbeni_demo_client_local_LanguageTemplateResource.class);
          Element var554 = TemplateUtil.getRootTemplateElement(var553.getContents().getText(), "Language");
          Map<String, Element> var555 = TemplateUtil.getDataFieldElements(var554);
          Map<String, Widget> var556 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.Language", "com/cosbeni/demo/client/local/Main.html", new ElementWrapperWidget(_338227497_english(inj71149_Language)), var555, "english");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.Language", "com/cosbeni/demo/client/local/Main.html", new ElementWrapperWidget(_338227497_japanese(inj71149_Language)), var555, "japanese");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.Language", "com/cosbeni/demo/client/local/Main.html", new ElementWrapperWidget(_338227497_indonesian(inj71149_Language)), var555, "indonesian");
          var556.put("english", new ElementWrapperWidget(_338227497_english(inj71149_Language)));
          var556.put("japanese", new ElementWrapperWidget(_338227497_japanese(inj71149_Language)));
          var556.put("indonesian", new ElementWrapperWidget(_338227497_indonesian(inj71149_Language)));
          TemplateUtil.initWidget(inj71149_Language, var554, var556.values());
          TemplateUtil.setupWrappedElementEventHandler(inj71149_Language, var556.get("english"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71149_Language.english(event);
            }
          }, ClickEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj71149_Language, var556.get("japanese"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71149_Language.japanese(event);
            }
          }, ClickEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj71149_Language, var556.get("indonesian"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71149_Language.indonesian(event);
            }
          }, ClickEvent.getType());
        }
      });
      context.addInitializationCallback(inj71149_Language, init_inj71149_Language);
      return inj71149_Language;
    }
  };
  private InitializationCallback<Menu> init_inj71151_Menu = new InitializationCallback<Menu>() {
    public void init(final Menu obj) {
      obj.init();
    }
  };
  private final CreationalCallback<Menu> inj73332_Menu_creational = new CreationalCallback<Menu>() {
    public Menu getInstance(final CreationalContext context) {
      final Menu inj71151_Menu = new Menu();
      context.addBean(context.getBeanReference(Menu.class, arrayOf_19635043Annotation_418727585), inj71151_Menu);
      _1908081584_transitionUser(inj71151_Menu, inj73280_PageTransitionProvider.provide(new Class[] { UserManagement.class }, null));
      _1908081584_transitionGroup(inj71151_Menu, inj73280_PageTransitionProvider.provide(new Class[] { GroupManagement.class }, null));
      context.addInitializationCallback(inj71151_Menu, new InitializationCallback<Menu>() {
        public void init(Menu obj) {
          com_cosbeni_demo_client_local_MenuTemplateResource var557 = GWT.create(com_cosbeni_demo_client_local_MenuTemplateResource.class);
          Element var558 = TemplateUtil.getRootTemplateElement(var557.getContents().getText(), "Menu");
          Map<String, Element> var559 = TemplateUtil.getDataFieldElements(var558);
          Map<String, Widget> var560 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.Menu", "com/cosbeni/demo/client/local/Main.html", new ElementWrapperWidget(_1908081584_userPage(inj71151_Menu)), var559, "userPage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.Menu", "com/cosbeni/demo/client/local/Main.html", new ElementWrapperWidget(_1908081584_userAnchor(inj71151_Menu)), var559, "userAnchor");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.Menu", "com/cosbeni/demo/client/local/Main.html", new ElementWrapperWidget(_1908081584_groupPage(inj71151_Menu)), var559, "groupPage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.Menu", "com/cosbeni/demo/client/local/Main.html", new ElementWrapperWidget(_1908081584_groupAnchor(inj71151_Menu)), var559, "groupAnchor");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.Menu", "com/cosbeni/demo/client/local/Main.html", new ElementWrapperWidget(_1908081584_mobilePage(inj71151_Menu)), var559, "mobilePage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.client.local.Menu", "com/cosbeni/demo/client/local/Main.html", new ElementWrapperWidget(_1908081584_mobileAnchor(inj71151_Menu)), var559, "mobileAnchor");
          var560.put("userPage", new ElementWrapperWidget(_1908081584_userPage(inj71151_Menu)));
          var560.put("userAnchor", new ElementWrapperWidget(_1908081584_userAnchor(inj71151_Menu)));
          var560.put("groupPage", new ElementWrapperWidget(_1908081584_groupPage(inj71151_Menu)));
          var560.put("groupAnchor", new ElementWrapperWidget(_1908081584_groupAnchor(inj71151_Menu)));
          var560.put("mobilePage", new ElementWrapperWidget(_1908081584_mobilePage(inj71151_Menu)));
          var560.put("mobileAnchor", new ElementWrapperWidget(_1908081584_mobileAnchor(inj71151_Menu)));
          TemplateUtil.initWidget(inj71151_Menu, var558, var560.values());
          TemplateUtil.setupWrappedElementEventHandler(inj71151_Menu, var560.get("userPage"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71151_Menu.userPage(event);
            }
          }, ClickEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj71151_Menu, var560.get("groupPage"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71151_Menu.groupPage(event);
            }
          }, ClickEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj71151_Menu, var560.get("mobilePage"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj71151_Menu.phonePage(event);
            }
          }, ClickEvent.getType());
        }
      });
      context.addInitializationCallback(inj71151_Menu, init_inj71151_Menu);
      return inj71151_Menu;
    }
  };
  private InitializationCallback<App> init_inj73321_App = new InitializationCallback<App>() {
    public void init(final App obj) {
      obj.init();
    }
  };
  private final CreationalCallback<App> inj73322_App_creational = new CreationalCallback<App>() {
    public App getInstance(final CreationalContext context) {
      final App inj73321_App = new App();
      context.addBean(context.getBeanReference(App.class, arrayOf_19635043Annotation_418727585), inj73321_App);
      _2139749808_navigation(inj73321_App, inj73309_Navigation);
      _2139749808_dashBoard(inj73321_App, inj73323_DashBoard_creational.getInstance(context));
      _2139749808_userManagement(inj73321_App, inj73324_UserManagement_creational.getInstance(context));
      _2139749808_groupManagement(inj73321_App, inj73329_GroupManagement_creational.getInstance(context));
      _2139749808_language(inj73321_App, inj73331_Language_creational.getInstance(context));
      _2139749808_menu(inj73321_App, inj73332_Menu_creational.getInstance(context));
      context.addInitializationCallback(inj73321_App, init_inj73321_App);
      return inj73321_App;
    }
  };
  private final App inj73321_App = inj73322_App_creational.getInstance(context);
  public interface com_cosbeni_demo_client_local_DashBoardTemplateResource extends Template, ClientBundle {
  @Source("com/cosbeni/demo/client/local/DashBoard.html") public TextResource getContents(); }
  public interface com_cosbeni_demo_client_local_UserManagementTemplateResource extends Template, ClientBundle {
  @Source("com/cosbeni/demo/client/local/UserManagement.html") public TextResource getContents(); }
  public interface com_cosbeni_demo_client_local_GroupManagementTemplateResource extends Template, ClientBundle {
  @Source("com/cosbeni/demo/client/local/GroupManagement.html") public TextResource getContents(); }
  public interface com_cosbeni_demo_client_local_LanguageTemplateResource extends Template, ClientBundle {
  @Source("com/cosbeni/demo/client/local/Main.html") public TextResource getContents(); }
  public interface com_cosbeni_demo_client_local_MenuTemplateResource extends Template, ClientBundle {
  @Source("com/cosbeni/demo/client/local/Main.html") public TextResource getContents(); }
  private void declareBeans_0() {
    injContext.addBean(DataBinderProvider.class, DataBinderProvider.class, inj73305_DataBinderProvider_creational, inj73292_DataBinderProvider, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(ContextualTypeProvider.class, DataBinderProvider.class, inj73305_DataBinderProvider_creational, inj73292_DataBinderProvider, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(RequestDispatcherProvider.class, RequestDispatcherProvider.class, inj73306_RequestDispatcherProvider_creational, inj73284_RequestDispatcherProvider, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(Provider.class, RequestDispatcherProvider.class, inj73306_RequestDispatcherProvider_creational, inj73284_RequestDispatcherProvider, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(InstanceProvider.class, InstanceProvider.class, inj73307_InstanceProvider_creational, inj73294_InstanceProvider, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(ContextualTypeProvider.class, InstanceProvider.class, inj73307_InstanceProvider_creational, inj73294_InstanceProvider, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(EventProvider.class, EventProvider.class, inj73308_EventProvider_creational, inj73298_EventProvider, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(ContextualTypeProvider.class, EventProvider.class, inj73308_EventProvider_creational, inj73298_EventProvider, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Navigation.class, Navigation.class, inj73310_Navigation_creational, inj73309_Navigation, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(MessageBusProvider.class, MessageBusProvider.class, inj73311_MessageBusProvider_creational, inj73282_MessageBusProvider, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(Provider.class, MessageBusProvider.class, inj73311_MessageBusProvider_creational, inj73282_MessageBusProvider, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IOCBeanManagerProvider.class, IOCBeanManagerProvider.class, inj73312_IOCBeanManagerProvider_creational, inj73288_IOCBeanManagerProvider, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(Provider.class, IOCBeanManagerProvider.class, inj73312_IOCBeanManagerProvider_creational, inj73288_IOCBeanManagerProvider, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SenderProvider.class, SenderProvider.class, inj73313_SenderProvider_creational, inj73304_SenderProvider, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(ContextualTypeProvider.class, SenderProvider.class, inj73313_SenderProvider_creational, inj73304_SenderProvider, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(InitBallotProvider.class, InitBallotProvider.class, inj73314_InitBallotProvider_creational, inj73296_InitBallotProvider, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(ContextualTypeProvider.class, InitBallotProvider.class, inj73314_InitBallotProvider_creational, inj73296_InitBallotProvider, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(CallerProvider.class, CallerProvider.class, inj73315_CallerProvider_creational, inj73300_CallerProvider, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(ContextualTypeProvider.class, CallerProvider.class, inj73315_CallerProvider_creational, inj73300_CallerProvider, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(PageTransitionProvider.class, PageTransitionProvider.class, inj73316_PageTransitionProvider_creational, inj73280_PageTransitionProvider, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(ContextualTypeProvider.class, PageTransitionProvider.class, inj73316_PageTransitionProvider_creational, inj73280_PageTransitionProvider, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(RootPanelProvider.class, RootPanelProvider.class, inj73317_RootPanelProvider_creational, inj73286_RootPanelProvider, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(Provider.class, RootPanelProvider.class, inj73317_RootPanelProvider_creational, inj73286_RootPanelProvider, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(ListWidgetProvider.class, ListWidgetProvider.class, inj73318_ListWidgetProvider_creational, inj73278_ListWidgetProvider, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(ContextualTypeProvider.class, ListWidgetProvider.class, inj73318_ListWidgetProvider_creational, inj73278_ListWidgetProvider, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(ErraiEntityManagerProvider.class, ErraiEntityManagerProvider.class, inj73319_ErraiEntityManagerProvider_creational, inj73290_ErraiEntityManagerProvider, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(Provider.class, ErraiEntityManagerProvider.class, inj73319_ErraiEntityManagerProvider_creational, inj73290_ErraiEntityManagerProvider, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(DisposerProvider.class, DisposerProvider.class, inj73320_DisposerProvider_creational, inj73302_DisposerProvider, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(ContextualTypeProvider.class, DisposerProvider.class, inj73320_DisposerProvider_creational, inj73302_DisposerProvider, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(DashBoard.class, DashBoard.class, inj73323_DashBoard_creational, null, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(Composite.class, DashBoard.class, inj73323_DashBoard_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsRenderable.class, DashBoard.class, inj73323_DashBoard_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Widget.class, DashBoard.class, inj73323_DashBoard_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(EventListener.class, DashBoard.class, inj73323_DashBoard_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAttachHandlers.class, DashBoard.class, inj73323_DashBoard_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasHandlers.class, DashBoard.class, inj73323_DashBoard_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsWidget.class, DashBoard.class, inj73323_DashBoard_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(UIObject.class, DashBoard.class, inj73323_DashBoard_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasVisibility.class, DashBoard.class, inj73323_DashBoard_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Label.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(HasDirectionalText.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasText.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDirection.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasClickHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDoubleClickHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesClickEvents.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesMouseEvents.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllDragAndDropHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragEndHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragEnterHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragLeaveHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragOverHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragStartHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDropHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllGestureHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasGestureStartHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasGestureChangeHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasGestureEndHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllMouseHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseDownHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseUpHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseOutHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseOverHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseMoveHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseWheelHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllTouchHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchStartHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchMoveHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchEndHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchCancelHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsEditor.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(LabelBase.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasWordWrap.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDirectionEstimator.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAutoHorizontalAlignment.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasHorizontalAlignment.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Widget.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(EventListener.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAttachHandlers.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsWidget.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(UIObject.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasVisibility.class, Label.class, inj73325_Label_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(TextBox.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(TextBoxBase.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesChangeEvents.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(ValueBoxBase.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasChangeHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasName.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDirectionEstimator.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasValue.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(TakesValue.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasValueChangeHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Target.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasText.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDirection.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasKeyUpHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsEditor.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(FocusWidget.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesClickEvents.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasClickHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDoubleClickHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasFocus.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Focusable.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesFocusEvents.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesKeyboardEvents.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasEnabled.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllDragAndDropHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragEndHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragEnterHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragLeaveHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragOverHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragStartHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDropHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllFocusHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasFocusHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasBlurHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllGestureHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasGestureStartHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasGestureChangeHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasGestureEndHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllKeyHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasKeyDownHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasKeyPressHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllMouseHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseDownHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseUpHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseOutHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseOverHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseMoveHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseWheelHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllTouchHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchStartHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchMoveHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchEndHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchCancelHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesMouseEvents.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Widget.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(EventListener.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAttachHandlers.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsWidget.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(UIObject.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasVisibility.class, TextBox.class, inj73326_TextBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(ListBox.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(SourcesChangeEvents.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasChangeHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasName.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDirectionEstimator.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(FocusWidget.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesClickEvents.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasClickHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDoubleClickHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasFocus.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Focusable.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesFocusEvents.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesKeyboardEvents.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasEnabled.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllDragAndDropHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragEndHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragEnterHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragLeaveHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragOverHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragStartHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDropHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllFocusHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasFocusHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasBlurHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllGestureHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasGestureStartHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasGestureChangeHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasGestureEndHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllKeyHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasKeyUpHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasKeyDownHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasKeyPressHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllMouseHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseDownHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseUpHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseOutHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseOverHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseMoveHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseWheelHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllTouchHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchStartHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchMoveHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchEndHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchCancelHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesMouseEvents.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Widget.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(EventListener.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAttachHandlers.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsWidget.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(UIObject.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasVisibility.class, ListBox.class, inj73327_ListBox_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Button.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(ButtonBase.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasHTML.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasText.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasSafeHtml.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(FocusWidget.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesClickEvents.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasClickHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDoubleClickHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasFocus.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Focusable.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesFocusEvents.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesKeyboardEvents.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasEnabled.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllDragAndDropHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragEndHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragEnterHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragLeaveHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragOverHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragStartHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDropHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllFocusHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasFocusHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasBlurHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllGestureHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasGestureStartHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasGestureChangeHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasGestureEndHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllKeyHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasKeyUpHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasKeyDownHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasKeyPressHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllMouseHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseDownHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseUpHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseOutHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseOverHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseMoveHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseWheelHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllTouchHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchStartHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchMoveHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchEndHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchCancelHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesMouseEvents.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Widget.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(EventListener.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAttachHandlers.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsWidget.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(UIObject.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasVisibility.class, Button.class, inj73328_Button_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(UserManagement.class, UserManagement.class, inj73324_UserManagement_creational, null, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(Composite.class, UserManagement.class, inj73324_UserManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsRenderable.class, UserManagement.class, inj73324_UserManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Widget.class, UserManagement.class, inj73324_UserManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(EventListener.class, UserManagement.class, inj73324_UserManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAttachHandlers.class, UserManagement.class, inj73324_UserManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasHandlers.class, UserManagement.class, inj73324_UserManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsWidget.class, UserManagement.class, inj73324_UserManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(UIObject.class, UserManagement.class, inj73324_UserManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasVisibility.class, UserManagement.class, inj73324_UserManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(TextArea.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(TextBoxBase.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesChangeEvents.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(ValueBoxBase.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasChangeHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasName.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDirectionEstimator.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasValue.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(TakesValue.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasValueChangeHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Target.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasText.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDirection.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasKeyUpHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsEditor.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(FocusWidget.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesClickEvents.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasClickHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDoubleClickHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasFocus.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Focusable.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesFocusEvents.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesKeyboardEvents.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasEnabled.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllDragAndDropHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragEndHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragEnterHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragLeaveHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragOverHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDragStartHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasDropHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllFocusHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasFocusHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasBlurHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllGestureHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasGestureStartHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasGestureChangeHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasGestureEndHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllKeyHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasKeyDownHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasKeyPressHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllMouseHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseDownHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseUpHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseOutHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseOverHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseMoveHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasMouseWheelHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAllTouchHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchStartHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchMoveHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchEndHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasTouchCancelHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(SourcesMouseEvents.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Widget.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(EventListener.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAttachHandlers.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsWidget.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(UIObject.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasVisibility.class, TextArea.class, inj73330_TextArea_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(GroupManagement.class, GroupManagement.class, inj73329_GroupManagement_creational, null, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(Composite.class, GroupManagement.class, inj73329_GroupManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsRenderable.class, GroupManagement.class, inj73329_GroupManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Widget.class, GroupManagement.class, inj73329_GroupManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(EventListener.class, GroupManagement.class, inj73329_GroupManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAttachHandlers.class, GroupManagement.class, inj73329_GroupManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasHandlers.class, GroupManagement.class, inj73329_GroupManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsWidget.class, GroupManagement.class, inj73329_GroupManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(UIObject.class, GroupManagement.class, inj73329_GroupManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasVisibility.class, GroupManagement.class, inj73329_GroupManagement_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Language.class, Language.class, inj73331_Language_creational, null, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(Composite.class, Language.class, inj73331_Language_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsRenderable.class, Language.class, inj73331_Language_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Widget.class, Language.class, inj73331_Language_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(EventListener.class, Language.class, inj73331_Language_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAttachHandlers.class, Language.class, inj73331_Language_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasHandlers.class, Language.class, inj73331_Language_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsWidget.class, Language.class, inj73331_Language_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(UIObject.class, Language.class, inj73331_Language_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasVisibility.class, Language.class, inj73331_Language_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Menu.class, Menu.class, inj73332_Menu_creational, null, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(Composite.class, Menu.class, inj73332_Menu_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsRenderable.class, Menu.class, inj73332_Menu_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Widget.class, Menu.class, inj73332_Menu_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(EventListener.class, Menu.class, inj73332_Menu_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAttachHandlers.class, Menu.class, inj73332_Menu_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasHandlers.class, Menu.class, inj73332_Menu_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsWidget.class, Menu.class, inj73332_Menu_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(UIObject.class, Menu.class, inj73332_Menu_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasVisibility.class, Menu.class, inj73332_Menu_creational, null, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(App.class, App.class, inj73322_App_creational, inj73321_App, arrayOf_19635043Annotation_418727585, null, true);
    injContext.addBean(Composite.class, App.class, inj73322_App_creational, inj73321_App, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsRenderable.class, App.class, inj73322_App_creational, inj73321_App, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(Widget.class, App.class, inj73322_App_creational, inj73321_App, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(EventListener.class, App.class, inj73322_App_creational, inj73321_App, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasAttachHandlers.class, App.class, inj73322_App_creational, inj73321_App, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasHandlers.class, App.class, inj73322_App_creational, inj73321_App, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(IsWidget.class, App.class, inj73322_App_creational, inj73321_App, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(UIObject.class, App.class, inj73322_App_creational, inj73321_App, arrayOf_19635043Annotation_418727585, null, false);
    injContext.addBean(HasVisibility.class, App.class, inj73322_App_creational, inj73321_App, arrayOf_19635043Annotation_418727585, null, false);
  }

  private native static void _1908081584_transitionGroup(Menu instance, TransitionTo value) /*-{
    instance.@com.cosbeni.demo.client.local.Menu::transitionGroup = value;
  }-*/;

  private native static Label _$251511937_userBox(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::userBox;
  }-*/;

  private native static void _$251511937_userBox(UserManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::userBox = value;
  }-*/;

  private native static AnchorElement _1908081584_mobileAnchor(Menu instance) /*-{
    return instance.@com.cosbeni.demo.client.local.Menu::mobileAnchor;
  }-*/;

  private native static void _1908081584_mobileAnchor(Menu instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.client.local.Menu::mobileAnchor = value;
  }-*/;

  private native static TextBox _$251511937_password(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::password;
  }-*/;

  private native static void _$251511937_password(UserManagement instance, TextBox value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::password = value;
  }-*/;

  private native static LabelElement _$251511937_lastNameLabel(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::lastNameLabel;
  }-*/;

  private native static void _$251511937_lastNameLabel(UserManagement instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::lastNameLabel = value;
  }-*/;

  private native static Button _$251511937_pushUser(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::pushUser;
  }-*/;

  private native static void _$251511937_pushUser(UserManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::pushUser = value;
  }-*/;

  private native static SpanElement _$251511937_lastNameMessage(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::lastNameMessage;
  }-*/;

  private native static void _$251511937_lastNameMessage(UserManagement instance, SpanElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::lastNameMessage = value;
  }-*/;

  private native static void _2139749808_menu(App instance, Menu value) /*-{
    instance.@com.cosbeni.demo.client.local.App::menu = value;
  }-*/;

  private native static SpanElement _$700623165_main(DashBoard instance) /*-{
    return instance.@com.cosbeni.demo.client.local.DashBoard::main;
  }-*/;

  private native static void _$700623165_main(DashBoard instance, SpanElement value) /*-{
    instance.@com.cosbeni.demo.client.local.DashBoard::main = value;
  }-*/;

  private native static SpanElement _$251511937_passwordMessage(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::passwordMessage;
  }-*/;

  private native static void _$251511937_passwordMessage(UserManagement instance, SpanElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::passwordMessage = value;
  }-*/;

  private native static Label _$1783685839_idBox(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::idBox;
  }-*/;

  private native static void _$1783685839_idBox(GroupManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::idBox = value;
  }-*/;

  private native static LabelElement _$251511937_userNameLabel(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::userNameLabel;
  }-*/;

  private native static void _$251511937_userNameLabel(UserManagement instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::userNameLabel = value;
  }-*/;

  private native static LIElement _1908081584_userPage(Menu instance) /*-{
    return instance.@com.cosbeni.demo.client.local.Menu::userPage;
  }-*/;

  private native static void _1908081584_userPage(Menu instance, LIElement value) /*-{
    instance.@com.cosbeni.demo.client.local.Menu::userPage = value;
  }-*/;

  private native static void _$1783685839_groupService(GroupManagement instance, Caller value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::groupService = value;
  }-*/;

  private native static LabelElement _$251511937_ridLabel(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::ridLabel;
  }-*/;

  private native static void _$251511937_ridLabel(UserManagement instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::ridLabel = value;
  }-*/;

  private native static Button _$251511937_pullUserServer(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::pullUserServer;
  }-*/;

  private native static void _$251511937_pullUserServer(UserManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::pullUserServer = value;
  }-*/;

  private native static Label _$251511937_userNameBox(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::userNameBox;
  }-*/;

  private native static void _$251511937_userNameBox(UserManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::userNameBox = value;
  }-*/;

  private native static SpanElement _$700623165_language(DashBoard instance) /*-{
    return instance.@com.cosbeni.demo.client.local.DashBoard::language;
  }-*/;

  private native static void _$700623165_language(DashBoard instance, SpanElement value) /*-{
    instance.@com.cosbeni.demo.client.local.DashBoard::language = value;
  }-*/;

  private native static Button _$251511937_add(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::add;
  }-*/;

  private native static void _$251511937_add(UserManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::add = value;
  }-*/;

  private native static LabelElement _$251511937_emailLabel(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::emailLabel;
  }-*/;

  private native static void _$251511937_emailLabel(UserManagement instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::emailLabel = value;
  }-*/;

  private native static SpanElement _$251511937_emailMessage(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::emailMessage;
  }-*/;

  private native static void _$251511937_emailMessage(UserManagement instance, SpanElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::emailMessage = value;
  }-*/;

  private native static Label _$251511937_lastNameBox(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::lastNameBox;
  }-*/;

  private native static void _$251511937_lastNameBox(UserManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::lastNameBox = value;
  }-*/;

  private native static AnchorElement _1908081584_groupAnchor(Menu instance) /*-{
    return instance.@com.cosbeni.demo.client.local.Menu::groupAnchor;
  }-*/;

  private native static void _1908081584_groupAnchor(Menu instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.client.local.Menu::groupAnchor = value;
  }-*/;

  private native static Label _$251511937_emailBox(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::emailBox;
  }-*/;

  private native static void _$251511937_emailBox(UserManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::emailBox = value;
  }-*/;

  private native static void _395577528_navigation(PageTransitionProvider instance, Navigation value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.PageTransitionProvider::navigation = value;
  }-*/;

  private native static LabelElement _$251511937_firstNameLabel(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::firstNameLabel;
  }-*/;

  private native static void _$251511937_firstNameLabel(UserManagement instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::firstNameLabel = value;
  }-*/;

  private native static TextBox _$251511937_userName(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::userName;
  }-*/;

  private native static void _$251511937_userName(UserManagement instance, TextBox value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::userName = value;
  }-*/;

  private native static TextBox _$1783685839_groupName(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::groupName;
  }-*/;

  private native static void _$1783685839_groupName(GroupManagement instance, TextBox value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::groupName = value;
  }-*/;

  private native static HeadingElement _$1783685839_alertMessage(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::alertMessage;
  }-*/;

  private native static void _$1783685839_alertMessage(GroupManagement instance, HeadingElement value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::alertMessage = value;
  }-*/;

  private native static AnchorElement _338227497_indonesian(Language instance) /*-{
    return instance.@com.cosbeni.demo.client.local.Language::indonesian;
  }-*/;

  private native static void _338227497_indonesian(Language instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.client.local.Language::indonesian = value;
  }-*/;

  private native static LIElement _1908081584_groupPage(Menu instance) /*-{
    return instance.@com.cosbeni.demo.client.local.Menu::groupPage;
  }-*/;

  private native static void _1908081584_groupPage(Menu instance, LIElement value) /*-{
    instance.@com.cosbeni.demo.client.local.Menu::groupPage = value;
  }-*/;

  private native static LabelElement _$1783685839_groupNameLabel(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::groupNameLabel;
  }-*/;

  private native static void _$1783685839_groupNameLabel(GroupManagement instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::groupNameLabel = value;
  }-*/;

  private native static Button _$1783685839_cancel(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::cancel;
  }-*/;

  private native static void _$1783685839_cancel(GroupManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::cancel = value;
  }-*/;

  private native static Label _$1783685839_groupBox(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::groupBox;
  }-*/;

  private native static void _$1783685839_groupBox(GroupManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::groupBox = value;
  }-*/;

  private native static Label _$251511937_idBox(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::idBox;
  }-*/;

  private native static void _$251511937_idBox(UserManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::idBox = value;
  }-*/;

  private native static LIElement _1908081584_mobilePage(Menu instance) /*-{
    return instance.@com.cosbeni.demo.client.local.Menu::mobilePage;
  }-*/;

  private native static void _1908081584_mobilePage(Menu instance, LIElement value) /*-{
    instance.@com.cosbeni.demo.client.local.Menu::mobilePage = value;
  }-*/;

  private native static void _$1300398733_beanManager(DisposerProvider instance, IOCBeanManager value) /*-{
    instance.@org.jboss.errai.ioc.client.api.builtin.DisposerProvider::beanManager = value;
  }-*/;

  private native static AnchorElement _338227497_japanese(Language instance) /*-{
    return instance.@com.cosbeni.demo.client.local.Language::japanese;
  }-*/;

  private native static void _338227497_japanese(Language instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.client.local.Language::japanese = value;
  }-*/;

  private native static HeadingElement _$251511937_alertMessage(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::alertMessage;
  }-*/;

  private native static void _$251511937_alertMessage(UserManagement instance, HeadingElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::alertMessage = value;
  }-*/;

  private native static Label _$251511937_passwordBox(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::passwordBox;
  }-*/;

  private native static void _$251511937_passwordBox(UserManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::passwordBox = value;
  }-*/;

  private native static void _$251511937_userService(UserManagement instance, Caller value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::userService = value;
  }-*/;

  private native static void _2139749808_dashBoard(App instance, DashBoard value) /*-{
    instance.@com.cosbeni.demo.client.local.App::dashBoard = value;
  }-*/;

  private native static LabelElement _$251511937_id(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::id;
  }-*/;

  private native static void _$251511937_id(UserManagement instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::id = value;
  }-*/;

  private native static void _1908081584_transitionUser(Menu instance, TransitionTo value) /*-{
    instance.@com.cosbeni.demo.client.local.Menu::transitionUser = value;
  }-*/;

  private native static void _$1783685839_em(GroupManagement instance, EntityManager value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::em = value;
  }-*/;

  private native static Button _$251511937_pullUserLocal(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::pullUserLocal;
  }-*/;

  private native static void _$251511937_pullUserLocal(UserManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::pullUserLocal = value;
  }-*/;

  private native static void _2139749808_language(App instance, Language value) /*-{
    instance.@com.cosbeni.demo.client.local.App::language = value;
  }-*/;

  private native static Label _$251511937_firstNameBox(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::firstNameBox;
  }-*/;

  private native static void _$251511937_firstNameBox(UserManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::firstNameBox = value;
  }-*/;

  private native static Button _$251511937_update(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::update;
  }-*/;

  private native static void _$251511937_update(UserManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::update = value;
  }-*/;

  private native static AnchorElement _1908081584_userAnchor(Menu instance) /*-{
    return instance.@com.cosbeni.demo.client.local.Menu::userAnchor;
  }-*/;

  private native static void _1908081584_userAnchor(Menu instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.client.local.Menu::userAnchor = value;
  }-*/;

  private native static HeadingElement _$251511937_infoMessage(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::infoMessage;
  }-*/;

  private native static void _$251511937_infoMessage(UserManagement instance, HeadingElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::infoMessage = value;
  }-*/;

  private native static Button _$1783685839_update(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::update;
  }-*/;

  private native static void _$1783685839_update(GroupManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::update = value;
  }-*/;

  private native static Label _$1783685839_alert(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::alert;
  }-*/;

  private native static void _$1783685839_alert(GroupManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::alert = value;
  }-*/;

  private native static Label _$1783685839_info(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::info;
  }-*/;

  private native static void _$1783685839_info(GroupManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::info = value;
  }-*/;

  private native static Label _$251511937_alert(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::alert;
  }-*/;

  private native static void _$251511937_alert(UserManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::alert = value;
  }-*/;

  private native static ListBox _$251511937_group(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::group;
  }-*/;

  private native static void _$251511937_group(UserManagement instance, ListBox value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::group = value;
  }-*/;

  private native static Button _$1783685839_delete(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::delete;
  }-*/;

  private native static void _$1783685839_delete(GroupManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::delete = value;
  }-*/;

  private native static Label _$251511937_info(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::info;
  }-*/;

  private native static void _$251511937_info(UserManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::info = value;
  }-*/;

  private native static Button _$251511937_cancel(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::cancel;
  }-*/;

  private native static void _$251511937_cancel(UserManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::cancel = value;
  }-*/;

  private native static Button _$251511937_deleteConfirm(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::deleteConfirm;
  }-*/;

  private native static void _$251511937_deleteConfirm(UserManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::deleteConfirm = value;
  }-*/;

  private native static void _2139749808_userManagement(App instance, UserManagement value) /*-{
    instance.@com.cosbeni.demo.client.local.App::userManagement = value;
  }-*/;

  private native static Button _$251511937_deleteCancel(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::deleteCancel;
  }-*/;

  private native static void _$251511937_deleteCancel(UserManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::deleteCancel = value;
  }-*/;

  private native static void _2139749808_groupManagement(App instance, GroupManagement value) /*-{
    instance.@com.cosbeni.demo.client.local.App::groupManagement = value;
  }-*/;

  private native static TextBox _$251511937_email(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::email;
  }-*/;

  private native static void _$251511937_email(UserManagement instance, TextBox value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::email = value;
  }-*/;

  private native static LabelElement _$1783685839_idLabel(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::idLabel;
  }-*/;

  private native static void _$1783685839_idLabel(GroupManagement instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::idLabel = value;
  }-*/;

  private native static TextBox _$251511937_lastName(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::lastName;
  }-*/;

  private native static void _$251511937_lastName(UserManagement instance, TextBox value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::lastName = value;
  }-*/;

  private native static ListGrid _$1783685839_groupsTable(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::groupsTable;
  }-*/;

  private native static void _$1783685839_groupsTable(GroupManagement instance, ListGrid value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::groupsTable = value;
  }-*/;

  private native static Button _$1783685839_deleteConfirm(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::deleteConfirm;
  }-*/;

  private native static void _$1783685839_deleteConfirm(GroupManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::deleteConfirm = value;
  }-*/;

  private native static ListGrid _$251511937_usersClientTable(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::usersClientTable;
  }-*/;

  private native static void _$251511937_usersClientTable(UserManagement instance, ListGrid value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::usersClientTable = value;
  }-*/;

  private native static Label _$251511937_groupBox(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::groupBox;
  }-*/;

  private native static void _$251511937_groupBox(UserManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::groupBox = value;
  }-*/;

  private native static LabelElement _$1783685839_descriptionLabel(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::descriptionLabel;
  }-*/;

  private native static void _$1783685839_descriptionLabel(GroupManagement instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::descriptionLabel = value;
  }-*/;

  private native static Button _$251511937_delete(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::delete;
  }-*/;

  private native static void _$251511937_delete(UserManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::delete = value;
  }-*/;

  private native static SpanElement _$700623165_menu(DashBoard instance) /*-{
    return instance.@com.cosbeni.demo.client.local.DashBoard::menu;
  }-*/;

  private native static void _$700623165_menu(DashBoard instance, SpanElement value) /*-{
    instance.@com.cosbeni.demo.client.local.DashBoard::menu = value;
  }-*/;

  private native static TextArea _$1783685839_description(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::description;
  }-*/;

  private native static void _$1783685839_description(GroupManagement instance, TextArea value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::description = value;
  }-*/;

  private native static void _$251511937_groupService(UserManagement instance, Caller value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::groupService = value;
  }-*/;

  private native static LabelElement _$251511937_groupLabel(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::groupLabel;
  }-*/;

  private native static void _$251511937_groupLabel(UserManagement instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::groupLabel = value;
  }-*/;

  private native static void _$251511937_em(UserManagement instance, EntityManager value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::em = value;
  }-*/;

  private native static TextBox _$251511937_firstName(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::firstName;
  }-*/;

  private native static void _$251511937_firstName(UserManagement instance, TextBox value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::firstName = value;
  }-*/;

  private native static SpanElement _$251511937_firstNameMessage(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::firstNameMessage;
  }-*/;

  private native static void _$251511937_firstNameMessage(UserManagement instance, SpanElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::firstNameMessage = value;
  }-*/;

  private native static Label _$1783685839_groupNameBox(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::groupNameBox;
  }-*/;

  private native static void _$1783685839_groupNameBox(GroupManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::groupNameBox = value;
  }-*/;

  private native static LabelElement _$1783685839_id(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::id;
  }-*/;

  private native static void _$1783685839_id(GroupManagement instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::id = value;
  }-*/;

  private native static Button _$1783685839_deleteCancel(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::deleteCancel;
  }-*/;

  private native static void _$1783685839_deleteCancel(GroupManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::deleteCancel = value;
  }-*/;

  private native static LabelElement _$251511937_rid(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::rid;
  }-*/;

  private native static void _$251511937_rid(UserManagement instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::rid = value;
  }-*/;

  private native static LabelElement _$251511937_passwordLabel(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::passwordLabel;
  }-*/;

  private native static void _$251511937_passwordLabel(UserManagement instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::passwordLabel = value;
  }-*/;

  private native static void _2139749808_navigation(App instance, Navigation value) /*-{
    instance.@com.cosbeni.demo.client.local.App::navigation = value;
  }-*/;

  private native static AnchorElement _338227497_english(Language instance) /*-{
    return instance.@com.cosbeni.demo.client.local.Language::english;
  }-*/;

  private native static void _338227497_english(Language instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.client.local.Language::english = value;
  }-*/;

  private native static ListGrid _$251511937_usersServerTable(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::usersServerTable;
  }-*/;

  private native static void _$251511937_usersServerTable(UserManagement instance, ListGrid value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::usersServerTable = value;
  }-*/;

  private native static Label _$1783685839_descriptionBox(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::descriptionBox;
  }-*/;

  private native static void _$1783685839_descriptionBox(GroupManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::descriptionBox = value;
  }-*/;

  private native static LabelElement _$251511937_idLabel(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::idLabel;
  }-*/;

  private native static void _$251511937_idLabel(UserManagement instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::idLabel = value;
  }-*/;

  private native static SpanElement _$251511937_userNameMessage(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::userNameMessage;
  }-*/;

  private native static void _$251511937_userNameMessage(UserManagement instance, SpanElement value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::userNameMessage = value;
  }-*/;

  private native static HeadingElement _$1783685839_infoMessage(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::infoMessage;
  }-*/;

  private native static void _$1783685839_infoMessage(GroupManagement instance, HeadingElement value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::infoMessage = value;
  }-*/;

  private native static Button _$1783685839_add(GroupManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.GroupManagement::add;
  }-*/;

  private native static void _$1783685839_add(GroupManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.GroupManagement::add = value;
  }-*/;

  private native static Button _$251511937_pullGroup(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::pullGroup;
  }-*/;

  private native static void _$251511937_pullGroup(UserManagement instance, Button value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::pullGroup = value;
  }-*/;

  private native static Label _$251511937_ridBox(UserManagement instance) /*-{
    return instance.@com.cosbeni.demo.client.local.UserManagement::ridBox;
  }-*/;

  private native static void _$251511937_ridBox(UserManagement instance, Label value) /*-{
    instance.@com.cosbeni.demo.client.local.UserManagement::ridBox = value;
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