/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.colegiocima.app.models.dto.AnioLectivoDTO;
import pe.edu.colegiocima.app.models.dto.projection.AnioLectivoVista;
import pe.edu.colegiocima.app.models.entity.AnioLectivo;

import java.util.List;

/**
 *
 * @author Luis
 */
public interface AnioLectivoRepository extends JpaRepository<AnioLectivo, Short>{
    @Query("select a from AnioLectivo a where a.activo=true order by a.id")
    public List<AnioLectivo> buscarPorACtivo();
    
    //Uso de DTO por proyecciones
    public List<AnioLectivoVista> findByActivoTrueOrderById();
    
    //Uso de DTO por expresiones de constructor
    public List<AnioLectivoDTO>  findByActivoTrueOrderByDescripcion();
    
    @Query("select new pe.edu.colegiocima.app.models.dto.AnioLectivoDTO(a.id,a.descripcion)" +
           " from AnioLectivo a where a.activo=true order by a.id")
    public List<AnioLectivoDTO> busquedaActivo();
}
