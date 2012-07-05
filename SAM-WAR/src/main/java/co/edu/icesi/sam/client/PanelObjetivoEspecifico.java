package co.edu.icesi.sam.client;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.ui.RootPanel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import co.edu.icesi.sam.client.model.CursoModel;

public class PanelObjetivoEspecifico extends LayoutContainer {

	private Grid<CursoModel> gridObj;
	private Grid<CursoModel> gridUnidad;
	private String[] datosNombresColumnas;
	private ColumnModel cmUnidad;
	private ColumnModel cmObj;

	public PanelObjetivoEspecifico() {
		setLayout(new AbsoluteLayout());

		//		Button btnNewButton = new Button("Agregar");
		//		add(btnNewButton, new AbsoluteData(210, 257));
		//		
		//		Table table = new Table(new TableColumnModel(new TableColumn("id.1", "Objetivo Especifico", 0.3f), new TableColumn("id.2", "Contenido", 0.7f)));
		//		add(table, new AbsoluteData(36, 156));
		//		table.setSize("374px", "93px");
		//		
		//		Table table_1 = new Table(new TableColumnModel(new TableColumn("id.1", "Unidad", 0.2f), new TableColumn("id.2", "Contenido Unidad", 0.3f),new TableColumn("id.2", "Objetivo Terminal", 0.3f),new TableColumn("id.2", "Contenido", 0.3f)));
		//		AbsoluteData ad_table_1 = new AbsoluteData(36, 30);
		//		ad_table_1.setAnchorSpec("-75");
		//		add(table_1, ad_table_1);
		//		table_1.setHeight("116px");



		//CARGA LA TABLA DE UNIDADES
		List<ColumnConfig> configsUnidad = new ArrayList<ColumnConfig>();  

		ColumnConfig columnUnidad = new ColumnConfig();    
		columnUnidad.setId("id");    
		columnUnidad.setHeader("Identificacion");    
		columnUnidad.setWidth(80);    
		configsUnidad.add(columnUnidad);  

		columnUnidad = new ColumnConfig("contenidoUnidad", "Contenido Unidad", 100);    
		columnUnidad.setAlignment(HorizontalAlignment.LEFT);    
		configsUnidad.add(columnUnidad);  
		
		columnUnidad = new ColumnConfig("objetivoTerminal", "Objetivo Terminal", 100);    
		columnUnidad.setAlignment(HorizontalAlignment.LEFT);    
		configsUnidad.add(columnUnidad);  
		
		columnUnidad = new ColumnConfig("contenido", "Contenido", 150);    
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
		cpUnidad.setHeading("Lista de Unidades:");    
		cpUnidad.setButtonAlign(HorizontalAlignment.CENTER);    
		cpUnidad.setLayout(new FitLayout());    
		cpUnidad.setSize(450, 93);   
		cpUnidad.add(gridUnidad);    
		//RootPanel.get().add(cpUnidad);
		add(cpUnidad, new AbsoluteData(36, 30));

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
		cpObj.setSize(450, 116);   
		cpObj.add(gridObj);   
		
		add(cpObj, new AbsoluteData(36, 156));
		
		//RootPanel.get().add(cpObj);

		//		ListStore<Employee> employeeList2 = employeeList;
		//		DateTimeFormat f = DateTimeFormat.getFormat("yyyy-mm-dd");  
		//		employeeList2.add(new Employee("Diego Rojas","General Administration","Executive Director",150000,f.parse("2006-05-01")));
		//
		//		grid.reconfigure(employeeList2, cm);
		//RootPanel.get().add(grid);

		cargarObjetivosEspecificos();
		cargarUnidades();
		eventos() ;
	}

	private void cargarUnidades() {
		//Aqui se debe hacer el ASyn que devuelva la lista de cargarUnidades y llame al metodo actualizarPanel

	}

	private void cargarObjetivosEspecificos() {
		//Aqui se debe hacer el ASyn que devuelva la lista de objEspecificos y llame al metodo actualizarPanel

	}

	public void eventos(){


		gridUnidad.addListener(Events.OnClick, new Listener<GridEvent<BaseModel>>() {
			public void handleEvent(GridEvent<BaseModel> be) {


				if(be.getGrid().getSelectionModel().getSelectedItem() != null)
				{
					Map<String, Object> d = be.getGrid().getSelectionModel().getSelectedItem().getProperties();
					datosNombresColumnas = new String[d.size()]; 
					Set<String> id_columnas = d.keySet();
					Iterator<String> iter  = id_columnas.iterator();
					int i =0;
					while(iter.hasNext())
						datosNombresColumnas[i++]= iter.next();
					for(String x : datosNombresColumnas)
						System.out.println("x - " + x);
				}
			}
		});


							gridObj.addListener(Events.OnClick, new Listener<GridEvent<BaseModel>>() {
								public void handleEvent(GridEvent<BaseModel> be) {


									if(be.getGrid().getSelectionModel().getSelectedItem() != null)
									{
										Map<String, Object> d = be.getGrid().getSelectionModel().getSelectedItem().getProperties();
										datosNombresColumnas = new String[d.size()]; 
										Set<String> id_columnas = d.keySet();
										Iterator<String> iter  = id_columnas.iterator();
										int i =0;
										while(iter.hasNext())
											datosNombresColumnas[i++]= iter.next();
										for(String x : datosNombresColumnas)
											System.out.println("x - " + x);
									}
								}
							});



	}

	public void actualizarTablaUnidad(ListStore<CursoModel> listaUnidades){

		gridUnidad.reconfigure(listaUnidades, cmUnidad);
		//RootPanel.get().add(gridUnidad);

	}

	public void actualizarTablaObjEspecifico(ListStore<CursoModel> listaObj){

		gridObj.reconfigure(listaObj, cmObj);
		//RootPanel.get().add(gridObj);

	}
}
