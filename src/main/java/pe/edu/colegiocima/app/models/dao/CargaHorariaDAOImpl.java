/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.models.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.colegiocima.app.models.dto.udt.CargaHorariaUDT;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Objects;

@Repository
public class CargaHorariaDAOImpl implements CargaHorariaDAO{
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Integer generar(Short bimestre, Short idPlanEstudio, Short[] idDocente, Short[] idGradoSeccion, Short idUsuario, Integer size) {
        Session session =sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            Integer respuesta =session.doReturningWork((cnx) -> {
                PreparedStatement ps=cnx.prepareStatement("select f_insertacargahoraria(?,?,?,?,?,?)");
                int index=0;
                ps.setObject(++index,bimestre, Types.SMALLINT);
                ps.setObject(++index,idPlanEstudio, Types.SMALLINT);
                Array inArrayD =cnx.createArrayOf("smallint", idDocente);
                ps.setObject(++index,inArrayD, Types.ARRAY);
                Array inArrayGS =cnx.createArrayOf("smallint", idGradoSeccion);
                ps.setObject(++index,inArrayGS, Types.ARRAY);
                ps.setObject(++index,idUsuario, Types.SMALLINT);
                ps.setObject(++index,size, Types.INTEGER);
                
                ResultSet rs =ps.executeQuery();
                Integer dato =null;
                if(Objects.nonNull(rs) && rs.next()){
                    dato = rs.getInt(1);
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
    public Integer generar(Short bimestre, Short idPlanEstudio, CargaHorariaUDT[] aCargaHoraria, Short idUsuario) {
        Session session =sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            Integer respuesta =session.doReturningWork((cnx) -> {
                PreparedStatement ps=cnx.prepareStatement("select f_insertacargahoraria(?,?,?,?)");
                int index=0;
                ps.setObject(++index,bimestre, Types.SMALLINT);
                ps.setObject(++index,idPlanEstudio, Types.SMALLINT);
                Array inArray =cnx.createArrayOf(CargaHorariaUDT.TYPE_NAME, aCargaHoraria);
                ps.setObject(++index,inArray, Types.ARRAY);                
                ps.setObject(++index,idUsuario, Types.SMALLINT);                
                
                ResultSet rs =ps.executeQuery();
                Integer dato =null;
                if(Objects.nonNull(rs) && rs.next()){
                    dato = rs.getInt(1);
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
}
