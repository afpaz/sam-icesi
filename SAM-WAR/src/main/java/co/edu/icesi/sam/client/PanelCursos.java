package co.edu.icesi.sam.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import co.edu.icesi.sam.bo.CursoBO;
import co.edu.icesi.sam.client.controller.DTEvent;
import co.edu.icesi.sam.client.curso.CursoService;
import co.edu.icesi.sam.client.curso.CursoServiceAsync;
import co.edu.icesi.sam.client.model.CursoModel;
import co.edu.icesi.sam.client.multilingual.MultiLingualConstants;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class PanelCursos extends LayoutContainer
{

    private final static MultiLingualConstants MultiLingualConstants = GWT.create( MultiLingualConstants.class );
    private final CursoServiceAsync cursoService = GWT.create( CursoService.class );

    private Grid<CursoModel> grid;
    private String[] datosNombresColumnas;

    public PanelCursos( )
    {
        grid = new Grid<CursoModel>( new ListStore<CursoModel>( ), getColumnModel( ) );
        grid.setBorders( true );
        grid.setStripeRows( true );

        ContentPanel cp = new ContentPanel( );
        cp.setBodyBorder( false );
        cp.setHeading( MultiLingualConstants.tableCursos_heading( ) );
        cp.setButtonAlign( HorizontalAlignment.CENTER );
        cp.setLayout( new FitLayout( ) );
        cp.setSize( 310, 600 );
        cp.add( grid );

        add( cp );

        cargarCursos( );
        eventoSeleccionarCurso( );
    }

    private void cargarCursos( )
    {       
        cursoService.listarCursos( new AsyncCallback<List<CursoBO>>( )
        {            
            @Override
            public void onSuccess( List<CursoBO> result )
            {
                Dispatcher.forwardEvent( DTEvent.ACTUALIZAR_LISTADO_CURSOS, result );                
            }
            
            @Override
            public void onFailure( Throwable caught )
            {
                Info.display( "Error", Mensajero.ON_FAILURE);                
            }
        } );
    }

    public void eventoSeleccionarCurso( )
    {
        grid.addListener( Events.OnClick, new Listener<GridEvent<BaseModel>>( )
        {
            public void handleEvent( GridEvent<BaseModel> be )
            {
                CursoModel cursoModel = (CursoModel) be.getGrid( ).getSelectionModel( ).getSelectedItem( );
                Dispatcher.forwardEvent( DTEvent.SELECCIONAR_CURSO, cursoModel );
            }
        } );

    }

    public void actualizarPanel( ListStore<CursoModel> listaCursos)
    {
        grid.reconfigure( listaCursos, getColumnModel( ) );
    }

    private ColumnModel getColumnModel( )
    {
        List<ColumnConfig> configs = new ArrayList<ColumnConfig>( );

        ColumnConfig column = new ColumnConfig( "id", 10 );
        column.setHidden( true );
        configs.add( column );

        column = new ColumnConfig( "codigo", MultiLingualConstants.columnCursos_codigo( ), 50 );
        column.setAlignment( HorizontalAlignment.CENTER );
        configs.add( column );

        column = new ColumnConfig( "nombre", MultiLingualConstants.columnCursos_nombre( ), 250 );
        column.setAlignment( HorizontalAlignment.LEFT );
        configs.add( column );

        return new ColumnModel( configs );
    }

}
