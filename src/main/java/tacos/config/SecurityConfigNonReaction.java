//package tacos.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * 配置非反应式Web应用的安全性
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigNonReaction extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/design", "/orders").hasAnyAuthority("USER").antMatchers("/**").permitAll();
//    }
//}
