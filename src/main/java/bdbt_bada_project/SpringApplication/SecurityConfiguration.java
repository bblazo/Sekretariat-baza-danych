package bdbt_bada_project.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import
        org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN")
                .and()
                .withUser("staz")
                .password("staz")
                .roles("STAZ")
                .and()
                .withUser("pracownik")
                .password("pracownik")
                .roles("PRACOWNIK");
    }
    @Bean
    public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();
    }@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/main").authenticated()
                .antMatchers("/main_admin").access("hasRole('ADMIN')")
                .antMatchers("/main_user").access("hasRole('USER')")
                .antMatchers("/main_pracownik").access("hasRole('PRACOWNIK')")
                .antMatchers("/main_staz").access("hasRole('STAZ')")
                .antMatchers("/adresy").access("hasRole('ADMIN')")
                .antMatchers("/klienci").access("hasRole('ADMIN')")
                .antMatchers("/uslugi").access("hasRole('ADMIN')")
                .antMatchers("/wynagrodzenia").access("hasRole('ADMIN')")
                .antMatchers("/pracownicy").access("hasRole('ADMIN')")
                .antMatchers("/new_form_pracownik").access("hasRole('ADMIN')")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/index")
                .logoutSuccessUrl("/index")
                .permitAll();

    }
}