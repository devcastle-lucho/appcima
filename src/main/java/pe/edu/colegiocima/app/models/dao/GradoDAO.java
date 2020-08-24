package pe.edu.colegiocima.app.models.dao;

import pe.edu.colegiocima.app.models.entity.Grado;

public interface GradoDAO {
    public Short insertar(Grado grado) throws Exception;
    public Boolean editar(Grado grado) throws Exception;
}
