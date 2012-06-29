package co.edu.icesi.sam.competencias;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.icesi.sam.bo.MetaTerminalBO;
import co.edu.icesi.sam.bo.ObjetivoEspecificoBO;
import co.edu.icesi.sam.bo.ObjetivoGeneralBO;
import co.edu.icesi.sam.bo.ObjetivoTerminalBO;
import co.edu.icesi.sam.bo.UnidadBO;

/**
 * Session Bean implementation class GestionCompetenciasSession
 */
@Stateless(mappedName = "gestionCompetencias")
public class GestionCompetenciasSession implements GestionCompetenciasSessionRemote
{
    @PersistenceContext
    EntityManager em;

    @Override
    public int agregarUnidad( UnidadBO unidad )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int editarUnidad( UnidadBO unidad )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public UnidadBO buscarUnidad( int idUnidad )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int agregarObjGeneral( ObjetivoGeneralBO objGeneral )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int editarObjGeneral( ObjetivoGeneralBO objGeneral )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ObjetivoGeneralBO buscarObjGeneral( int idCurso )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int agregarObjTerminal( ObjetivoTerminalBO objTerminal )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int editarObjTemrinal( ObjetivoTerminalBO objTerminal )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ObjetivoTerminalBO buscarObjTerminal( int idObjTerminal )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int agregarObjEspecifico( ObjetivoEspecificoBO objEspecifico )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int editarObjEspecifico( ObjetivoEspecificoBO objEspecifico )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ObjetivoEspecificoBO buscarObjEspecifico( int idObjEspecifico )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int agregarMetaTerminal( MetaTerminalBO metaTerminal )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int eliminarMetaTerminal( MetaTerminalBO metaTerminal )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public MetaTerminalBO buscarMetaTerminal( int idMetaTerminal )
    {
        // TODO Auto-generated method stub
        return null;
    }
        
}
