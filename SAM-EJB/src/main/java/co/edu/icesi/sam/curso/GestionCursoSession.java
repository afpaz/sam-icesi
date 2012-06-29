package co.edu.icesi.sam.curso;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.icesi.sam.bo.CursoBO;

/**
 * Session Bean implementation class GestionCursoSession
 */
@Stateless(mappedName = "gestionCurso")
public class GestionCursoSession implements GestionCursoSessionRemote
{
    @PersistenceContext
    EntityManager em;

    @Override
    public int agregarCurso( CursoBO curso )
    {
//        Curso entidad = null;
        return 0;
    }

    @Override
    public int editarCurso( CursoBO curso )
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public CursoBO buscarCurso( int idCurso )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CursoBO> listarCursos( )
    {
        // TODO Auto-generated method stub
        return null;
    }
}
