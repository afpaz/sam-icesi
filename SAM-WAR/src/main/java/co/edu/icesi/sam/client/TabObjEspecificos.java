package co.edu.icesi.sam.client;

import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import co.edu.icesi.sam.bo.MetaTerminalBO;
import co.edu.icesi.sam.bo.ObjetivoEspecificoBO;
import co.edu.icesi.sam.client.competencias.CompetenciasService;
import co.edu.icesi.sam.client.competencias.CompetenciasServiceAsync;
import co.edu.icesi.sam.client.controller.DTEvent;
import co.edu.icesi.sam.client.listados.ListadosService;
import co.edu.icesi.sam.client.listados.ListadosServiceAsync;
import co.edu.icesi.sam.client.model.CursoModel;
import co.edu.icesi.sam.client.model.MetaTerminalModel;
import co.edu.icesi.sam.client.model.ObjetivoEspecificoModel;
import co.edu.icesi.sam.client.model.ObjetivoTerminalModel;
import co.edu.icesi.sam.client.multilingual.MultiLingualConstants;

public class TabObjEspecificos extends LayoutContainer
{
    private final static MultiLingualConstants MultiLingualConstants = GWT.create( MultiLingualConstants.class );
    private final CompetenciasServiceAsync competenciasService = GWT.create( CompetenciasService.class );
    private final ListadosServiceAsync listadosService = GWT.create( ListadosService.class );

    private Grid<ObjetivoEspecificoModel> gridObjEspecificos;
    private Grid<MetaTerminalModel> gridMetasTerminales;
    private String[] datosNombresColumnas;

    public TabObjEspecificos( )
    {
        LayoutContainer container = new LayoutContainer( );
        container.setLayout( new AbsoluteLayout( ) );

        gridMetasTerminales = new Grid<MetaTerminalModel>( new ListStore<MetaTerminalModel>( ), getColumnModelMetasTerminales( ) );
        gridMetasTerminales.setBorders( true );
        gridMetasTerminales.setStripeRows( true );

        ContentPanel cpUnidad = new ContentPanel( );
        cpUnidad.setBodyBorder( false );
        cpUnidad.setHeading( MultiLingualConstants.tableMetasTerminales_heading( ) );
        cpUnidad.setButtonAlign( HorizontalAlignment.CENTER );
        cpUnidad.setLayout( new FitLayout( ) );
        cpUnidad.setSize( 510, 93 );
        cpUnidad.add( gridMetasTerminales );
        container.add( cpUnidad, new AbsoluteData( 36, 30 ) );

        gridObjEspecificos = new Grid<ObjetivoEspecificoModel>( new ListStore<ObjetivoEspecificoModel>( ), getColumnModelObjEspecificos( ) );
        gridObjEspecificos.setBorders( true );
        gridObjEspecificos.setStripeRows( true );

        ContentPanel cpObj = new ContentPanel( );
        cpObj.setBodyBorder( false );
        cpObj.setHeading( MultiLingualConstants.tableObjEspecificos_heading( ) );
        cpObj.setButtonAlign( HorizontalAlignment.CENTER );
        cpObj.setLayout( new FitLayout( ) );
        cpObj.setSize( 235, 116 );
        cpObj.add( gridObjEspecificos );

        container.add( cpObj, new AbsoluteData( 36, 156 ) );

        add(container);
        eventoCargarTab( );
        eventos( );
    }
    
    private void eventoCargarTab()
    {
        this.addListener( Events.Select, new Listener<BaseEvent>( )
        {
            @Override
            public void handleEvent( BaseEvent be )
            {            
                cargarMetasTerminales( );
                cargarObjetivosEspecificos( );
            }
        } );
    }
    
    private void cargarMetasTerminales( )
    {
        int idCurso = Registry.get( "idCurso" );
        listadosService.listarMetasTerminalesPorCurso( idCurso, new AsyncCallback<List<MetaTerminalBO>>( )
        {            
            @Override
            public void onSuccess( List<MetaTerminalBO> result )
            {                
                Dispatcher.forwardEvent( DTEvent.ACTUALIZAR_METAS_TERMINALES, result );
            }
            
            @Override
            public void onFailure( Throwable caught )
            {
                Info.display( "Error", Mensajero.ON_FAILURE );
            }
        });
    }

    private void cargarObjetivosEspecificos( )
    {
        int idCurso = Registry.get( "idCurso" );
        listadosService.listarObjEspecificosPorCurso( idCurso, new AsyncCallback<List<ObjetivoEspecificoBO>>( )
        {
            @Override
            public void onSuccess( List<ObjetivoEspecificoBO> result )
            {
                Dispatcher.forwardEvent( DTEvent.ACTUALIZAR_OBJ_ESPECIFICOS, result);              
            }
            

            @Override
            public void onFailure( Throwable caught )
            {
                Info.display( "Error", Mensajero.ON_FAILURE );                
            }
            
        } );
    }

    public void eventos( )
    {

        gridMetasTerminales.addListener( Events.OnClick, new Listener<GridEvent<BaseModel>>( )
        {
            public void handleEvent( GridEvent<BaseModel> be )
            {

                if( be.getGrid( ).getSelectionModel( ).getSelectedItem( ) != null )
                {
                    Map<String, Object> d = be.getGrid( ).getSelectionModel( ).getSelectedItem( ).getProperties( );
                    datosNombresColumnas = new String[d.size( )];
                    Set<String> id_columnas = d.keySet( );
                    Iterator<String> iter = id_columnas.iterator( );
                    int i = 0;
                    while( iter.hasNext( ) )
                        datosNombresColumnas[ i++ ] = iter.next( );
                    for( String x : datosNombresColumnas )
                        System.out.println( "x - " + x );
                }
            }
        } );

        gridObjEspecificos.addListener( Events.OnClick, new Listener<GridEvent<BaseModel>>( )
        {
            public void handleEvent( GridEvent<BaseModel> be )
            {

                if( be.getGrid( ).getSelectionModel( ).getSelectedItem( ) != null )
                {
                    Map<String, Object> d = be.getGrid( ).getSelectionModel( ).getSelectedItem( ).getProperties( );
                    datosNombresColumnas = new String[d.size( )];
                    Set<String> id_columnas = d.keySet( );
                    Iterator<String> iter = id_columnas.iterator( );
                    int i = 0;
                    while( iter.hasNext( ) )
                        datosNombresColumnas[ i++ ] = iter.next( );
                    for( String x : datosNombresColumnas )
                        System.out.println( "x - " + x );
                }
            }
        } );

    }

    public void actualizarTablaMetasTerminales( ListStore<MetaTerminalModel> metasTerminales )
    {
        gridMetasTerminales.reconfigure( metasTerminales, getColumnModelMetasTerminales( ) );
    }

    public void actualizarTablaObjEspecificos( ListStore<ObjetivoEspecificoModel> objEspecificos )
    {
        gridObjEspecificos.reconfigure( objEspecificos, getColumnModelObjEspecificos( ) );
    }

    private ColumnModel getColumnModelMetasTerminales( )
    {
        List<ColumnConfig> configsMetaTerminal = new ArrayList<ColumnConfig>( );

        ColumnConfig columnMetaTerminal = new ColumnConfig( "id", 10 );
        columnMetaTerminal.setHidden( true );
        configsMetaTerminal.add( columnMetaTerminal );

        columnMetaTerminal = new ColumnConfig( "nombreUnidad", MultiLingualConstants.columnMetasTerminales_nombreUnidad( ), 25 );
        columnMetaTerminal.setAlignment( HorizontalAlignment.LEFT );
        configsMetaTerminal.add( columnMetaTerminal );

        columnMetaTerminal = new ColumnConfig( "contenidoUnidad", MultiLingualConstants.columnMetasTerminales_contenidoUnidad( ), 200 );
        columnMetaTerminal.setAlignment( HorizontalAlignment.LEFT );
        configsMetaTerminal.add( columnMetaTerminal );

        columnMetaTerminal = new ColumnConfig( "nombreObjTerminal", MultiLingualConstants.columnMetasTerminales_nombreObjTerminal( ), 25 );
        columnMetaTerminal.setAlignment( HorizontalAlignment.LEFT );
        configsMetaTerminal.add( columnMetaTerminal );

        columnMetaTerminal = new ColumnConfig( "contenidoObjTerminal", MultiLingualConstants.columnMetasTerminales_contenidoObjTerminal( ), 200 );
        columnMetaTerminal.setAlignment( HorizontalAlignment.LEFT );
        configsMetaTerminal.add( columnMetaTerminal );

        return new ColumnModel( configsMetaTerminal );
    }

    private ColumnModel getColumnModelObjEspecificos( )
    {
        List<ColumnConfig> configsObj = new ArrayList<ColumnConfig>( );

        ColumnConfig columnObj = new ColumnConfig( "id", 10 );
        configsObj.add( columnObj );

        columnObj = new ColumnConfig( "nombre", MultiLingualConstants.columnObjEspecificos_nombre( ), 25 );
        columnObj.setAlignment( HorizontalAlignment.LEFT );
        configsObj.add( columnObj );

        columnObj = new ColumnConfig( "contenido", MultiLingualConstants.columnObjEspecificos_contenido( ), 200 );
        columnObj.setAlignment( HorizontalAlignment.LEFT );
        configsObj.add( columnObj );

        return new ColumnModel( configsObj );
    }
}
