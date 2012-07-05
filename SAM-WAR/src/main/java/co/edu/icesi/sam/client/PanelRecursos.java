package co.edu.icesi.sam.client;

import java.util.ArrayList;
import java.util.List;

import co.edu.icesi.sam.client.model.CursoModel;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.ui.RootPanel;
import com.extjs.gxt.ui.client.Style;

public class PanelRecursos extends LayoutContainer {

	private ColumnModel cmSaberes;
	private Grid<CursoModel> gridSaberes;

	public PanelRecursos() {
		setLayout(new AbsoluteLayout());

		Button btnNewButton = new Button("Asociar");
		add(btnNewButton, new AbsoluteData(241, 370));

		//		Table table_1 = new Table(new TableColumnModel(new TableColumn("id.1", "Nombre", 0.3f), new TableColumn("id.2", "Tipo", 0.2f),new TableColumn("id.3", "Contenido", 0.7f)));
		//		add(table_1, new AbsoluteData(37, 18));
		//		table_1.setSize("368px", "72px");

		//CARGA LA TABLA DE SABERES
		List<ColumnConfig> configSaberes = new ArrayList<ColumnConfig>();  

		ColumnConfig columnSaberes = new ColumnConfig();    
		columnSaberes.setId("id");    
		columnSaberes.setHeader("Identificacion");    
		columnSaberes.setWidth(80);    
		configSaberes.add(columnSaberes);  

		columnSaberes = new ColumnConfig("nombre", "Nombre", 100);    
		columnSaberes.setAlignment(HorizontalAlignment.LEFT);    
		configSaberes.add(columnSaberes);  

		columnSaberes = new ColumnConfig("tipo", "Tipo", 200);    
		columnSaberes.setAlignment(HorizontalAlignment.LEFT);    
		configSaberes.add(columnSaberes);  

		columnSaberes = new ColumnConfig("contenido", "Contenido", 200);    
		columnSaberes.setAlignment(HorizontalAlignment.LEFT);    
		configSaberes.add(columnSaberes);  

		ListStore<CursoModel> listaSaberes = new ListStore<CursoModel>();    
		//employeeList.add(TestData.getEmployees()); 

		cmSaberes = new ColumnModel(configSaberes);  
		gridSaberes = new Grid<CursoModel>(listaSaberes, cmSaberes);   
		gridSaberes.setStyleAttribute("borderTop", "none");   
		gridSaberes.setAutoExpandColumn("name");   
		gridSaberes.setBorders(true);   
		gridSaberes.setStripeRows(true); 

		ContentPanel cpObj = new ContentPanel();    
		cpObj.setBodyBorder(false);    
		cpObj.setHeading("Lista de Saberes:");    
		cpObj.setButtonAlign(HorizontalAlignment.CENTER);    
		cpObj.setLayout(new FitLayout());    
		cpObj.setSize(450, 116);   
		cpObj.add(gridSaberes);   

		add(cpObj, new AbsoluteData(37, 18));
		
		ListView materiales = new ListView(new ListStore());
		add(materiales, new AbsoluteData(37, 163));
		materiales.setSize("448px", "82px");
		
		Text txtMateriales = new Text("Materiales:");
		add(txtMateriales, new AbsoluteData(37, 140));
		
		ListView recursos = new ListView(new ListStore());
		add(recursos, new AbsoluteData(37, 281));
		recursos.setSize("446px", "83px");
		
		Text txtRecursos = new Text("Recursos:");
		add(txtRecursos, new AbsoluteData(37, 257));

	}
	public void actualizarTablaSaberes(ListStore<CursoModel> listaUnidades){

		gridSaberes.reconfigure(listaUnidades, cmSaberes);

	}
}
