package pe.edu.colegiocima.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.colegiocima.app.models.entity.Grado;
import pe.edu.colegiocima.app.models.repository.GradoRepository;

@Service
public class GradoServiceImpl implements GradoService{
    @Autowired
    protected GradoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Grado> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Grado save(Grado entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Short id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Grado findById(Short id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Grado> findByIdNivelColegioOrderByDescripcion(Integer id) {
        // return repository.findByIdNivelColegioOrderByDescripcionAsc(id);
        return repository.findCustom1(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Grado> findByIdNivelColegioOrderByDescripcionAsc(Integer id, Pageable pageable) {
        return repository.findByIdNivelColegioOrderByDescripcionAsc(id, pageable);
    }
}
