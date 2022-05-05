package com.vidiemme.employees_information.security;

import com.vidiemme.employees_information.security.filter.CustomAuthenticationFilter;
import com.vidiemme.employees_information.security.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final String API_EMPLOYEES = "/api/employees/**";
    private static final String MODIFY_ALL = "MODIFY_ALL";
    private static final String READ_ALL = "READ_ALL";

    @Autowired
    UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/login/**").permitAll()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST, API_EMPLOYEES).hasAuthority(MODIFY_ALL)
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET, API_EMPLOYEES).hasAuthority(READ_ALL)
                .and()
                .authorizeRequests().antMatchers(HttpMethod.PUT, API_EMPLOYEES).hasAuthority(MODIFY_ALL)
                .and()
                .authorizeRequests().antMatchers(HttpMethod.DELETE, API_EMPLOYEES).hasAuthority(MODIFY_ALL)
                .and()
                .authorizeRequests().anyRequest().permitAll()
                .and()
                .addFilter(new CustomAuthenticationFilter(super.authenticationManagerBean()))
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        httpSecurity.headers().cacheControl();
    }
}
