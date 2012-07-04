package co.edu.icesi.sam.client;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.table.Table;
import com.extjs.gxt.ui.client.widget.table.TableColumnModel;
import com.extjs.gxt.ui.client.widget.table.TableColumn;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.store.ListStore;

public class PanelRecursos extends LayoutContainer {

	public PanelRecursos() {
		setLayout(new AbsoluteLayout());
		
		Button btnNewButton = new Button("Asociar");
		add(btnNewButton, new AbsoluteData(194, 188));
		
		Table table_1 = new Table(new TableColumnModel(new TableColumn("id.1", "Nombre", 0.3f), new TableColumn("id.2", "Tipo", 0.2f),new TableColumn("id.3", "Contenido", 0.7f)));
		add(table_1, new AbsoluteData(37, 18));
		table_1.setSize("368px", "72px");
		
		ListView listView = new ListView(new ListStore());
		add(listView, new AbsoluteData(37, 124));
		listView.setSize("368px", "58px");
		
		Text txtMateriales = new Text("Materiales:");
		add(txtMateriales, new AbsoluteData(37, 98));
		
		Text txtRecursos = new Text("Recursos:");
		add(txtRecursos, new AbsoluteData(37, 214));
		
		ListView listView_1 = new ListView(new ListStore());
		add(listView_1, new AbsoluteData(37, 238));
		listView_1.setSize("364px", "56px");
	}
}
