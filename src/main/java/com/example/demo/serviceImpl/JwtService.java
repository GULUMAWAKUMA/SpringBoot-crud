package com.example.demo.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.model;
import com.example.demo.repository.Repository;
import com.example.demo.util.JwtUtil;

@Service
public class JwtService implements UserDetailsService {
	
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private Repository repository;
	
//	@Autowired
	private AuthenticationManager authenticationManager;

	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
		
		  String userName = jwtRequest.getUserName();
	        String userPassword = jwtRequest.getUserPassword();
	        authenticate(userName, userPassword);

	        UserDetails userDetails = loadUserByUsername(userName);
	        String newGeneratedToken = jwtUtil.generateToken(userDetails);

	        model user = repository.findById(userName).get();
	        return new JwtResponse(user, newGeneratedToken);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		model user = repository.findById(username).get();

	        if (user != null) {
	            return new org.springframework.security.core.userdetails.User(
	                    user.getUsername(),
	                    user.getPassword(),
	                    getAuthority(user)
	            );
	        } else {
	            throw new UsernameNotFoundException("User not found with username: " + username);
	        }
	        
	}
	        private Set<SimpleGrantedAuthority> getAuthority(model user) {
	            Set<SimpleGrantedAuthority> authorities = new HashSet<>();
	            user.getRole().forEach(role -> {
	                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
	            });
	            return authorities;
	        }  
	        
	        
	        private void authenticate(String userName, String userPassword) throws Exception {
	            try {
	                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
	            } catch (DisabledException e) {
	                throw new Exception("USER_DISABLED", e);
	            } catch (BadCredentialsException e) {
	                throw new Exception("INVALID_CREDENTIALS", e);
	            }
	        }
	

}
