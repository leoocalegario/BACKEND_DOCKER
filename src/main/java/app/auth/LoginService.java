//AuthenticationService.java
package app.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import app.config.JwtServiceGenerator;
import app.entity.Vendedores;
import app.repository.VendedoresRepository;

@Service
public class LoginService {
	
	@Autowired
	private VendedoresRepository repository;
	@Autowired
	private JwtServiceGenerator jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;


	public String logar(Login login) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						login.getUsername(),
						login.getPassword()
						)
				);
		Vendedores user = repository.findByEmail(login.getUsername()).get();
		String jwtToken = jwtService.generateToken(user);
		
		return jwtToken;
	}

}
