package io.security.basicsecurity

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun userDetailsService(): UserDetailsService {
        val user = User
            .withUsername("user")
            .password("{noop}1234")
            .roles("USER")
            .build()

        val sys = User
            .withUsername("sys")
            .password("{noop}1234")
            .roles("SYS")
            .build()

        val admin = User
            .withUsername("admin")
            .password("{noop}1234")
            .roles("ADMIN")
            .build()

        return InMemoryUserDetailsManager(user, sys, admin)
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .authorizeHttpRequests {
                it
                    .requestMatchers("/user").hasRole("USER")
                    .requestMatchers("/admin/sys").hasRole("SYS")
                    .requestMatchers("/admin/**").hasAnyRole("SYS", "ADMIN")
                    .anyRequest().authenticated()
            }
            .formLogin {
            }
            .sessionManagement {
                it.maximumSessions(1)
//                    .maxSessionsPreventsLogin(true)
                    .maxSessionsPreventsLogin(false)
            }
            .build()
    }
}

