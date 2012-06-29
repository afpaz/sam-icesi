package co.edu.icesi.sam.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.user.client.ui.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.Style.LayoutRegion;

public class Ventana extends Window {

	public Ventana() {
		setHeading("Ventana SAM Icesi");
		setLayout(new BorderLayout());
		
		FormPanel panelWest = new FormPanel();
		panelWest.setHeading("Panel1");
		panelWest.setCollapsible(true);
		add(panelWest, new BorderLayoutData(LayoutRegion.WEST));
		
	}

}
