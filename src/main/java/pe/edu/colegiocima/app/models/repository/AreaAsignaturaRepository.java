/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pe.edu.colegiocima.app.models.dto.projection.AreaAsignaturaCustom;
import pe.edu.colegiocima.app.models.dto.projection.AreaAsignaturaVista;
import pe.edu.colegiocima.app.models.entity.AreaAsignatura;

import java.util.List;


public interface AreaAsignaturaRepository extends CrudRepository<AreaAsignatura, Short> {
    //JPQL
    @Query("select "
            + "a.id as id,"
            + "b.descripcion as areaCurricularDescripcion, "
            + "c.descripcion as asignaturaDescripcion "
            + "from AreaAsignatura a "
            + "inner join a.areaCurricular b "
            + "inner join a.asignatura c "
            + "order by b.descripcion")
    public List<AreaAsignaturaVista> findCustom();

    public List<AreaAsignaturaCustom> findByOrderByAreaCurricularDescripcion();
}
