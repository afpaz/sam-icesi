package co.edu.icesi.sam.client.controller;

import java.util.ArrayList;
import java.util.List;

import co.edu.icesi.sam.bo.CursoBO;
import co.edu.icesi.sam.bo.MaterialBO;
import co.edu.icesi.sam.bo.MetaTerminalBO;
import co.edu.icesi.sam.bo.ObjetivoEspecificoBO;
import co.edu.icesi.sam.bo.ObjetivoTerminalBO;
import co.edu.icesi.sam.client.PanelCursos;
import co.edu.icesi.sam.client.model.CursoModel;
import co.edu.icesi.sam.client.model.MaterialModel;
import co.edu.icesi.sam.client.model.MetaTerminalModel;
import co.edu.icesi.sam.client.model.ObjetivoEspecificoModel;
import co.edu.icesi.sam.client.model.ObjetivoTerminalModel;
import co.edu.icesi.sam.client.tabs.TabMateriales;
import co.edu.icesi.sam.client.tabs.TabObjEspecificos;
import co.edu.icesi.sam.client.tabs.TabObjGeneral;
import co.edu.icesi.sam.client.tabs.TabObjTerminales;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.TabPanel;

public class DTViewController extends Controller
{    
    public DTViewController( )
    {
        registerEventTypes( DTEvent.LISTAR_CURSOS );
        registerEventTypes( DTEvent.ACTUALIZAR_OBJ_GENERAL ); 
        registerEventTypes( DTEvent.LISTAR_MATERIALES );
        registerEventTypes( DTEvent.LISTAR_METAS_TERMINALES );
        registerEventTypes( DTEvent.LISTAR_OBJ_TERMINALES );
        registerEventTypes( DTEvent.LISTAR_OBJ_ESPECIFICOS );
        registerEventTypes( DTEvent.LISTAR_OBJ_ESPECIFICOS_POR_META_TERMINAL );
        registerEventTypes( DTEvent.SELECCIONAR_CURSO );
    }
    
    @Override
    public void handleEvent( AppEvent event )
    {
        if(event.getType( ).equals( DTEvent.LISTAR_CURSOS ))
        {
            List<CursoBO> cursos = (List<CursoBO>) event.getData( );
            ListStore<CursoModel> cursosModel = new ListStore<CursoModel>( );
            
            for(CursoBO bo : cursos)
            {                
                cursosModel.add( CursoModel.toModelFromBO( bo ) );
            }
            
            PanelCursos panelCursos = Registry.get( "panelCursos" );
            panelCursos.actualizarPanel( cursosModel );
        }
        else if(event.getType( ).equals( DTEvent.ACTUALIZAR_OBJ_GENERAL ))
        {                     
            TabObjGeneral tabObjGeneral = Registry.get( "tabObjGeneral" );
            tabObjGeneral.asignarObjGeneral();
        }   
        else if(event.getType( ).equals( DTEvent.LISTAR_MATERIALES ))
        {
            List<MaterialBO> materiales = (List<MaterialBO>) event.getData( );
            ListStore<MaterialModel> materialesModel = new ListStore<MaterialModel>( );
            
            for(MaterialBO bo : materiales)
            {               
                materialesModel.add( MaterialModel.toModelFromBO( bo ) );
            }
            
            TabMateriales tabMateriales = Registry.get( "tabMateriales" );
            tabMateriales.actualizarTablaMateriales( materialesModel );
        }
        else if(event.getType( ).equals( DTEvent.LISTAR_METAS_TERMINALES ))
        {
            List<MetaTerminalBO> metasTerminales = (List<MetaTerminalBO>) event.getData( );
            ListStore<MetaTerminalModel> metasModel = new ListStore<MetaTerminalModel>( );
            
            for(MetaTerminalBO bo : metasTerminales)
            {               
                metasModel.add( MetaTerminalModel.toModelFromBO( bo ) );
            }
            
            TabObjEspecificos tabObjEspecificos = Registry.get( "tabObjEspecificos" );
            tabObjEspecificos.actualizarTablaMetasTerminales( metasModel );
        }
        else if(event.getType( ).equals( DTEvent.LISTAR_OBJ_ESPECIFICOS ))
        {
            List<ObjetivoEspecificoBO> objEspecificos = (List<ObjetivoEspecificoBO>) event.getData( );
            ListStore<ObjetivoEspecificoModel> objModel = new ListStore<ObjetivoEspecificoModel>( );
            
            for(ObjetivoEspecificoBO bo : objEspecificos)
            {               
                objModel.add( ObjetivoEspecificoModel.toModelFromBO( bo ) );
            }
            
            TabObjEspecificos tabObjEspecificos = Registry.get( "tabObjEspecificos" );
            tabObjEspecificos.actualizarTablaObjEspecificos( objModel );
        }
        else if(event.getType( ).equals( DTEvent.LISTAR_OBJ_TERMINALES ))
        {
            List<ObjetivoTerminalBO> objTerminales = (List<ObjetivoTerminalBO>) event.getData( );
            ListStore<ObjetivoTerminalModel> objModel = new ListStore<ObjetivoTerminalModel>( );
            
            for(ObjetivoTerminalBO bo : objTerminales)
            {               
                objModel.add( ObjetivoTerminalModel.toModelFromBO( bo ) );
            }
            
            TabObjTerminales tabObjTerminales = Registry.get( "tabObjTerminales" );
            tabObjTerminales.actualizarTablaObjTerminales( objModel );
        }
        else if(event.getType( ).equals( DTEvent.LISTAR_OBJ_ESPECIFICOS_POR_META_TERMINAL ))
        {
            List<ObjetivoEspecificoBO> objEspecificos = (List<ObjetivoEspecificoBO>) event.getData( );
            ListStore<ObjetivoEspecificoModel> objModel = new ListStore<ObjetivoEspecificoModel>( );
            
            for(ObjetivoEspecificoBO bo : objEspecificos)
            {               
                objModel.add( ObjetivoEspecificoModel.toModelFromBO( bo ) );
            }
            
            TabObjEspecificos tabObjEspecificos = Registry.get( "tabObjEspecificos" );
            tabObjEspecificos.actualizarTablaObjEspecificos( objModel );
        }
        else if(event.getType( ).equals( DTEvent.SELECCIONAR_CURSO ))
        {
            CursoModel cursoModel = (CursoModel) event.getData( );
            Registry.register( "idCurso", cursoModel.getId( ) );
            
            TabPanel tabs = Registry.get( "tabs" );
            tabs.enable( );
                        
            TabObjGeneral tabObjGeneral = Registry.get( "tabObjGeneral" );
            tabObjGeneral.asignarObjGeneral( );
            tabs.setSelection(tabObjGeneral );
        }
    }

}
