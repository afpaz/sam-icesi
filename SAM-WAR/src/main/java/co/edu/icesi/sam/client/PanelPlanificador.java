package co.edu.icesi.sam.client;



import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelIconProvider;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.RootPanel;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.table.Table;
import com.extjs.gxt.ui.client.widget.table.TableColumnModel;
import com.extjs.gxt.ui.client.widget.table.TableColumn;
import com.extjs.gxt.ui.client.widget.button.Button;

public class PanelPlanificador extends ContentPanel {

	 /**
	  * @wbp.parser.entryPoint
	  */
	 public void onModuleLoad() {
		    //setLayout(new FlowLayout(10));

		   // ContentPanel panel = new ContentPanel();
		    setHeading("AccordionLayout");
		    setBodyBorder(false);

		    setLayout(new AccordionLayout());
		    //panel.setIcon(Resources.ICONS.accordion());

		    ContentPanel cp = new ContentPanel();
		    cp.setAnimCollapse(false);
		    cp.setHeading("Unidad 1");
		    
		    TextArea txtrNewTextarea = new TextArea();
		    cp.add(txtrNewTextarea, new AbsoluteData(53, 24));
		    txtrNewTextarea.setSize("340px", "30px");
		    txtrNewTextarea.setFieldLabel("New TextArea");
		    
		    Text txtDescripcionUnidad = new Text("Descripcion Unidad");
		    cp.add(txtDescripcionUnidad, new AbsoluteData(184, 0));
		    
		    Table table = new Table(new TableColumnModel(new TableColumn("id.1", "Objetivo Especifico", 0.3f), new TableColumn("id.2", "Contenido", 0.7f)));
		    cp.add(table, new AbsoluteData(53, 59));
		    table.setSize("340px", "40px");
		    
		    Table table_1 = new Table(new TableColumnModel(new TableColumn("id.1", "Sesión", 0.3f), new TableColumn("id.2", "Antes", 0.3f), new TableColumn("id.2", "Durante", 0.3f), new TableColumn("id.2", "Despues", 0.3f)));
		    cp.add(table_1, new AbsoluteData(53, 105));
		    table_1.setSize("340px", "40px");
		    
		    Button btnCrearSesin = new Button("Crear Sesi\u00F3n");
		    cp.add(btnCrearSesin, new AbsoluteData(184, 151));
		    
		    add(cp);

		    TreeStore<ModelData> store = new TreeStore<ModelData>();
		    TreePanel<ModelData> tree = new TreePanel<ModelData>(store);
		    tree.setIconProvider(new ModelIconProvider<ModelData>() {

		      public AbstractImagePrototype getIcon(ModelData model) {
		        if (model.get("icon") != null) {
		          return IconHelper.createStyle((String) model.get("icon"));
		        } else {
		          return null;
		        }
		      }

		    });
		    tree.setDisplayProperty("name");

		    ModelData m = newItem("Family", null);
		    store.add(m, false);

		    store.add(m, newItem("Darrell", "user"), false);
		    store.add(m, newItem("Maro", "user-girl"), false);
		    store.add(m, newItem("Lia", "user-kid"), false);
		    store.add(m, newItem("Alec", "user-kid"), false);
		    store.add(m, newItem("Andrew", "user-kid"), false);
		    tree.setExpanded(m, true);

		    m = newItem("Friends", null);
		    store.add(m, false);

		    store.add(m, newItem("Bob", "user"), false);
		    store.add(m, newItem("Mary", "user-girl"), false);
		    store.add(m, newItem("Sally", "user-girl"), false);
		    store.add(m, newItem("Jack", "user"), false);

		    tree.setExpanded(m, true);
		    cp.setLayout(new AbsoluteLayout());

		    cp.add(tree, new AbsoluteData(0, 0));
		    tree.setSize("448px", "180px");

		    cp = new ContentPanel();
		    cp.setAnimCollapse(false);
		    cp.setBodyStyleName("pad-text");
		    cp.setHeading("Settings");
		    cp.addText("DUMMY_TEXT_SHORT");
		    add(cp);

		    cp = new ContentPanel();
		    cp.setAnimCollapse(false);
		    cp.setBodyStyleName("pad-text");
		    cp.setHeading("Stuff");
		    cp.addText("DUMMY_TEXT_SHORT");
		    add(cp);

		    cp = new ContentPanel();
		    cp.setAnimCollapse(false);
		    cp.setBodyStyleName("pad-text");
		    cp.setHeading("More Stuff");
		    cp.addText("DUMMY_TEXT_SHORT");
		    add(cp);
		    setSize(200, 325);

		    RootPanel rootPanel = RootPanel.get();
		    rootPanel.setWidgetPosition(this, 0, 0);
		    rootPanel.add(this);
		    setSize("450px", "300px");
		    
		    add(this);
		  }

		  private ModelData newItem(String text, String iconStyle) {
		    ModelData m = new BaseModelData();
		    m.set("name", text);
		    m.set("icon", iconStyle);
		    return m;
		  }
		}