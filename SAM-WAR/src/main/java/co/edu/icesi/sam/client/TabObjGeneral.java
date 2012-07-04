package co.edu.icesi.sam.client;

import co.edu.icesi.sam.bo.ObjetivoGeneralBO;
import co.edu.icesi.sam.client.competencias.CompetenciasService;
import co.edu.icesi.sam.client.competencias.CompetenciasServiceAsync;
import co.edu.icesi.sam.client.controller.DTEvent;
import co.edu.icesi.sam.client.multilingual.MultiLingualConstants;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.DomEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.WidgetListener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.gargoylesoftware.htmlunit.javascript.host.Event;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class TabObjGeneral extends TabItem
{
    private final static MultiLingualConstants MultiLingualConstants = GWT.create( MultiLingualConstants.class );
    private final CompetenciasServiceAsync competenciasService = GWT.create( CompetenciasService.class );

    private int idObjGeneral;

    private TextArea txtObjGeneral;
    private Text labObjGeneral;
    private Button btnGuardar;

    public TabObjGeneral( )
    {
        setText( MultiLingualConstants.tabObjGeneral_text( ) );
        setSize( 800, 600);
        
        LayoutContainer container = new LayoutContainer( );
        container.setLayout( new AbsoluteLayout( ) );     

        txtObjGeneral = new TextArea( );
        txtObjGeneral.setSize( "342px", "125px" );
        container.add( txtObjGeneral, new AbsoluteData( 52, 52 ) );

        labObjGeneral = new Text( MultiLingualConstants.labObjGeneral_text( ) );
        container.add( labObjGeneral, new AbsoluteData( 52, 28 ) );

        btnGuardar = new Button( MultiLingualConstants.btnAgregar_text( ) );
        container.add( btnGuardar, new AbsoluteData( 194, 183 ) );
       
        add(container);
        
        eventoOnLoad( );
        eventoAgregarObjGeneral( );
        eventoEditarObjGeneral( );
    }

    public void eventoOnLoad( )
    {
        this.addListener( Events.OnClick, new Listener<DomEvent>( )
        {

            @Override
            public void handleEvent( DomEvent be )
            {
               Registry.register( "idCurso", 1 );
               asignarObjGeneral( );
            }
        } );
    }

    public void eventoAgregarObjGeneral( )
    {
        btnGuardar.addSelectionListener( new SelectionListener<ButtonEvent>( )
        {

            @Override
            public void componentSelected( ButtonEvent ce )
            {
                if( btnGuardar.getText( ).equals( MultiLingualConstants.btnAgregar_text( )) )
                {
                    agregarObjGeneral( );
                }
            }
        } );
    }

    public void eventoEditarObjGeneral( )
    {
        btnGuardar.addSelectionListener( new SelectionListener<ButtonEvent>( )
        {

            @Override
            public void componentSelected( ButtonEvent ce )
            {
                if( btnGuardar.getText( ).equals( MultiLingualConstants.btnEditar_text( ) ) )
                {
                    editarObjGeneral( );
                }
            }
        } );
    }

    private void agregarObjGeneral( )
    {
        ObjetivoGeneralBO objGeneral = new ObjetivoGeneralBO( );
        objGeneral.setContenido( txtObjGeneral.getValue( ) );

        competenciasService.agregarObjGeneral( objGeneral, new AsyncCallback<Integer>( )
        {
            @Override
            public void onSuccess( Integer result )
            {
                Dispatcher.forwardEvent( DTEvent.AGREGAR_OBJ_GENERAL, result );
            }

            @Override
            public void onFailure( Throwable caught )
            {
                // TODO Auto-generated method stub
            }
        } );
    }

    private void editarObjGeneral( )
    {
        ObjetivoGeneralBO objGeneral = new ObjetivoGeneralBO( );
        objGeneral.setId( idObjGeneral );
        objGeneral.setContenido( txtObjGeneral.getValue( ) );
        objGeneral.setIdCurso( ( Integer )Registry.get( "idCurso" ) );

        competenciasService.editarObjGeneral( objGeneral, new AsyncCallback<Integer>( )
        {
            @Override
            public void onSuccess( Integer result )
            {
                Dispatcher.forwardEvent( DTEvent.EDITAR_OBJ_GENERAL, result );
            }

            @Override
            public void onFailure( Throwable caught )
            {
                // TODO Auto-generated method stub
            }
        } );
    }

    public void asignarObjGeneral( )
    {
        competenciasService.buscarObjGeneral( ( Integer )Registry.get( "idCurso" ), new AsyncCallback<ObjetivoGeneralBO>( )
        {
            @Override
            public void onSuccess( ObjetivoGeneralBO objGeneral )
            {
                if( objGeneral != null )
                {
                    txtObjGeneral.setValue( objGeneral.getContenido( ) );
                    idObjGeneral = objGeneral.getId( );
                    btnGuardar.setText( MultiLingualConstants.btnEditar_text( ) );
                }
                else
                {
                    btnGuardar.setText( MultiLingualConstants.btnAgregar_text( ) );
                }
            }

            @Override
            public void onFailure( Throwable caught )
            {
                // TODO Auto-generated method stub
            }
        } );
    }
}
