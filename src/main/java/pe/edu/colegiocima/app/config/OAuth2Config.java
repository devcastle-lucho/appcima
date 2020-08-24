package pe.edu.colegiocima.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import pe.edu.colegiocima.app.security.CustomSavedRequestAwareAuthenticationSuccessHandler;

//@Configuration
//@EnableOAuth2Client
public class OAuth2Config extends WebSecurityConfigurerAdapter {
   @Autowired
    private CustomSavedRequestAwareAuthenticationSuccessHandler successHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login().successHandler(successHandler);
        super.configure(http);
    }
}
