package com.rps.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
	UserDetailsService uds;
	
	@Bean
	public AuthenticationProvider authSetUp()
	{
		DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
		dap.setUserDetailsService(uds);
		dap.setPasswordEncoder(new BCryptPasswordEncoder());
		//dap.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return dap;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	//	web.ignoring().antMatchers("/**");
		web.ignoring().antMatchers("/app/signup/**","/app/webjars/**","/webjars/**");
		web.ignoring().antMatchers("/mbar/**");
		//web.ignoring().antMatchers("/js/**");
		//web.ignoring().antMatchers("/css/**");
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests().antMatchers("/user").hasAnyRole("CUSTOMER","ADMIN").antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and()
        .formLogin()
        .loginPage("/app/login")
        .defaultSuccessUrl("/app/welcome", true)
        .permitAll();
	}
	
	
	 

}
