package co.edu.icesi.sam.client.controller;

import java.util.ArrayList;
import java.util.List;

import co.edu.icesi.sam.bo.CursoBO;
import co.edu.icesi.sam.client.PanelCursos;
import co.edu.icesi.sam.client.TabObjGeneral;
import co.edu.icesi.sam.client.model.CursoModel;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.TabPanel;

public class DTViewController extends Controller
{    
    public DTViewController( )
    {
        registerEventTypes( DTEvent.ACTUALIZAR_LISTADO_CURSOS );
        registerEventTypes( DTEvent.ACTUALIZAR_OBJ_GENERAL );
        registerEventTypes( DTEvent.AGREGAR_MATERIAL );
        registerEventTypes( DTEvent.AGREGAR_META_TERMINAL );
        registerEventTypes( DTEvent.AGREGAR_OBJ_ESPECIFICO );
        registerEventTypes( DTEvent.AGREGAR_OBJ_TERMINAL );
        registerEventTypes( DTEvent.AGREGAR_RECURSO );
        registerEventTypes( DTEvent.AGREGAR_RECURSO_ASIGNADO );
        registerEventTypes( DTEvent.AGREGAR_SABER );
        registerEventTypes( DTEvent.AGREGAR_SESION );
        registerEventTypes( DTEvent.AGREGAR_TRABAJO_ASIGNADO );
        registerEventTypes( DTEvent.AGREGAR_UNIDAD );
        registerEventTypes( DTEvent.EDITAR_MATERIAL );
        registerEventTypes( DTEvent.EDITAR_OBJ_ESPECIFICO );    
        registerEventTypes( DTEvent.EDITAR_OBJ_TERMINAL );
        registerEventTypes( DTEvent.EDITAR_RECURSO_ASIGNADO );
        registerEventTypes( DTEvent.EDITAR_SABER );
        registerEventTypes( DTEvent.EDITAR_SESION );
        registerEventTypes( DTEvent.EDITAR_TRABAJO_ASIGNADO );
        registerEventTypes( DTEvent.EDITAR_UNIDAD );  
        registerEventTypes( DTEvent.ELIMINAR_META_TERMINAL );
        registerEventTypes( DTEvent.SELECCIONAR_CURSO );
    }
    
    @Override
    public void handleEvent( AppEvent event )
    {
        if(event.getType( ).equals( DTEvent.AGREGAR_MATERIAL ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.AGREGAR_META_TERMINAL ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.AGREGAR_OBJ_ESPECIFICO ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.ACTUALIZAR_LISTADO_CURSOS ))
        {
            List<CursoBO> cursos = (List<CursoBO>) event.getData( );
            ListStore<CursoModel> cursosModel = new ListStore<CursoModel>( );
            
            for(CursoBO bo : cursos)
            {
                CursoModel model = new CursoModel( );
                cursosModel.add( model.toModelFromBO( bo ) );
            }
            
            PanelCursos panelCursos = Registry.get( "panelCursos" );
            panelCursos.actualizarPanel( cursosModel );
        }
        else if(event.getType( ).equals( DTEvent.ACTUALIZAR_OBJ_GENERAL ))
        {                     
            TabObjGeneral tabObjGeneral = Registry.get( "tabObjGeneral" );
            tabObjGeneral.asignarObjGeneral();
        }
        else if(event.getType( ).equals( DTEvent.AGREGAR_META_TERMINAL ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.AGREGAR_OBJ_TERMINAL ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.AGREGAR_RECURSO ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.AGREGAR_RECURSO_ASIGNADO ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.AGREGAR_SABER ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.AGREGAR_SESION ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.AGREGAR_TRABAJO_ASIGNADO ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.AGREGAR_UNIDAD ))
        {
            
        }
        if(event.getType( ).equals( DTEvent.EDITAR_MATERIAL ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.EDITAR_OBJ_ESPECIFICO ))
        {
            
        }    
        else if(event.getType( ).equals( DTEvent.EDITAR_OBJ_TERMINAL ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.EDITAR_RECURSO_ASIGNADO ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.EDITAR_SABER ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.EDITAR_SESION ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.EDITAR_TRABAJO_ASIGNADO ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.EDITAR_UNIDAD ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.ELIMINAR_META_TERMINAL ))
        {
            
        }
        else if(event.getType( ).equals( DTEvent.SELECCIONAR_CURSO ))
        {
            CursoModel cursoModel = (CursoModel) event.getData( );
            Registry.register( "idCurso", cursoModel.getId( ) );
            
            TabPanel tabs = Registry.get( "tabs" );
            tabs.enable( );
            
            TabObjGeneral tabObjGeneral = Registry.get( "tabObjGeneral" );
            tabObjGeneral.asignarObjGeneral( );
        }
    }

}
