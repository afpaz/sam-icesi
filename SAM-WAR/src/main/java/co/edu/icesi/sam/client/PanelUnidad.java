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
import com.extjs.gxt.ui.client.widget.table.TableItem;

public class PanelUnidad extends LayoutContainer {

	public PanelUnidad() {
		setLayout(new AbsoluteLayout());
		
		Text txtNewText = new Text("Objetivo General:");
		add(txtNewText, new AbsoluteData(36, 6));
		
		TextArea txtrNewTextarea = new TextArea();
		add(txtrNewTextarea, new AbsoluteData(36, 30));
		txtrNewTextarea.setSize("380px", "60px");
		txtrNewTextarea.setFieldLabel("New TextArea");
		
		Button btnNewButton = new Button("Agregar");
		add(btnNewButton, new AbsoluteData(210, 257));
		
		Table table = new Table(new TableColumnModel(new TableColumn("id.1", "Nombre Unidad", 0.3f), new TableColumn("id.2", "Objetivo Terminal", 0.7f)));
		
	
		add(table, new AbsoluteData(36, 105));
		table.setSize("376px", "146px");
	}
}
