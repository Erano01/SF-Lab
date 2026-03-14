package me.erano.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        // NEVER USE IT IN PRODUCTION
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.authorizeHttpRequests(
                // all the requests require authentication
                auth -> auth.anyRequest().authenticated()
        );

        UserDetails userDetails = User.withUsername("john")
                .password("12345")
                .authorities("read")
                .build();

        UserDetailsService userDetailsService = new InMemoryUserDetailsManager(userDetails);
        httpSecurity.userDetailsService(userDetailsService);

        return httpSecurity.build();
    }

//    @Bean
//    UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.withUsername("john")
//                .password("12345")
//                .authorities("read")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }
//

//
//    @Bean
//    SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
//
//        // Syntax 1 - Spring Security in Practice book prefer this.
////        httpSecurity.httpBasic(Customizer.withDefaults());
////        httpSecurity.authorizeHttpRequests(
////                // all the requests require authentication
////                auth -> auth.anyRequest().authenticated()
////        );
////        return httpSecurity.build();
//
//        // Syntax 2
//        return httpSecurity
//                .httpBasic(Customizer.withDefaults())
////              .authorizeHttpRequests(
////                      // all the requests require authentication
////                      auth -> auth.anyRequest().authenticated()
////              )
//                .authorizeHttpRequests(
//                        // none of the requests need to be authenticated
//                        auth -> auth.anyRequest().permitAll()
//                )
//                .build();
//    }
}