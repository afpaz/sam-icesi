package co.edu.icesi.sam.client;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;

public class PanelMateriales extends LayoutContainer {

	public PanelMateriales() {
		setLayout(new AbsoluteLayout());
		
		ListView listView = new ListView(new ListStore());
		add(listView, new AbsoluteData(76, 63));
		listView.setSize("300px", "200px");
		
		Text txtMateriales = new Text("Materiales");
		add(txtMateriales, new AbsoluteData(198, 39));
		
		Button agregar = new Button("Agregar");
		add(agregar, new AbsoluteData(198, 269));
	}
}
