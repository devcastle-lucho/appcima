package pe.edu.colegiocima.app.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
//@ConfigurationProperties
public class SessionFactoryConfig {
    @Autowired
    DataSource dataSource;
    @Autowired
    JpaVendorAdapter jpaVendorAdapter;
    /*@PostConstruct
    public void loadData() {

    }*/
    @Bean
    @Primary
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan("pe.edu.colegiocima.app.models");
        emf.setPersistenceUnitName("default");
        emf.afterPropertiesSet();

        return emf.getObject();
    }
    @Bean
    public SessionFactory setSessionFactory(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }
}
