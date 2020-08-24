/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="planestudio")
@NoArgsConstructor
//@Builder
@AllArgsConstructor
@ApiModel(description = "Todos los detalles del plan estudio")
public class PlanEstudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    private Short horas;
    @JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idannolectivo")
    private AnioLectivo anioLectivo;
    @JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idgrado")
    private Grado grado;
    @JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idareaasignatura")
    private AreaAsignatura areaAsignatura;
    
    @PrePersist
    public void prePersist(){
        this.fechaCreacion = new Date();
    }

    public Short getId() {
        return this.id;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public Short getHoras() {
        return this.horas;
    }

    public AnioLectivo getAnioLectivo() {
        return this.anioLectivo;
    }

    public Grado getGrado() {
        return this.grado;
    }

    public AreaAsignatura getAreaAsignatura() {
        return this.areaAsignatura;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setHoras(Short horas) {
        this.horas = horas;
    }

    public void setAnioLectivo(AnioLectivo anioLectivo) {
        this.anioLectivo = anioLectivo;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public void setAreaAsignatura(AreaAsignatura areaAsignatura) {
        this.areaAsignatura = areaAsignatura;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PlanEstudio)) return false;
        final PlanEstudio other = (PlanEstudio) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$fechaCreacion = this.getFechaCreacion();
        final Object other$fechaCreacion = other.getFechaCreacion();
        if (this$fechaCreacion == null ? other$fechaCreacion != null : !this$fechaCreacion.equals(other$fechaCreacion))
            return false;
        final Object this$horas = this.getHoras();
        final Object other$horas = other.getHoras();
        if (this$horas == null ? other$horas != null : !this$horas.equals(other$horas)) return false;
        final Object this$anioLectivo = this.getAnioLectivo();
        final Object other$anioLectivo = other.getAnioLectivo();
        if (this$anioLectivo == null ? other$anioLectivo != null : !this$anioLectivo.equals(other$anioLectivo))
            return false;
        final Object this$grado = this.getGrado();
        final Object other$grado = other.getGrado();
        if (this$grado == null ? other$grado != null : !this$grado.equals(other$grado)) return false;
        final Object this$areaAsignatura = this.getAreaAsignatura();
        final Object other$areaAsignatura = other.getAreaAsignatura();
        if (this$areaAsignatura == null ? other$areaAsignatura != null : !this$areaAsignatura.equals(other$areaAsignatura))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PlanEstudio;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $fechaCreacion = this.getFechaCreacion();
        result = result * PRIME + ($fechaCreacion == null ? 43 : $fechaCreacion.hashCode());
        final Object $horas = this.getHoras();
        result = result * PRIME + ($horas == null ? 43 : $horas.hashCode());
        final Object $anioLectivo = this.getAnioLectivo();
        result = result * PRIME + ($anioLectivo == null ? 43 : $anioLectivo.hashCode());
        final Object $grado = this.getGrado();
        result = result * PRIME + ($grado == null ? 43 : $grado.hashCode());
        final Object $areaAsignatura = this.getAreaAsignatura();
        result = result * PRIME + ($areaAsignatura == null ? 43 : $areaAsignatura.hashCode());
        return result;
    }

    public String toString() {
        return "PlanEstudio(id=" + this.getId() + ", fechaCreacion=" + this.getFechaCreacion() + ", horas=" + this.getHoras() + ", anioLectivo=" + this.getAnioLectivo() + ", grado=" + this.getGrado() + ", areaAsignatura=" + this.getAreaAsignatura() + ")";
    }
}
