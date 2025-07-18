package az.developia.taskmanagementaprel11.config;

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
public class SpringSecurityCustomConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
        http.csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
        .anyRequest().authenticated()
        .and().httpBasic();
    }
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	 auth.jdbcAuthentication().dataSource(dataSource);
    }
    
    
    
}