//package tacos.service.serviceImpl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import tacos.data.dataApi.UserRepository;
//import tacos.data.dataApi.serviceApi.UserDetailsService;
//import tacos.model.User;
//
//@Service
//public class UserRepositoryUserDetailsService implements UserDetailsService {
//    private UserRepository userRepo;
//
//    @Autowired
//    public UserRepositoryUserDetailsService(UserRepository userRepo) {
//        this.userRepo = userRepo;
//    }
//
//    @Override
//    public UserDetails loadUserByUserName(String userName) throws UsernameNotFoundException {
//        User user = userRepo.findByUserName(userName);
//        if (user != null) {
//            return user;
//        }
//
//        throw new UsernameNotFoundException("User" + userName + " not found");
//    }
//}
