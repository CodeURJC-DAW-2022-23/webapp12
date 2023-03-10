package codeurjc.security;

import codeurjc.service.RepositoryUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.security.SecureRandom;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class securityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
	RepositoryUserDetailsService userDetailsService;
        
    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10, new SecureRandom());
	}

    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        //Login
        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/home");
        http.formLogin().failureUrl("/loginError");

        //LogOut
        http.logout().logoutUrl("/profile");
        http.logout().logoutSuccessUrl("/home");

        //Public pages
        http.authorizeRequests().antMatchers("/home").permitAll();
        http.authorizeRequests().antMatchers("/author").permitAll();
        http.authorizeRequests().antMatchers("/authorList").permitAll();
        http.authorizeRequests().antMatchers("/book").permitAll();
        http.authorizeRequests().antMatchers("/bookInfo").permitAll();
        http.authorizeRequests().antMatchers("/Footer").permitAll();
        http.authorizeRequests().antMatchers("/Header").permitAll();
        http.authorizeRequests().antMatchers("/login2").permitAll();
        http.authorizeRequests().antMatchers("/loginError").permitAll();
        http.authorizeRequests().antMatchers("/register").permitAll();
        http.authorizeRequests().antMatchers("/review").permitAll();

        //User pages
        http.authorizeRequests().antMatchers("/cart").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/profile").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/profileModification").hasAnyRole("USER");


        //Admin pages
        http.authorizeRequests().antMatchers("/authorModification").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/newBook").hasAnyRole("ADMIN");

        //Disable CSRF 
        http.csrf().disable();
    }
}

