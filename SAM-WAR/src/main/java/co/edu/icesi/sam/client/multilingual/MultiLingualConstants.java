package co.edu.icesi.sam.client.multilingual;

import com.google.gwt.i18n.client.Constants;

public interface MultiLingualConstants extends Constants
{
    // Mensajes
    String onFailure( );
    String msgAgregar( );
    String msgEditar( );
    String msgEliminar( );
    String msgError( );    

    // PanelCursos
    String tableCursos_heading( );
    String columnCursos_nombre( );
    String columnCursos_codigo( );

    //Botones
    String btnAgregar_text();
    String btnEditar_text();
    // Labels Objetivos
    String labNombre_text( );
    String labContenido_text( );

    // TabObjGeneral
    String tabObjGeneral_text( );
    String labObjGeneral_text( );

    // TabObjTerminal
    String tabObjTerminales_text( );
    
    String tableObjTerminales_heading();
    String columnObjTerminales_nombre();
    String columnObjTerminales_contenido();

    // TabObjEspeficicos
    String tabObjEspecificos_text();
    
    String tableMetasTerminales_heading( );
    String columnMetasTerminales_nombreUnidad( );
    String columnMetasTerminales_contenidoUnidad( );
    String columnMetasTerminales_nombreObjTerminal( );
    String columnMetasTerminales_contenidoObjTerminal( );
    
    String tableObjEspecificos_heading();
    String columnObjEspecificos_nombre();
    String columnObjEspecificos_contenido();

    String msgSeleccionarMetaTerminal();
    String msgMetaTerminal();
    
    // TabMateriales
    String tabMateriales_text();
    
    String listMateriales_heading(); 
    
    // DialogoAgregarObjTerminal
    String dialogoAgregarObjTerminal_heading( );   
    // DialogoEditarObjTerminal
    String dialogoEditarObjTerminal_heading( );
    
    // DialogoAgregarObjEspecifico
    String dialogoAgregarObjEspecifico_heading( );    
    // DialogoEditarObjEspecifico
    String dialogoEditarObjEspecifico_heading( );
    
    // DialogoAgregarMaterial
    String dialogoAgregarMaterial_heading( );
    
    // DialogoEditarMaterial
    String dialogoEditarMaterial_heading( );
}
