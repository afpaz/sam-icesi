package co.edu.icesi.sam.client;

import java.util.ArrayList;
import java.util.List;

import co.edu.icesi.sam.client.model.CursoModel;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.ui.RootPanel;

public class PanelUnidad extends LayoutContainer {

	private Grid<CursoModel> gridUnidad;
	private List<ColumnConfig> configsUnidad;
	public PanelUnidad() {
		setLayout(new AbsoluteLayout());

		Text txtNewText = new Text("Objetivo General:");
		add(txtNewText, new AbsoluteData(36, 6));

		TextArea txtrNewTextarea = new TextArea();
		add(txtrNewTextarea, new AbsoluteData(36, 30));
		txtrNewTextarea.setSize("380px", "60px");


		Button btnNewButton = new Button("Agregar");
		add(btnNewButton, new AbsoluteData(210, 257));

		//		Table table = new Table(new TableColumnModel(new TableColumn("id.1", "Nombre Unidad", 0.3f), new TableColumn("id.2", "Objetivo Terminal", 0.7f)));

		//CARGA LA TABLA DE UNIDADES
		configsUnidad = new ArrayList<ColumnConfig>();  

		ColumnConfig columnUnidad = new ColumnConfig(); 

		columnUnidad = new ColumnConfig("nombre", "Nombre Unidad", 100);    
		columnUnidad.setAlignment(HorizontalAlignment.LEFT);    
		configsUnidad.add(columnUnidad);  
		columnUnidad.setWidget(new CheckBox(), "");


		//llamar al metodo que retorna la lista de objetivos terminales y hacer un for
		CheckColumnConfig checkColumn = new CheckColumnConfig("objetivoTerminal", "OT", 30);
		CellEditor checkBoxEditor = new CellEditor(new CheckBox());
		checkColumn.setEditor(checkBoxEditor);
		configsUnidad.add(checkColumn);


		ColumnModel cm = new ColumnModel(configsUnidad);

		//Aqui se agrega la unidades
		ListStore<CursoModel> listaUnidades = new ListStore<CursoModel>();    

		gridUnidad = new Grid<CursoModel>(listaUnidades, cm);   
		gridUnidad.setStyleAttribute("borderTop", "none");   
		gridUnidad.setAutoExpandColumn("name");   
		gridUnidad.setBorders(true);   
		gridUnidad.setStripeRows(true); 

		gridUnidad.setSize("100px", "50px");

		ContentPanel cpUnidad = new ContentPanel();    
		cpUnidad.setBodyBorder(false);    
		cpUnidad.setHeading("Lista de Unidades:");    
		cpUnidad.setButtonAlign(HorizontalAlignment.CENTER);    
		cpUnidad.setLayout(new FitLayout());    
		cpUnidad.setSize(380, 150);   
		cpUnidad.add(gridUnidad);    
		add(cpUnidad);


		add(cpUnidad, new AbsoluteData(36, 105));

	}

	public void listarColumnas(){

	}

}
