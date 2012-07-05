package co.edu.icesi.sam.client.controller;

import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;

public class DTEvent
{      
    public final static EventType ACTUALIZAR_LISTADO_CURSOS = new EventType( );
    public final static EventType ACTUALIZAR_OBJ_GENERAL = new EventType( );
    public final static EventType SELECCIONAR_CURSO = new EventType( );
    public final static EventType AGREGAR_OBJ_TERMINAL = new EventType( );
    public final static EventType EDITAR_OBJ_TERMINAL = new EventType( );
    public final static EventType AGREGAR_UNIDAD = new EventType( );
    public final static EventType EDITAR_UNIDAD = new EventType( );
    public final static EventType AGREGAR_META_TERMINAL = new EventType( );
    public final static EventType ELIMINAR_META_TERMINAL = new EventType( );
    public final static EventType AGREGAR_OBJ_ESPECIFICO = new EventType( );
    public final static EventType EDITAR_OBJ_ESPECIFICO = new EventType( );
    public final static EventType AGREGAR_SABER = new EventType( );
    public final static EventType EDITAR_SABER = new EventType( );
    public final static EventType AGREGAR_MATERIAL = new EventType( );
    public final static EventType EDITAR_MATERIAL = new EventType( );
    public final static EventType AGREGAR_RECURSO = new EventType( );
    public final static EventType AGREGAR_SESION = new EventType( );
    public final static EventType EDITAR_SESION = new EventType( );
    public final static EventType AGREGAR_TRABAJO_ASIGNADO = new EventType( );
    public final static EventType EDITAR_TRABAJO_ASIGNADO = new EventType( );
    public final static EventType AGREGAR_RECURSO_ASIGNADO = new EventType( );
    public final static EventType EDITAR_RECURSO_ASIGNADO = new EventType( );
    
    public static AppEvent getAppEvent(EventType ev)
    {
        return new AppEvent(ev);
    }
}
