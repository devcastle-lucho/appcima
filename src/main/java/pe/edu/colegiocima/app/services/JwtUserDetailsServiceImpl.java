package pe.edu.colegiocima.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pe.edu.colegiocima.app.models.entity.Persona;
import pe.edu.colegiocima.app.models.entity.Usuario;
import pe.edu.colegiocima.app.models.repository.PersonaRepository;
import pe.edu.colegiocima.app.models.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*---Primer CASO - Sin ROL
        Persona persona=personaRepository.findByLogin(username);
        if(Objects.isNull(persona))
            throw new UsernameNotFoundException("Usuario no se encuentra con el login :"+username);
        return new User(persona.getLogin(),new BCryptPasswordEncoder().encode(persona.getPass()),new ArrayList<>());
        */
        // 2° Caso - Con rol
        Usuario usuario= usuarioRepository.findByLogin(username).orElseThrow(()->new UsernameNotFoundException("Usuario no se encuentra con el login :"+username));

        List<String> roles =usuarioRepository.buscatRol(username);
        List<GrantedAuthority> autorizaciones = new ArrayList<>();
        for (var rol: roles)
            autorizaciones.add(new SimpleGrantedAuthority("ROLE_"+rol));
        return new User(usuario.getLogin(),new BCryptPasswordEncoder().encode(usuario.getPass()),autorizaciones);
    }
}
