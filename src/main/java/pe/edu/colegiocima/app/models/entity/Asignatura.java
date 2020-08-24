/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "asignatura")
@ApiModel(description = "Todos los detalles del Asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;    
    @Size(max = 80)
    @NotNull
    @NotEmpty
    private String descripcion;
    @Size(max = 15)
    private String abreviatura; 
    @Size(max = 15)
    private String horario; 
    
    @JsonIgnoreProperties(value = {"asignatura"} ,allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "asignatura",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AreaAsignatura> areasAsignatura;

    public Short getId() {
        return this.id;
    }

    public @Size(max = 80) @NotNull @NotEmpty String getDescripcion() {
        return this.descripcion;
    }

    public @Size(max = 15) String getAbreviatura() {
        return this.abreviatura;
    }

    public @Size(max = 15) String getHorario() {
        return this.horario;
    }

    public List<AreaAsignatura> getAreasAsignatura() {
        return this.areasAsignatura;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public void setDescripcion(@Size(max = 80) @NotNull @NotEmpty String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAbreviatura(@Size(max = 15) String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public void setHorario(@Size(max = 15) String horario) {
        this.horario = horario;
    }

    public void setAreasAsignatura(List<AreaAsignatura> areasAsignatura) {
        this.areasAsignatura = areasAsignatura;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Asignatura)) return false;
        final Asignatura other = (Asignatura) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$descripcion = this.getDescripcion();
        final Object other$descripcion = other.getDescripcion();
        if (this$descripcion == null ? other$descripcion != null : !this$descripcion.equals(other$descripcion))
            return false;
        final Object this$abreviatura = this.getAbreviatura();
        final Object other$abreviatura = other.getAbreviatura();
        if (this$abreviatura == null ? other$abreviatura != null : !this$abreviatura.equals(other$abreviatura))
            return false;
        final Object this$horario = this.getHorario();
        final Object other$horario = other.getHorario();
        if (this$horario == null ? other$horario != null : !this$horario.equals(other$horario)) return false;
        final Object this$areasAsignatura = this.getAreasAsignatura();
        final Object other$areasAsignatura = other.getAreasAsignatura();
        if (this$areasAsignatura == null ? other$areasAsignatura != null : !this$areasAsignatura.equals(other$areasAsignatura))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Asignatura;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $descripcion = this.getDescripcion();
        result = result * PRIME + ($descripcion == null ? 43 : $descripcion.hashCode());
        final Object $abreviatura = this.getAbreviatura();
        result = result * PRIME + ($abreviatura == null ? 43 : $abreviatura.hashCode());
        final Object $horario = this.getHorario();
        result = result * PRIME + ($horario == null ? 43 : $horario.hashCode());
        final Object $areasAsignatura = this.getAreasAsignatura();
        result = result * PRIME + ($areasAsignatura == null ? 43 : $areasAsignatura.hashCode());
        return result;
    }

    public String toString() {
        return "Asignatura(id=" + this.getId() + ", descripcion=" + this.getDescripcion() + ", abreviatura=" + this.getAbreviatura() + ", horario=" + this.getHorario() + ", areasAsignatura=" + this.getAreasAsignatura() + ")";
    }
}
