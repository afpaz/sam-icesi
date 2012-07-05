package co.edu.icesi.sam.client.model;

import java.io.Serializable;
import java.util.List;

import com.extjs.gxt.ui.client.data.BaseModel;

public class MaterialModel extends BaseModel implements Serializable
{   
    public MaterialModel()
    {
        
    }
    
    public MaterialModel(int id, String nombre)
    {
        set("id", id);
        set("nombre", nombre);
    }

    public int getId( )
    {
        return (Integer) get("id");
    }

    public String getNombre( )
    {
        return (String) get("nombre");
    }

    public void setId( int id )
    {
        set("id", id);
    }

    public void setNombre( String nombre )
    {
       set("nombre", nombre);
    }   
}
