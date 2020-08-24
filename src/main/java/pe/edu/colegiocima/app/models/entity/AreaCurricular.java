/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.models.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "areacurricular")
@ApiModel(description = "Todos los detalles del Area currilar")
public class AreaCurricular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;    
    private String descripcion;
    private Short orden;

    public Short getId() {
        return this.id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Short getOrden() {
        return this.orden;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setOrden(Short orden) {
        this.orden = orden;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AreaCurricular)) return false;
        final AreaCurricular other = (AreaCurricular) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$descripcion = this.getDescripcion();
        final Object other$descripcion = other.getDescripcion();
        if (this$descripcion == null ? other$descripcion != null : !this$descripcion.equals(other$descripcion))
            return false;
        final Object this$orden = this.getOrden();
        final Object other$orden = other.getOrden();
        if (this$orden == null ? other$orden != null : !this$orden.equals(other$orden)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AreaCurricular;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $descripcion = this.getDescripcion();
        result = result * PRIME + ($descripcion == null ? 43 : $descripcion.hashCode());
        final Object $orden = this.getOrden();
        result = result * PRIME + ($orden == null ? 43 : $orden.hashCode());
        return result;
    }

    public String toString() {
        return "AreaCurricular(id=" + this.getId() + ", descripcion=" + this.getDescripcion() + ", orden=" + this.getOrden() + ")";
    }
}
