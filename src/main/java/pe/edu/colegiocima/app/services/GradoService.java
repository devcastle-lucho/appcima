package pe.edu.colegiocima.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.edu.colegiocima.app.models.entity.Grado;

public interface GradoService {
    public Iterable findAll();
    public Grado save(Grado entity);
    public void deleteById(Short id);
    public Grado findById(Short id);
    public Iterable<Grado> findByIdNivelColegioOrderByDescripcion(Integer id);
    public Page<Grado> findByIdNivelColegioOrderByDescripcionAsc(Integer id,Pageable pageable);
}
