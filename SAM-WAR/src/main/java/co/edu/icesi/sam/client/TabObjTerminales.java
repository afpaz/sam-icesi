package co.edu.icesi.sam.client;

import java.util.ArrayList;
import java.util.List;

import co.edu.icesi.sam.client.competencias.CompetenciasService;
import co.edu.icesi.sam.client.competencias.CompetenciasServiceAsync;
import co.edu.icesi.sam.client.dialogos.DialogoCrearObjetivoTerminal;
import co.edu.icesi.sam.client.dialogos.DialogoEditarObjetivoTerminal;
import co.edu.icesi.sam.client.model.CursoModel;
import co.edu.icesi.sam.client.multilingual.MultiLingualConstants;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
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
	private ColumnModel cmObjs;
	private Grid<CursoModel> gridObjTerminal;
    
    public TabObjTerminales( )
    {
        setText( MultiLingualConstants.tabObjTerminales_text( ) );
        setSize( 437, 444 );
        LayoutContainer container = new LayoutContainer( );
        container.setLayout( new AbsoluteLayout( ) );

        labObjGeneral = new Text( MultiLingualConstants.labObjGeneral_text( ) );
        container.add( labObjGeneral, new AbsoluteData( 36, 6 ) );

        txtObjGeneral = new TextArea( );
        txtObjGeneral.setSize( "380px", "60px" );       
        container.add( txtObjGeneral, new AbsoluteData( 36, 30 ) );

        Button btnAgregar = new Button( MultiLingualConstants.btnAgregar_text( ) );
        container.add( btnAgregar, new AbsoluteData( 210, 257 ) );

//        Table table = new Table( new TableColumnModel( new TableColumn( "id.1", "Objetivo Terminal", 0.3f ), new TableColumn( "id.2", "Contenido", 0.7f ) ) );
//        container.add( table, new AbsoluteData( 36, 105 ) );
//        table.setSize( "376px", "146px" );
        
        
        
    	//CARGA LA TABLA DE OBJETIVOS TERMINALES
		List<ColumnConfig> configsObjTerminales = new ArrayList<ColumnConfig>();  

		ColumnConfig columnObj = new ColumnConfig();    
		columnObj.setId("id");    
		columnObj.setHeader("Identificacion");    
		columnObj.setWidth(80);
		columnObj.setHidden(true);
		configsObjTerminales.add(columnObj);  

		columnObj = new ColumnConfig("objetivoTerminal", "Objetivo Terminal", 100);    
		columnObj.setAlignment(HorizontalAlignment.LEFT);    
		configsObjTerminales.add(columnObj);  

		columnObj = new ColumnConfig("contenido", "Contenido", 150);    
		columnObj.setAlignment(HorizontalAlignment.LEFT);    
		configsObjTerminales.add(columnObj);  

		ListStore<CursoModel> listaObjs = new ListStore<CursoModel>();    
		//employeeList.add(TestData.getEmployees()); 

		cmObjs = new ColumnModel(configsObjTerminales);  
		gridObjTerminal = new Grid<CursoModel>(listaObjs, cmObjs);   
		gridObjTerminal.setStyleAttribute("borderTop", "none");   
		gridObjTerminal.setAutoExpandColumn("name");   
		gridObjTerminal.setBorders(true);   
		gridObjTerminal.setStripeRows(true); 

		ContentPanel cpObjs = new ContentPanel();    
		cpObjs.setBodyBorder(false);    
		cpObjs.setHeading("Lista de Objetivos Terminales:");    
		cpObjs.setButtonAlign(HorizontalAlignment.CENTER);    
		cpObjs.setLayout(new FitLayout());    
		cpObjs.setSize(376, 146);   
		cpObjs.add(gridObjTerminal);    
		gridObjTerminal.setHeight("305px");
		container.add(cpObjs, new AbsoluteData(36, 105));

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
