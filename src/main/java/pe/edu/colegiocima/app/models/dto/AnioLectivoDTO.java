/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.models.dto;

import io.swagger.annotations.ApiModel;
import lombok.Value;

@Value
@ApiModel(value = "AnioLectivo")
public final class AnioLectivoDTO {
    private final Short id;
    private final String descripcion;
/* ---No es necesario con lombok--
    public AnioLectivoDTO(Short id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public AnioLectivoDTO() {
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    */   
}
