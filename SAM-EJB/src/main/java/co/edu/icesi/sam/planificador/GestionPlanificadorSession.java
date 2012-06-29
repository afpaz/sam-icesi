package co.edu.icesi.sam.planificador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.icesi.sam.bo.MaterialBO;
import co.edu.icesi.sam.bo.RecursoAsignadoBO;
import co.edu.icesi.sam.bo.RecursoBO;
import co.edu.icesi.sam.bo.SaberBO;
import co.edu.icesi.sam.bo.SesionBO;
import co.edu.icesi.sam.bo.TrabajoAsignadoBO;

/**
 * Session Bean implementation class GestionPlanificadorSession
 */
@Stateless(mappedName = "gestionPlanificador")
public class GestionPlanificadorSession implements GestionPlanificadorSessionRemote
{
    @PersistenceContext
    EntityManager em;

    @Override
    public int agregarMaterial( MaterialBO material )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int editarMaterial( MaterialBO material )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public MaterialBO buscarMaterial( int idMaterial )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int agregarSaber( SaberBO saber )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int editarSaber( SaberBO saber )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public SaberBO buscarSaber( int idSaber )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int agregarRecurso( RecursoBO recurso )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int editarSaber( RecursoBO recurso )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public RecursoBO buscarRecurso( int idRecurso )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int agregarSesion( SesionBO sesion )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int editarSesion( SesionBO sesion )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public SesionBO buscarSesion( int idSesion )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int agregarTrabajoAsignado( TrabajoAsignadoBO trabajoAsignado )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int editarTrabajoAsignado( TrabajoAsignadoBO trabajoAsignado )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public TrabajoAsignadoBO buscarTrabajoAsignado( int idTrabajoAsignado )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int agregarRecursoAsignado( RecursoAsignadoBO recursoAsignado )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int editarRecursoAsignado( RecursoAsignadoBO recursoAsignado )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public RecursoAsignadoBO buscarRecursoAsignado( int idTrabajoAsignado )
    {
        // TODO Auto-generated method stub
        return null;
    }
}
