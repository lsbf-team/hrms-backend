package com.lsbf.hrms.controller;

import com.lsbf.hrms.config.JwtUtil;
import com.lsbf.hrms.model.AuthenticationRequest;
import com.lsbf.hrms.model.AuthenticationResponse;
import com.lsbf.hrms.model.User;
import com.lsbf.hrms.service.MyUserDetailsService;
import com.lsbf.hrms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        User user=userService.findByUsername(authenticationRequest.getUsername());

        return ResponseEntity.ok(new AuthenticationResponse(jwt,new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(), authenticationRequest.getEmail(),user.getRole())));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }
    @GetMapping("/fetch-users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PutMapping("update-user/{id}")
    public User updatePayslip(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userService.registerUser(user);
    }

    @DeleteMapping("delete-user/{id}")
    public void deletePayslip(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
}




