//package tacos;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.StandardPasswordEncoder;
//import tacos.data.dataApi.serviceApi.UserDetailsService;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    public PasswordEncoder encoder() {
//        return new StandardPasswordEncoder("53cr3t");
//    }
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService((org.springframework.security.core.userdetails.UserDetailsService) userDetailsService).passwordEncoder(encoder());
//    }
//}
