package mx.bhit.omicron.app.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	//
	// public String getName() {
	//
	// Authentication auth =
	// SecurityContextHolder.getContext().getAuthentication();
	// if (auth != null && auth.isAuthenticated()) {
	// return auth.getName();
	// }
	// return "system";
	// }
	//
	// public List<String> getRoles() {
	// Authentication auth =
	// SecurityContextHolder.getContext().getAuthentication();
	// if (auth != null && auth.isAuthenticated()) {
	// List<String> roles = new ArrayList<String>();
	//
	// for (GrantedAuthority ga : auth.getAuthorities()) {
	// roles.add(ga.getAuthority());
	// }
	//
	// return roles;
	// }
	//
	// return Collections.emptyList();
	// }
	//
	// public boolean hasRole(String role) {
	// return false;
	// }
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication().withUser("journaldev").password("jd@123").authorities("ROLE_USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/homePage").access("hasRole('ROLE_USER')").and().formLogin()
				.loginPage("/loginPage").defaultSuccessUrl("/homePage").failureUrl("/loginPage?error")
				.usernameParameter("username").passwordParameter("password").and().logout()
				.logoutSuccessUrl("/loginPage?logout");

	}

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.authorizeRequests().antMatchers("/hello").access("hasRole('ROLE_ADMIN')").anyRequest().permitAll().and()
	// .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").and()
	// .logout().logoutSuccessUrl("/login?logout").and().exceptionHandling().accessDeniedPage("/403").and()
	// .csrf();
	// }
}