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

public class PanelSaberes extends LayoutContainer {

	public PanelSaberes() {
		setLayout(new AbsoluteLayout());
		
		Button btnNewButton = new Button("Agregar");
		add(btnNewButton, new AbsoluteData(211, 240));
		
		Table table = new Table(new TableColumnModel(new TableColumn("id.1", "Objetivo Especifico", 0.4f), new TableColumn("id.2", "Contenido", 0.7f)));
		add(table, new AbsoluteData(37, 19));
		table.setSize("374px", "100px");
		
		Table table_1 = new Table(new TableColumnModel(new TableColumn("id.1", "Nombre", 0.3f), new TableColumn("id.2", "Tipo", 0.2f),new TableColumn("id.3", "Contenido", 0.7f)));
		add(table_1, new AbsoluteData(37, 128));
		table_1.setSize("372px", "106px");
	}
}
