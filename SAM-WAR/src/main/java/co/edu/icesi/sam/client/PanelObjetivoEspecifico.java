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

public class PanelObjetivoEspecifico extends LayoutContainer {

	public PanelObjetivoEspecifico() {
		setLayout(new AbsoluteLayout());
		
		Button btnNewButton = new Button("Agregar");
		add(btnNewButton, new AbsoluteData(210, 257));
		
		Table table = new Table(new TableColumnModel(new TableColumn("id.1", "Objetivo Especifico", 0.3f), new TableColumn("id.2", "Contenido", 0.7f)));
		add(table, new AbsoluteData(36, 156));
		table.setSize("374px", "93px");
		
		Table table_1 = new Table(new TableColumnModel(new TableColumn("id.1", "Unidad", 0.2f), new TableColumn("id.2", "Contenido Unidad", 0.3f),new TableColumn("id.2", "Objetivo Terminal", 0.3f),new TableColumn("id.2", "Contenido", 0.3f)));
		AbsoluteData ad_table_1 = new AbsoluteData(36, 30);
		ad_table_1.setAnchorSpec("-75");
		add(table_1, ad_table_1);
		table_1.setHeight("116px");
	}
}
