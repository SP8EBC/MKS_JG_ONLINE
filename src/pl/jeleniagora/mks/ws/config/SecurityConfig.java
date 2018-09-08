package pl.jeleniagora.mks.ws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()                 
            .withUser(Secret.user).password("{noop}" + Secret.password).roles("USER");       
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	   http
           .csrf()
               .disable()
           .authorizeRequests()
               .anyRequest().authenticated()
           .and()
           .httpBasic();
//               .realmName("test")
//               .authenticationEntryPoint(new CustomAuthenticationEntryPoint());
//    	http.authorizeRequests().anyRequest().denyAll();
    }
}
