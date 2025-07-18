package az.developia.compshopcavidhuseynzade.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.GET, "/create-account").permitAll().
                antMatchers(HttpMethod.POST, "/create-account-procces").permitAll().
                antMatchers(HttpMethod.GET, "/shopping").permitAll()
                .antMatchers(HttpMethod.GET, "/css/**").permitAll()
                .antMatchers(HttpMethod.GET, "/js/**").permitAll()
                .antMatchers(HttpMethod.GET, "/files/**").permitAll().
                antMatchers(HttpMethod.POST, "/rest/computers/search-find-partial").permitAll().
                antMatchers(HttpMethod.GET, "/rest/users/**").permitAll().
                            anyRequest().authenticated().and()
                .formLogin().loginPage("/show-login").loginProcessingUrl("/authenticate-user").permitAll().and()
                .logout().permitAll();
    }

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

}

