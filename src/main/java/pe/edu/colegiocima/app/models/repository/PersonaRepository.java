package pe.edu.colegiocima.app.models.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.colegiocima.app.models.entity.Persona;

public interface PersonaRepository extends CrudRepository<Persona,Long> {
    public Persona findByLogin(String login);
}
