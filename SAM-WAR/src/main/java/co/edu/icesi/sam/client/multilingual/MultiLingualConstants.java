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

    // Botones
    String btnAgregar_text( );
    String btnEditar_text( );

    // PanelCursos
    String tableCursos_heading( );
    String columnCursos_nombre( );
    String columnCursos_codigo( );

    // Labels Objetivos
    String labNombre_text( );
    String labContenido_text( );

    // TabObjGeneral
    String tabObjGeneral_text( );
    String labObjGeneral_text( );

    // TabObjTerminal
    String tabObjTerminales_text( );

    // TabObjEspeficicos
    String tableMetasTerminales_heading( );
    String columnMetasTerminales_nombreUnidad( );
    String columnMetasTerminales_contenidoUnidad( );
    String columnMetasTerminales_nombreObjTerminal( );
    String columnMetasTerminales_contenidoObjTerminal( );
    
    String tableObjEspecificos_heading();
    String columnObjEspecificos_nombre();
    String columnObjEspecificos_contenido();

    // DialogoAgregarObjTerminal
    String dialogoAgregarObjTerminal_heading( );
}
