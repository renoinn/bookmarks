package com.oomori.app.config

import com.oomori.app.domain.service.impl.UserDetailsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Override
    @Throws(Exception::class)
    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(
                "/images/**",
                "/css/**",
                "/javascript/**",
                "/webjars/**")
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/")
                //.failureHandler(SampleAuthenticationFailureHandler())
                .defaultSuccessUrl("/home")
        http.logout()
                .logoutRequestMatcher(AntPathRequestMatcher("/logout**"))
                .logoutSuccessUrl("/")
    }

    @Configuration
    class AuthenticationConfiguration : GlobalAuthenticationConfigurerAdapter() {
        @Autowired
        var userDetailsService: UserDetailsServiceImpl = UserDetailsServiceImpl()

        @Throws(Exception::class)
        override fun init(auth: AuthenticationManagerBuilder) {
            auth.userDetailsService<UserDetailsService>(userDetailsService)
                    .passwordEncoder(BCryptPasswordEncoder())

        }
    }
}