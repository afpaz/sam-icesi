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
		setSize(1024,768);
		com.extjs.gxt.ui.client.widget.TabPanel tabPanel = new com.extjs.gxt.ui.client.widget.TabPanel();
		add(tabPanel, new BorderLayoutData(LayoutRegion.CENTER));
		
		TabItem tbtmNewTabitem_1 = new TabItem("Objetivo General");
		PanelObjetivoGeneral panelObjGeneral = new PanelObjetivoGeneral( );
		tbtmNewTabitem_1.add(panelObjGeneral);
		panelObjGeneral.setVisible( true );
		
		tabPanel.add(tbtmNewTabitem_1);
		tbtmNewTabitem_1.setSize("2369px", "40px");
		
		TabItem tbtmNewTabitem_2 = new TabItem("Objetivos Terminales");
		tabPanel.add(tbtmNewTabitem_2);
		PanelObjetivosTerminales panelObjTerminales = new PanelObjetivosTerminales( );
		tbtmNewTabitem_2.add(panelObjTerminales);
		panelObjTerminales.setVisible( true );
		
		TabItem tbtmNewTabitem_3 = new TabItem("Unidades");
		tabPanel.add(tbtmNewTabitem_3);
		PanelUnidad panelUnidad = new PanelUnidad( );
		tbtmNewTabitem_3.add(panelUnidad);
		panelUnidad.setVisible( true );
		
		TabItem tbtmNewTabitem_4 = new TabItem("Objetivos Especificos");
		tabPanel.add(tbtmNewTabitem_4);
		PanelObjetivoEspecifico panelObjEspecifico = new PanelObjetivoEspecifico( );
		tbtmNewTabitem_4.add(panelObjEspecifico);
		panelObjEspecifico.setVisible( true );
		
		TabItem tbtmNewTabitem_5 = new TabItem("Saberes");
		tabPanel.add(tbtmNewTabitem_5);
		PanelSaberes panelSaberes = new PanelSaberes( );
		tbtmNewTabitem_5.add(panelSaberes);
		panelSaberes.setVisible( true );
		
		TabItem tbtmNewTabitem_6 = new TabItem("Materiales del Curso");
		tabPanel.add(tbtmNewTabitem_6);
		PanelMateriales panelMateriales = new PanelMateriales( );
		tbtmNewTabitem_6.add(panelMateriales);
		panelMateriales.setVisible( true );
		
		TabItem tbtmNewTabitem_7 = new TabItem("Recursos");
		tabPanel.add(tbtmNewTabitem_7);
		PanelRecursos panelRecursos = new PanelRecursos( );
		tbtmNewTabitem_7.add(panelRecursos);
		panelRecursos.setVisible( true );
		
		TabItem tbtmNewTabitem = new TabItem("Planificador");
		tabPanel.add(tbtmNewTabitem);
//		PanelPlanificador panelPlanificador = new PanelPlanificador( );
//		tbtmNewTabitem.add(panelPlanificador);
//		panelPlanificador.setVisible( true );
		
		LayoutContainer layoutContainer = new LayoutContainer();
		add(layoutContainer, new BorderLayoutData(LayoutRegion.NORTH, 55.0f));
		layoutContainer.setBorders(true);
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		
		Table table = new Table(new TableColumnModel(new TableColumn("id.1", "Código", 0.3f), new TableColumn("id.2", "Cursos", 0.7f)));
		layoutContainer_1.add(table);
		add(layoutContainer_1, new BorderLayoutData(LayoutRegion.WEST, 120.0f));
		layoutContainer_1.setBorders(true);
		
	}
}
