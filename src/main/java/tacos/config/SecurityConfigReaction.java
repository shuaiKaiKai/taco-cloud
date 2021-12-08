//package tacos.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
///**
// * 配置反应式Spring WebFlux
// */
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfigReaction {
//
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        return http.authorizeExchange().pathMatchers("/design", "/orders").hasAnyAuthority("USER").anyExchange().permitAll().and().build();
//    }
//}
