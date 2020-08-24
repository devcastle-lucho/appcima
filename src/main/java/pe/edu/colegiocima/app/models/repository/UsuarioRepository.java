package pe.edu.colegiocima.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.colegiocima.app.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository
    extends JpaRepository<Usuario,Long> {

    public Optional<Usuario> findByLogin(String login);

    @Query(value="select r.descripcion as rol from rol r " +
            "inner join perfil p on r.id = p.idrol " +
            "inner join usuario u on p.idusuario = u.id " +
            "where u.login=?",nativeQuery = true)
    public List<String> buscatRol(String login);
}
