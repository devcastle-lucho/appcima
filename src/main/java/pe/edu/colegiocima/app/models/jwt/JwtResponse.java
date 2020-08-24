package pe.edu.colegiocima.app.models.jwt;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
public class JwtResponse {
    private final String jwttoken;

    public String getToken() {
        return this.jwttoken;
    }
}
