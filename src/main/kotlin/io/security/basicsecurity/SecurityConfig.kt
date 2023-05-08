package io.security.basicsecurity

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val userDetailsService: UserDetailsService
) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .authorizeHttpRequests {
                it.anyRequest().authenticated()
            }
            .formLogin {
                it.defaultSuccessUrl("/")
                    .failureUrl("/login")
                    .usernameParameter("userId")
                    .passwordParameter("passwd")
                    .loginProcessingUrl("/login_proc")
                    .successHandler { request, response, authentication ->
                        println("authentication : ${authentication.name}")
                        response.sendRedirect("/")
                    }
                    .failureHandler { request, response, exception ->
                        println("exception: ${exception.message}")
                        response.sendRedirect("/login")
                    }
                    .permitAll()
            }
            .logout {
                it.logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    .deleteCookies("JSESSIONID", "remember-me")
                    .addLogoutHandler { request, response, authentication ->
                        val session = request.session
                        println("session: $session")
                        session.invalidate()
                    }.logoutSuccessHandler { request, response, authentication ->
                        response.sendRedirect("/login")
                    }
            }
            .rememberMe {
                it.rememberMeParameter("remember-me")
                    .tokenValiditySeconds(3600)
                    .userDetailsService(userDetailsService)
            }
            .sessionManagement {
                it.maximumSessions(1)
            }
            .build()
    }
}

