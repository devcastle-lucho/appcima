package pe.edu.colegiocima.app.models.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "grado")
@ApiModel(description = "Todos los detalles de Grado Academico")
public class Grado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    @Size(max = 8)
    @ApiModelProperty(name = "Breve descripcion del grado con un maximo de 8 caracteres",notes = "Breve descripcion del grado con un maximo de 8 caracteres")
    private String descripcion;
    @Column(name = "idnivelcolegio", length = 8)
    @ApiModelProperty(name = "Referencia del Nivel colegio",notes = "Referencia del Nivel colegio")
    private Integer idNivelColegio;
    @Column(name = "idgrado_ant")
    @ApiModelProperty(name = "Referencia del grado anterior",notes = "Referencia del grado anterior")
    private Integer idGradoAnterior;
    @NotNull(message = "Debe existir la edad y mayor a cero")
    @ApiModelProperty(name = "Edad establecido obligatorio",required = true,notes = "Edad establecido obligatorio")
    private Integer edad;
    @Column(name = "circuloestudio")
    @ApiModelProperty(name = "Activado: cursos de un grupo de alumnos",required = true,notes =  "Activado: cursos de un grupo de alumnos")
    private Boolean circuloEstudio;

    public Grado() {
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

    public Integer getIdNivelColegio() {
        return idNivelColegio;
    }

    public void setIdNivelColegio(Integer idNivelColegio) {
        this.idNivelColegio = idNivelColegio;
    }

    public Integer getIdGradoAnterior() {
        return idGradoAnterior;
    }

    public void setIdGradoAnterior(Integer idGradoAnterior) {
        this.idGradoAnterior = idGradoAnterior;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean isCirculoEstudio() {
        return circuloEstudio;
    }

    public void setCirculoEstudio(Boolean circuloEstudio) {
        this.circuloEstudio = circuloEstudio;
    }
}






