package co.edu.icesi.sam.client.controller;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;

public class DTViewController extends Controller
{    
    public DTViewController( )
    {
        registerEventTypes( DTEvent.AGREGAR_MATERIAL );
        registerEventTypes( DTEvent.AGREGAR_META_TERMINAL );
        registerEventTypes( DTEvent.AGREGAR_OBJ_ESPECIFICO );
        registerEventTypes( DTEvent.AGREGAR_OBJ_GENERAL );
        registerEventTypes( DTEvent.AGREGAR_OBJ_TERMINAL );
        registerEventTypes( DTEvent.AGREGAR_RECURSO );
        registerEventTypes( DTEvent.AGREGAR_RECURSO_ASIGNADO );
        registerEventTypes( DTEvent.AGREGAR_SABER );
        registerEventTypes( DTEvent.AGREGAR_SESION );
        registerEventTypes( DTEvent.AGREGAR_TRABAJO_ASIGNADO );
        registerEventTypes( DTEvent.AGREGAR_UNIDAD );
        registerEventTypes( DTEvent.EDITAR_MATERIAL );
        registerEventTypes( DTEvent.EDITAR_OBJ_ESPECIFICO );
        registerEventTypes( DTEvent.EDITAR_OBJ_GENERAL );
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
        else if(event.getType( ).equals( DTEvent.AGREGAR_OBJ_GENERAL ))
        {
            
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
        else if(event.getType( ).equals( DTEvent.EDITAR_OBJ_GENERAL ))
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
            
        }
    }

}
