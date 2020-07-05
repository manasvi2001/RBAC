/* ROOT CONFIGURATION.java
 *   by Anonymous
 *
 * Created:
 *   7/5/2020, 2:22:29 PM
 * Last edited:
 *   7/5/2020, 2:22:29 PM
 * Auto updated?
 *   Yes
 *
 * Description:
 *   Apurba Mondal
**/

package assig.apurba.rar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import assig.apurba.rar.web.services.impl.InMemoryUserDetailsService;

@Configuration
@ComponentScan("assig.apurba.rar")
@PropertySource(value="classpath:application.properties")
@EnableWebMvc
@EnableWebSecurity
public class RootConfiguration  extends WebSecurityConfigurerAdapter {
	@Autowired
	HttpAuthenticationEntryPoint entryPoint;
	@Autowired
	InMemoryUserDetailsService usersSvc;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest()
				.authenticated()
					.and()
				.httpBasic()
			.authenticationEntryPoint(entryPoint);
		
		http.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usersSvc);
	}	
}
