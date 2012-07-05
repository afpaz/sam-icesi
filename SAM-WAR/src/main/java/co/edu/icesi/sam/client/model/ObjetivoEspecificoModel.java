package co.edu.icesi.sam.client.model;

import java.io.Serializable;
import java.util.List;

import com.extjs.gxt.ui.client.data.BaseModel;

public class ObjetivoEspecificoModel extends BaseModel implements Serializable
{
    public ObjetivoEspecificoModel( )
    {
        
    }
    
    public ObjetivoEspecificoModel(int id, String nombre, String contenido)
    {
        set("id", id);
        set("nombre", nombre);
        set("contenido", contenido);
    }

    public int getId( )
    {
        return (Integer) get("id");
    }

    public String getNombre( )
    {
        return (String) get("nombre");
    }

    public String getContenido( )
    {
        return (String) get("contenido");
    }
   
    public void setId( int id )
    {
        set("id", id);
    }

    public void setNombre( String nombre )
    {
        set("nombre", nombre);
    }

    public void setContenido( String contenido )
    {
        set("contenido", contenido);
    }
}
