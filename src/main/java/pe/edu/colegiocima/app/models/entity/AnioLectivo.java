package pe.edu.colegiocima.app.models.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "annolectivo")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Todos los detalles del Año Lectivo")
public class AnioLectivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    @ApiModelProperty(notes = "Breve descripcion en texto ilimitado")
    private String descripcion;
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    private Boolean activo;
    private String periodo;
    @Size(max = 2)
    @Column(name = "periodoActual")
    private String periodoActual;
    @Column(name = "idnivelcolegio")
    private Short idNivelColegio;
    private String tardanza;
    private Boolean admision;
    @Column(name = "periodoboleta")
    // private Integer periodoBoleta;
    private int periodoBoleta;
    @Column(name = "horalllamada")
    private String horalLlamada;

    public Short getId() {
        return this.id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }

    public Boolean getActivo() {
        return this.activo;
    }

    public String getPeriodo() {
        return this.periodo;
    }

    public @Size(max = 2) String getPeriodoActual() {
        return this.periodoActual;
    }

    public Short getIdNivelColegio() {
        return this.idNivelColegio;
    }

    public String getTardanza() {
        return this.tardanza;
    }

    public Boolean getAdmision() {
        return this.admision;
    }

    public int getPeriodoBoleta() {
        return this.periodoBoleta;
    }

    public String getHoralLlamada() {
        return this.horalLlamada;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setPeriodoActual(@Size(max = 2) String periodoActual) {
        this.periodoActual = periodoActual;
    }

    public void setIdNivelColegio(Short idNivelColegio) {
        this.idNivelColegio = idNivelColegio;
    }

    public void setTardanza(String tardanza) {
        this.tardanza = tardanza;
    }

    public void setAdmision(Boolean admision) {
        this.admision = admision;
    }

    public void setPeriodoBoleta(int periodoBoleta) {
        this.periodoBoleta = periodoBoleta;
    }

    public void setHoralLlamada(String horalLlamada) {
        this.horalLlamada = horalLlamada;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AnioLectivo)) return false;
        final AnioLectivo other = (AnioLectivo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$descripcion = this.getDescripcion();
        final Object other$descripcion = other.getDescripcion();
        if (this$descripcion == null ? other$descripcion != null : !this$descripcion.equals(other$descripcion))
            return false;
        final Object this$fechaInicio = this.getFechaInicio();
        final Object other$fechaInicio = other.getFechaInicio();
        if (this$fechaInicio == null ? other$fechaInicio != null : !this$fechaInicio.equals(other$fechaInicio))
            return false;
        final Object this$fechaFin = this.getFechaFin();
        final Object other$fechaFin = other.getFechaFin();
        if (this$fechaFin == null ? other$fechaFin != null : !this$fechaFin.equals(other$fechaFin)) return false;
        final Object this$activo = this.getActivo();
        final Object other$activo = other.getActivo();
        if (this$activo == null ? other$activo != null : !this$activo.equals(other$activo)) return false;
        final Object this$periodo = this.getPeriodo();
        final Object other$periodo = other.getPeriodo();
        if (this$periodo == null ? other$periodo != null : !this$periodo.equals(other$periodo)) return false;
        final Object this$periodoActual = this.getPeriodoActual();
        final Object other$periodoActual = other.getPeriodoActual();
        if (this$periodoActual == null ? other$periodoActual != null : !this$periodoActual.equals(other$periodoActual))
            return false;
        final Object this$idNivelColegio = this.getIdNivelColegio();
        final Object other$idNivelColegio = other.getIdNivelColegio();
        if (this$idNivelColegio == null ? other$idNivelColegio != null : !this$idNivelColegio.equals(other$idNivelColegio))
            return false;
        final Object this$tardanza = this.getTardanza();
        final Object other$tardanza = other.getTardanza();
        if (this$tardanza == null ? other$tardanza != null : !this$tardanza.equals(other$tardanza)) return false;
        final Object this$admision = this.getAdmision();
        final Object other$admision = other.getAdmision();
        if (this$admision == null ? other$admision != null : !this$admision.equals(other$admision)) return false;
        if (this.getPeriodoBoleta() != other.getPeriodoBoleta()) return false;
        final Object this$horalLlamada = this.getHoralLlamada();
        final Object other$horalLlamada = other.getHoralLlamada();
        if (this$horalLlamada == null ? other$horalLlamada != null : !this$horalLlamada.equals(other$horalLlamada))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AnioLectivo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $descripcion = this.getDescripcion();
        result = result * PRIME + ($descripcion == null ? 43 : $descripcion.hashCode());
        final Object $fechaInicio = this.getFechaInicio();
        result = result * PRIME + ($fechaInicio == null ? 43 : $fechaInicio.hashCode());
        final Object $fechaFin = this.getFechaFin();
        result = result * PRIME + ($fechaFin == null ? 43 : $fechaFin.hashCode());
        final Object $activo = this.getActivo();
        result = result * PRIME + ($activo == null ? 43 : $activo.hashCode());
        final Object $periodo = this.getPeriodo();
        result = result * PRIME + ($periodo == null ? 43 : $periodo.hashCode());
        final Object $periodoActual = this.getPeriodoActual();
        result = result * PRIME + ($periodoActual == null ? 43 : $periodoActual.hashCode());
        final Object $idNivelColegio = this.getIdNivelColegio();
        result = result * PRIME + ($idNivelColegio == null ? 43 : $idNivelColegio.hashCode());
        final Object $tardanza = this.getTardanza();
        result = result * PRIME + ($tardanza == null ? 43 : $tardanza.hashCode());
        final Object $admision = this.getAdmision();
        result = result * PRIME + ($admision == null ? 43 : $admision.hashCode());
        result = result * PRIME + this.getPeriodoBoleta();
        final Object $horalLlamada = this.getHoralLlamada();
        result = result * PRIME + ($horalLlamada == null ? 43 : $horalLlamada.hashCode());
        return result;
    }

    public String toString() {
        return "AnioLectivo(id=" + this.getId() + ", descripcion=" + this.getDescripcion() + ", fechaInicio=" + this.getFechaInicio() + ", fechaFin=" + this.getFechaFin() + ", activo=" + this.getActivo() + ", periodo=" + this.getPeriodo() + ", periodoActual=" + this.getPeriodoActual() + ", idNivelColegio=" + this.getIdNivelColegio() + ", tardanza=" + this.getTardanza() + ", admision=" + this.getAdmision() + ", periodoBoleta=" + this.getPeriodoBoleta() + ", horalLlamada=" + this.getHoralLlamada() + ")";
    }
    /*@PrePersist
    public void prePersistencia() {
        this.periodoBoleta =0;
    }*/
}
