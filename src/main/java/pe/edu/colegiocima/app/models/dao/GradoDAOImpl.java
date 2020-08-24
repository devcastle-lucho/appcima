package pe.edu.colegiocima.app.models.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.colegiocima.app.models.entity.Grado;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Objects;

@Repository
public class GradoDAOImpl implements GradoDAO{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional()
    public Short insertar(Grado grado) throws Exception {
        Session session =sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            Short respuesta = session.doReturningWork(cnx -> {
                PreparedStatement ps=cnx.prepareStatement("select  f_insertagrado(?,?,?,?,?)");
                int index=0;
                ps.setObject(++index,grado.getDescripcion(), Types.VARCHAR);
                ps.setObject(++index,grado.getIdNivelColegio(), Types.SMALLINT);
                ps.setObject(++index,grado.getIdGradoAnterior(), Types.SMALLINT);
                ps.setObject(++index,grado.getEdad(), Types.INTEGER);
                ps.setObject(++index,grado.isCirculoEstudio(), Types.BOOLEAN);

                ResultSet rs =ps.executeQuery();
                Short dato = null;
                if(Objects.nonNull(rs) && rs.next()) {
                    dato = rs.getShort(1);
                    rs.close();
                }
                ps.close();
                return dato;
            });
            if(Objects.nonNull(respuesta) && respuesta > 0) {
                session.getTransaction().commit();
            } else {
                session.getTransaction().rollback();
            }
            return respuesta;
        }catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }

    }

    @Override
    public Boolean editar(Grado grado) throws Exception {
        Session session =sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            Boolean respuesta = session.doReturningWork(cnx -> {
                String sql="{ ? = call f_updategrado(?,?,?,?,?,?)}";
                CallableStatement cstm = cnx.prepareCall(sql);
                int index=0;
                cstm.registerOutParameter(++index,Types.BOOLEAN);
                cstm.setObject(++index,grado.getDescripcion(), Types.VARCHAR);
                cstm.setObject(++index,grado.getIdNivelColegio(), Types.SMALLINT);
                cstm.setObject(++index,grado.getIdGradoAnterior(), Types.SMALLINT);
                cstm.setObject(++index,grado.getEdad(), Types.INTEGER);
                cstm.setObject(++index,grado.isCirculoEstudio(), Types.BOOLEAN);
                cstm.setObject(++index,grado.getId(), Types.SMALLINT);

                cstm.execute();
                Boolean dato = cstm.getBoolean(1);
                cstm.close();
                return dato;
            });
            if(Objects.nonNull(respuesta) && Objects.equals(respuesta,Boolean.TRUE)) {
                session.getTransaction().commit();
            } else {
                session.getTransaction().rollback();
            }
            return respuesta;
        }catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
