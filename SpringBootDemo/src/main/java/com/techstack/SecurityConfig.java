package com.techstack;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.techstack.entity.Reader;
import com.techstack.repository.ReaderRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ReaderRepository readerRepository;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
				//.antMatchers("/login").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers("/app/*").hasRole("USER")
				.anyRequest().authenticated()
				.and().csrf().disable()
				.formLogin()
					.loginPage("/login").permitAll();
					//.usernameParameter("username")
					//.passwordParameter("password")
					//.failureUrl("/login?error=true");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		/*auth
			.userDetailsService(new UserDetailsService(){

				@Override
				public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
					
					
					Optional<Reader> reader= readerRepository.findById(username);
					return reader.get();
				}
				
			});*/
		auth.inMemoryAuthentication()//.passwordEncoder(new BCryptPasswordEncoder())
        .withUser("test")
            .password("secret")
            .roles("USER");
	}
}
