package co.edu.icesi.sam.client;

import javax.swing.ImageIcon;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.DecoratedTabBar;
import com.google.gwt.user.client.ui.TabPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.CheckBoxListView;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.table.Table;
import com.extjs.gxt.ui.client.widget.table.TableColumnModel;
import com.extjs.gxt.ui.client.widget.table.TableColumn;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;

public class Ventana extends Window {

	public Ventana() {
		setHeading("Ventana SAM Icesi");
		setLayout(new BorderLayout());
		
		com.extjs.gxt.ui.client.widget.TabPanel tabPanel = new com.extjs.gxt.ui.client.widget.TabPanel();
		add(tabPanel, new BorderLayoutData(LayoutRegion.CENTER));
		
		TabItem tbtmNewTabitem_1 = new TabItem("Objetivo General");
		
		tabPanel.add(tbtmNewTabitem_1);
		tbtmNewTabitem_1.setSize("2369px", "40px");
		
		TabItem tbtmNewTabitem_2 = new TabItem("Objetivos Terminales");
		tabPanel.add(tbtmNewTabitem_2);
		
		TabItem tbtmNewTabitem_3 = new TabItem("Unidades");
		tabPanel.add(tbtmNewTabitem_3);
		
		TabItem tbtmNewTabitem_4 = new TabItem("Objetivos Especificos");
		tabPanel.add(tbtmNewTabitem_4);
		
		TabItem tbtmNewTabitem_5 = new TabItem("Saberes");
		tabPanel.add(tbtmNewTabitem_5);
		
		TabItem tbtmNewTabitem_6 = new TabItem("Materiales del Curso");
		tabPanel.add(tbtmNewTabitem_6);
		
		TabItem tbtmNewTabitem_7 = new TabItem("Recursos");
		tabPanel.add(tbtmNewTabitem_7);
		
		TabItem tbtmNewTabitem = new TabItem("Planificador");
		tabPanel.add(tbtmNewTabitem);
		
		LayoutContainer layoutContainer = new LayoutContainer();
		add(layoutContainer, new BorderLayoutData(LayoutRegion.NORTH, 55.0f));
		layoutContainer.setBorders(true);
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		
		Table table = new Table(new TableColumnModel(new TableColumn("id.1", "C�digo", 0.3f), new TableColumn("id.2", "Cursos", 0.7f)));
		layoutContainer_1.add(table);
		add(layoutContainer_1, new BorderLayoutData(LayoutRegion.WEST, 120.0f));
		layoutContainer_1.setBorders(true);
		
	}
}