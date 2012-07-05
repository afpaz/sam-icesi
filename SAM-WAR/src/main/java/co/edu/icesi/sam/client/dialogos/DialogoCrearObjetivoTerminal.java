package co.edu.icesi.sam.client.dialogos;

import co.edu.icesi.sam.bo.ObjetivoTerminalBO;
import co.edu.icesi.sam.client.competencias.CompetenciasService;
import co.edu.icesi.sam.client.competencias.CompetenciasServiceAsync;
import co.edu.icesi.sam.client.controller.DTEvent;
import co.edu.icesi.sam.client.multilingual.MultiLingualConstants;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.Text;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class DialogoCrearObjetivoTerminal extends Dialog
{
    private final static MultiLingualConstants MultiLingualConstants = GWT.create( MultiLingualConstants.class );
    private final CompetenciasServiceAsync competenciasService = GWT.create( CompetenciasService.class );
    
    private Text labNombre;
    private Text labContenido;
    private TextField<String> txtNombre;
    private TextArea txtContenido;
    private Button btnAgregar;
    
    
    public DialogoCrearObjetivoTerminal()
    {
        setModal( true );
        setHeading( MultiLingualConstants.dialogoAgregarObjTerminal_heading( ) );
        setLayout( new AbsoluteLayout( ) );

        btnAgregar = new Button( MultiLingualConstants.btnAgregar_text( ) );
        add( btnAgregar, new AbsoluteData( 238, 138 ) );

       txtNombre = new TextField<String>( );
        add( txtNombre, new AbsoluteData( 157, 25 ) );
        txtNombre.setSize( "212px", "24px" );    

        txtContenido = new TextArea( );
        add( txtContenido, new AbsoluteData( 157, 72 ) );
        txtContenido.setSize( "212px", "60px" );

        labNombre = new Text( MultiLingualConstants.labNombre_text( ) );
        add( labNombre, new AbsoluteData( 30, 36 ) );

        labContenido = new Text( MultiLingualConstants.labContenido_text( ) );
        add( labContenido, new AbsoluteData( 30, 72 ) );
    }
    
    public void eventoAgregarObjTerminal()
    {
        btnAgregar.addSelectionListener( new SelectionListener<ButtonEvent>( )
        {
            
            @Override
            public void componentSelected( ButtonEvent ce )
            {
                agregarObjTerminal();                
            }
        } );
    }       
    
    private void agregarObjTerminal( )
    {   
        ObjetivoTerminalBO objTerminal = new ObjetivoTerminalBO( );
        objTerminal.setNombre( txtNombre.getValue( ) );
        objTerminal.setContenido( txtContenido.getValue( ) );
        competenciasService.agregarObjTerminal( objTerminal, new AsyncCallback<Integer>( )
        {            
            @Override
            public void onSuccess( Integer result )
            {           
                limpiarDatos( );          
                Dispatcher.forwardEvent( DTEvent.AGREGAR_OBJ_TERMINAL, result );
            }
            
            @Override
            public void onFailure( Throwable caught )
            {
                // TODO Auto-generated method stub                
            }
        } );
    }
    
    private void limpiarDatos()
    {
        txtNombre.clear( );
        txtContenido.clear( );
        hide();
    }
}
