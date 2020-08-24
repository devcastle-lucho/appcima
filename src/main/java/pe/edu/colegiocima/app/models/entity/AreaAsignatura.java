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

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "areaasignatura")
@ApiModel(description = "Todos los detalles de Asignatura del Area")
public class AreaAsignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;  
    @JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idareacurricular")
    private AreaCurricular areaCurricular;
    @JsonIgnoreProperties(value = {"areasAsignatura","handler","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idasignatura")
    private Asignatura asignatura;

    public Short getId() {
        return this.id;
    }

    public AreaCurricular getAreaCurricular() {
        return this.areaCurricular;
    }

    public Asignatura getAsignatura() {
        return this.asignatura;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public void setAreaCurricular(AreaCurricular areaCurricular) {
        this.areaCurricular = areaCurricular;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AreaAsignatura)) return false;
        final AreaAsignatura other = (AreaAsignatura) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$areaCurricular = this.getAreaCurricular();
        final Object other$areaCurricular = other.getAreaCurricular();
        if (this$areaCurricular == null ? other$areaCurricular != null : !this$areaCurricular.equals(other$areaCurricular))
            return false;
        final Object this$asignatura = this.getAsignatura();
        final Object other$asignatura = other.getAsignatura();
        if (this$asignatura == null ? other$asignatura != null : !this$asignatura.equals(other$asignatura))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AreaAsignatura;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $areaCurricular = this.getAreaCurricular();
        result = result * PRIME + ($areaCurricular == null ? 43 : $areaCurricular.hashCode());
        final Object $asignatura = this.getAsignatura();
        result = result * PRIME + ($asignatura == null ? 43 : $asignatura.hashCode());
        return result;
    }

    public String toString() {
        return "AreaAsignatura(id=" + this.getId() + ", areaCurricular=" + this.getAreaCurricular() + ", asignatura=" + this.getAsignatura() + ")";
    }
}
