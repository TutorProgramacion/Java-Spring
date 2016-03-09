package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import javax.sql.DataSource;


/**
 * Created by Carmelo Marin Abrego on 08/03/2016.
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends GlobalMethodSecurityConfiguration {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/db-name");
        ds.setUsername("user");
        ds.setPassword("pass");
        return ds;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user1").password("123").roles("ADMIN").and()
//                .withUser("user2").password("456").roles("USER", "STANDAR");

        auth.jdbcAuthentication()
                .dataSource(dataSource())
                .rolePrefix("ROLE_")
                .usersByUsernameQuery("SELECT username, userpass, enabled FROM users WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?")
                .passwordEncoder(new Md5PasswordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
