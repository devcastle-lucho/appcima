/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.models.dto.projection;

/**
 *
 * DTO via proyeccion cerrada para entidades relacionadas con la estrategia de 
 * Interfaces Anidadas
 */
public interface AreaAsignaturaCustom {
    public Short getId();
    public AreaCurricularDTO getAreaCurricular();
    public AsignaturaDTO getAsignatura();
    
    interface AsignaturaDTO {
        public String getDescripcion();
    }
    
    interface AreaCurricularDTO {
        public String getDescripcion();
    }
}
