package co.edu.icesi.sam.client;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;

public class PanelObjetivoGeneral extends LayoutContainer {

	public PanelObjetivoGeneral() {
		setLayout(new AbsoluteLayout());
		
		TextArea txtrObjetivogeneral = new TextArea();
		add(txtrObjetivogeneral, new AbsoluteData(52, 52));
		txtrObjetivogeneral.setSize("342px", "125px");
		txtrObjetivogeneral.setFieldLabel("ObjetivoGeneral");
		
		Text txtLabelobj = new Text("Objetivo General:");
		add(txtLabelobj, new AbsoluteData(52, 28));
		
		Button btnGuardar = new Button("Guardar");
		add(btnGuardar, new AbsoluteData(194, 183));
	}
}
