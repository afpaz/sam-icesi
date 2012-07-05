package co.edu.icesi.sam.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import co.edu.icesi.sam.client.model.CursoModel;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.ui.RootPanel;

public class PanelCursos extends LayoutContainer {

	private Grid<CursoModel> grid;
	private String[] datosNombresColumnas;
	public PanelCursos(){

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  

		ColumnConfig column = new ColumnConfig();    
		column.setId("id");    
		column.setHeader("Identificacion");    
		column.setWidth(200);    
		configs.add(column);  

		column = new ColumnConfig("nombre", "Nombre", 150);    
		column.setAlignment(HorizontalAlignment.LEFT);    
		configs.add(column);  

		column = new ColumnConfig("codigo", "Codigo", 150);    
		column.setAlignment(HorizontalAlignment.LEFT);    
		configs.add(column);  




		ListStore<CursoModel> employeeList = new ListStore<CursoModel>();    
		//employeeList.add(TestData.getEmployees()); 


		ColumnModel cm = new ColumnModel(configs);  
		grid = new Grid<CursoModel>(employeeList, cm);   
		grid.setStyleAttribute("borderTop", "none");   
		grid.setAutoExpandColumn("name");   
		grid.setBorders(true);   
		grid.setStripeRows(true); 

		ContentPanel cp = new ContentPanel();    
		cp.setBodyBorder(false);    
		cp.setHeading("Lista de Cursos:");    
		cp.setButtonAlign(HorizontalAlignment.CENTER);    
		cp.setLayout(new FitLayout());    
		cp.setSize(700, 300);   
		cp.add(grid);    
		RootPanel.get().add(cp);

		//		ListStore<Employee> employeeList2 = employeeList;
		//		DateTimeFormat f = DateTimeFormat.getFormat("yyyy-mm-dd");  
		//		employeeList2.add(new Employee("Diego Rojas","General Administration","Executive Director",150000,f.parse("2006-05-01")));
		//
		//		grid.reconfigure(employeeList2, cm);
		//RootPanel.get().add(grid);

		cargarCursos();
		eventos() ;
	}

	private void cargarCursos() {
		//Aqui se debe hacer el ASyn que devuelva la lista de cursos y llame al metodo actualizarPanel
		
	}

	public void eventos(){


		grid.addListener(Events.OnClick, new Listener<GridEvent<BaseModel>>() {
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

	public void actualizarPanel(ListStore<CursoModel> listaCursos, ColumnModel cm){

		grid.reconfigure(listaCursos, cm);
		RootPanel.get().add(grid);

	}

}
