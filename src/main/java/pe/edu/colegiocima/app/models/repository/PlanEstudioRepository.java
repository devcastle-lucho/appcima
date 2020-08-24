/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.colegiocima.app.models.entity.PlanEstudio;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Luis
 */
public interface PlanEstudioRepository extends JpaRepository<PlanEstudio, Short>{
    @Query(value="select * from v_listaplanestudio where idannolectivo=?1 and idgrado=?2",nativeQuery = true)
    public List<Map<String,Object>> busquedaPersonalizada(Short idAnioLectivo, Short idGrado);
}
