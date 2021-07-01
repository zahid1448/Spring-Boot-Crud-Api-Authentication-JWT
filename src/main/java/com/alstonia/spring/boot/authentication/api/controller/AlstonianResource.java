package com.alstonia.spring.boot.authentication.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alstonia.spring.boot.authentication.api.model.AuthenticationRequest;
import com.alstonia.spring.boot.authentication.api.model.AuthenticationResponse;
import com.alstonia.spring.boot.authentication.api.service.MyUserDetailsService;
import com.alstonia.spring.boot.authentication.api.util.JwtUtil;

@RestController
public class AlstonianResource {
	@Autowired
private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;
@RequestMapping(value="/authenticate", method=RequestMethod.POST)
public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
	try {
	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
	}
	catch(BadCredentialsException e) {
		throw new Exception("Incorrect username or password", e);
	}
	final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	final String jwt=jwtTokenUtil.generateToken(userDetails);
	return ResponseEntity.ok(new AuthenticationResponse(jwt));
}

}
