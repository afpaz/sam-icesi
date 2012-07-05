package co.edu.icesi.sam.client;



import java.util.ArrayList;
import java.util.List;

import co.edu.icesi.sam.client.model.CursoModel;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelIconProvider;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.RootPanel;

public class PanelPlanificador extends LayoutContainer
{

	 private ColumnModel cmObj;
	private Grid<CursoModel> gridObj;
	private ColumnModel cmUnidad;
	private Grid<CursoModel> gridUnidad;

	/**
	  * @wbp.parser.entryPoint
	  */
	 public PanelPlanificador() {
		    //setLayout(new FlowLayout(10));

		    ContentPanel panel = new ContentPanel();
		    panel.setHeading("Unidades:");
		    panel.setBodyBorder(false);

		    panel.setLayout(new AccordionLayout());
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
		    
//		    Table table = new Table(new TableColumnModel(new TableColumn("id.1", "Objetivo Especifico", 0.3f), new TableColumn("id.2", "Contenido", 0.7f)));
//		    cp.add(table, new AbsoluteData(53, 59));
//		    table.setSize("340px", "40px");
		    
			//CARGA LA TABLA DE OBJETIVOS ESPECIFICOS
			List<ColumnConfig> configsObj = new ArrayList<ColumnConfig>();  

			ColumnConfig columnObj = new ColumnConfig();    
			columnObj.setId("id");    
			columnObj.setHeader("Identificacion");    
			columnObj.setWidth(80);    
			configsObj.add(columnObj);  

			columnObj = new ColumnConfig("nombre", "Objetivo Especifico", 100);    
			columnObj.setAlignment(HorizontalAlignment.LEFT);    
			configsObj.add(columnObj);  

			columnObj = new ColumnConfig("contenido", "Contenido", 200);    
			columnObj.setAlignment(HorizontalAlignment.LEFT);    
			configsObj.add(columnObj);  

			ListStore<CursoModel> listaObjetivos = new ListStore<CursoModel>();    
			//employeeList.add(TestData.getEmployees()); 

			 cmObj = new ColumnModel(configsObj);  
			gridObj = new Grid<CursoModel>(listaObjetivos, cmObj);   
			gridObj.setStyleAttribute("borderTop", "none");   
			gridObj.setAutoExpandColumn("name");   
			gridObj.setBorders(true);   
			gridObj.setStripeRows(true); 

			ContentPanel cpObj = new ContentPanel();    
			cpObj.setBodyBorder(false);    
			cpObj.setHeading("Lista de Objetivos Especificos:");    
			cpObj.setButtonAlign(HorizontalAlignment.CENTER);    
			cpObj.setLayout(new FitLayout());    
			cpObj.setSize(340, 40);   
			cpObj.add(gridObj);   
			
			cp.add(cpObj, new AbsoluteData(53, 59));
		    
		    
		    
		    
		    
		    
		    
//		    Table table_1 = new Table(new TableColumnModel(new TableColumn("id.1", "Sesión", 0.3f), new TableColumn("id.2", "Antes", 0.3f), new TableColumn("id.2", "Durante", 0.3f), new TableColumn("id.2", "Despues", 0.3f)));
//		    cp.add(table_1, new AbsoluteData(53, 105));
//		    table_1.setSize("340px", "40px");
			
			
			
			//CARGA LA TABLA DE UNIDADES
			List<ColumnConfig> configsUnidad = new ArrayList<ColumnConfig>();  

			ColumnConfig columnUnidad = new ColumnConfig();    
			columnUnidad.setId("id");    
			columnUnidad.setHeader("Identificacion");    
			columnUnidad.setWidth(80); 
			columnUnidad.setHidden(true);
			configsUnidad.add(columnUnidad);  

			columnUnidad = new ColumnConfig("nombreSesion", "Nombre Sesion", 100);    
			columnUnidad.setAlignment(HorizontalAlignment.LEFT);    
			configsUnidad.add(columnUnidad);  
			
			columnUnidad = new ColumnConfig("antes", "Antes", 100);    
			columnUnidad.setAlignment(HorizontalAlignment.LEFT);    
			configsUnidad.add(columnUnidad);  
			
			columnUnidad = new ColumnConfig("durante", "Durante", 150);    
			columnUnidad.setAlignment(HorizontalAlignment.LEFT);    
			configsUnidad.add(columnUnidad);  
			
			columnUnidad = new ColumnConfig("despues", "Despues", 150);    
			columnUnidad.setAlignment(HorizontalAlignment.LEFT);    
			configsUnidad.add(columnUnidad); 

			ListStore<CursoModel> listaUnidades = new ListStore<CursoModel>();    
			//employeeList.add(TestData.getEmployees()); 

			cmUnidad = new ColumnModel(configsUnidad);  
			gridUnidad = new Grid<CursoModel>(listaUnidades, cmUnidad);   
			gridUnidad.setStyleAttribute("borderTop", "none");   
			gridUnidad.setAutoExpandColumn("name");   
			gridUnidad.setBorders(true);   
			gridUnidad.setStripeRows(true); 

			ContentPanel cpUnidad = new ContentPanel();    
			cpUnidad.setBodyBorder(false);    
			cpUnidad.setHeading("Lista de Sesiones:");    
			cpUnidad.setButtonAlign(HorizontalAlignment.CENTER);    
			cpUnidad.setLayout(new FitLayout());    
			cpUnidad.setSize(340, 40);   
			cpUnidad.add(gridUnidad);    
			//RootPanel.get().add(cpUnidad);
			cp.add(cpUnidad, new AbsoluteData(53, 105));
			
			
			
			
			
			
		    
		    Button btnCrearSesin = new Button("Crear Sesi\u00F3n");
		    cp.add(btnCrearSesin, new AbsoluteData(184, 151));
		    
		    panel.add(cp);

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
		    panel.add(cp);

		    cp = new ContentPanel();
		    cp.setAnimCollapse(false);
		    cp.setBodyStyleName("pad-text");
		    cp.setHeading("Stuff");
		    cp.addText("DUMMY_TEXT_SHORT");
		    panel.add(cp);

		    cp = new ContentPanel();
		    cp.setAnimCollapse(false);
		    cp.setBodyStyleName("pad-text");
		    cp.setHeading("More Stuff");
		    cp.addText("DUMMY_TEXT_SHORT");
		    panel.add(cp);
		    panel.setSize(200, 325);

		    RootPanel rootPanel = RootPanel.get();
		    rootPanel.setWidgetPosition(panel, 0, 0);
		    rootPanel.add(panel);
		    panel.setSize("450px", "300px");
		    
		    
		  }

		  private ModelData newItem(String text, String iconStyle) {
		    ModelData m = new BaseModelData();
		    m.set("name", text);
		    m.set("icon", iconStyle);
		    return m;
		  }
		}