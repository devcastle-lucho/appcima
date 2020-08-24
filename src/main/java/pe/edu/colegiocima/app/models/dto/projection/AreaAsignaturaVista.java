/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.models.dto.projection;

import org.springframework.beans.factory.annotation.Value;

/**
 *
 *  DTO via proyeccion abierta para entidades relacionadas 
 */
public interface AreaAsignaturaVista {
    public Short getId();
    @Value("#{target.areaCurricularDescripcion} / #{target.asignaturaDescripcion}")
    public String getDescripcion();
    @Value("#{target.areaCurricularDescripcion}")
    public String getAreaCurricular();
    @Value("#{target.asignaturaDescripcion}")    
    public String getAsignatura();
}
