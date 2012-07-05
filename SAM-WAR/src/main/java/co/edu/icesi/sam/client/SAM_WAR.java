package co.edu.icesi.sam.client;

import co.edu.icesi.sam.client.controller.DTViewController;
import co.edu.icesi.sam.shared.FieldVerifier;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.table.Table;
import com.extjs.gxt.ui.client.widget.table.TableColumn;
import com.extjs.gxt.ui.client.widget.table.TableColumnModel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SAM_WAR implements EntryPoint
{
    /**
     * This is the entry point method.
     */
    public void onModuleLoad( )
    {
        Dispatcher.get( ).addController( new DTViewController( ) );

        TabPanel tabs = new TabPanel( );
        tabs.setSize( 800, 600 );
        tabs.disable( );
        Registry.register( "tabs", tabs );
        
        PanelCursos panelCursos = new PanelCursos( );
        Registry.register( "panelCursos", panelCursos );
        
        TabObjGeneral tabObjGeneral = new TabObjGeneral( );        
        Registry.register( "tabObjGeneral", tabObjGeneral );
        
        TabObjTerminales tabObjTerminales = new TabObjTerminales( );
        Registry.register( "tabObjTerminales", tabObjTerminales );

        tabs.add( tabObjGeneral );
        tabs.add( tabObjTerminales );
        RootPanel.get("listadoCursos").add( panelCursos );        
        RootPanel.get("tabs").add( tabs );
    }
}
