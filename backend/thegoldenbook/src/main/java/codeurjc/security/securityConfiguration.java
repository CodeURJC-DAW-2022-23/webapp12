package codeurjc.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class securityConfiguration extends WebSecurityConfigurerAdapter {
    

    
    @Value("${security.user}")
    private String user;
    @Value("${security.encodedPassword}")
    private String encodedPassword;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication().withUser(user).password("{bcrypt}"+encodedPassword).roles("ADMIN");
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
        http.authorizeRequests().antMatchers("/cart").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/profile").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/profileModification").hasAnyRole("ADMIN");


        //Admin pages
        http.authorizeRequests().antMatchers("/authorModification").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/newBook").hasAnyRole("ADMIN");

        //Disable CSRF 
        http.csrf().disable();
    }
}

