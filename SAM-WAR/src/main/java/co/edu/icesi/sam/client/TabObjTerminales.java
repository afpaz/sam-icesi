package co.edu.icesi.sam.client;

import co.edu.icesi.sam.client.competencias.CompetenciasService;
import co.edu.icesi.sam.client.competencias.CompetenciasServiceAsync;
import co.edu.icesi.sam.client.dialogos.DialogoCrearObjetivoTerminal;
import co.edu.icesi.sam.client.dialogos.DialogoEditarObjetivoTerminal;
import co.edu.icesi.sam.client.multilingual.*;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.table.Table;
import com.extjs.gxt.ui.client.widget.table.TableColumnModel;
import com.extjs.gxt.ui.client.widget.table.TableColumn;
import com.google.gwt.core.client.GWT;

public class TabObjTerminales extends TabItem
{
    private final static MultiLingualConstants MultiLingualConstants = GWT.create( MultiLingualConstants.class );
    private final CompetenciasServiceAsync competenciasService = GWT.create( CompetenciasService.class );
   
    private DialogoCrearObjetivoTerminal dialogoAgregarObjTerminal;
    private DialogoEditarObjetivoTerminal dialogoEditarObjTerminal;
    
    private Text labObjGeneral;
    private TextArea txtObjGeneral;
    private Button btnAgregar;
    
    public TabObjTerminales( )
    {
        setText( MultiLingualConstants.tabObjTerminales_text( ) );
        setSize( 800, 600 );
        LayoutContainer container = new LayoutContainer( );
        container.setLayout( new AbsoluteLayout( ) );

        labObjGeneral = new Text( MultiLingualConstants.labObjGeneral_text( ) );
        container.add( labObjGeneral, new AbsoluteData( 36, 6 ) );

        txtObjGeneral = new TextArea( );
        txtObjGeneral.setSize( "380px", "60px" );       
        container.add( txtObjGeneral, new AbsoluteData( 36, 30 ) );

        Button btnAgregar = new Button( MultiLingualConstants.btnAgregar_text( ) );
        container.add( btnAgregar, new AbsoluteData( 210, 257 ) );

        Table table = new Table( new TableColumnModel( new TableColumn( "id.1", "Objetivo Terminal", 0.3f ), new TableColumn( "id.2", "Contenido", 0.7f ) ) );
        container.add( table, new AbsoluteData( 36, 105 ) );
        table.setSize( "376px", "146px" );

        add( container );
    }
    
    public void inicializarDialogos()
    {
        dialogoAgregarObjTerminal = new DialogoCrearObjetivoTerminal( );
    }
    
    public void eventoAgregarObjTerminal()
    {
        btnAgregar.addSelectionListener( new SelectionListener<ButtonEvent>( )
        {            
            @Override
            public void componentSelected( ButtonEvent ce )
            {                
                habilitarDialogoAgregarObjTerminal();
            }
        } );
    }
    
    private void habilitarDialogoAgregarObjTerminal()
    {
        dialogoAgregarObjTerminal.show( );   
    }
}
