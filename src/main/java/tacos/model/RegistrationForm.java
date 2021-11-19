//package tacos.model;
//
//import lombok.Data;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Data
//public class RegistrationForm {
//    private String userName;
//
//    private String passWord;
//
//    private String fullName;
//
//    private String street;
//
//    private String city;
//
//    private String state;
//
//    private String zip;
//
//    private String phone;
//
//    public User toUser(PasswordEncoder passwordEncoder) {
//        return new User(userName, passwordEncoder.encode(passWord), fullName, street, city, state, zip, phone);
//    }
//}
//
