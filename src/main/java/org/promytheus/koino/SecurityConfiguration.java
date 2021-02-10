package org.promytheus.koino;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        
        auth.inMemoryAuthentication()
            .withUser("gtyl")
                .password(encoder.encode("test"))
                .roles("USER")
            .and()
            .withUser("admin")
                .password(encoder.encode("d0dek@nISou"))
                .roles("USER", "ADMIN");
    }

    @Override
	protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .anyRequest().permitAll()
            .and()
                .httpBasic();
    }
    
    @Override
	public void configure(WebSecurity web) throws Exception {

		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/api/**");
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/**")
					.allowedOrigins("*");
			}
		};
	}
}
