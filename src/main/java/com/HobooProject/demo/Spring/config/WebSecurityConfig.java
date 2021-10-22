//package com.HobooProject.demo.Spring.config;//package com.HobooProject.demo.Spring.config;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.beans.factory.annotation.Qualifier;
////import org.springframework.context.annotation.Bean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//  //  public DataSource dataSource;
//
////    @Bean
////    PasswordEncoder passwordEncoder(){
////        return new BCryptPasswordEncoder();
////    }
////
////    @Bean
////    public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception{
////        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
////        jdbcUserDetailsManager.setDataSource(dataSource);
////        return jdbcUserDetailsManager;
////    }
//
////    @Autowired
////    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
////        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
////    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests()
////                .antMatchers("/", "/index").permitAll()
////                .antMatchers("/registration").permitAll()
////                .antMatchers("/login").permitAll()
////                .antMatchers("/addOwnObject").permitAll()
////                .antMatchers("/hotel").permitAll()
////                .antMatchers("/hotelsList").permitAll()
////                .antMatchers("/booking").hasRole("USER")
////                .antMatchers("/favorite").hasRole("USER")
////                .antMatchers("/logout").hasRole("USER")
////                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                .defaultSuccessUrl("/")
////                .permitAll()
////                .and()
////                .logout()
////                .logoutSuccessUrl("/").permitAll();
////        http.csrf().disable();
////    }
//}
