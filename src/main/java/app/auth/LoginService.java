//AuthenticationService.java
package app.auth;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {


	public String logar(User user) {

		HttpHeaders headers = new HttpHeaders();
		RestTemplate rt = new RestTemplate();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
		formData.add("client_id", user.clientId());
		formData.add("username", user.username());
		formData.add("password", user.password());
		formData.add("grant_type", user.grantType());

		String url = "http://192.168.56.104:8085/realms/wavemotors/protocol/openid-connect/token";

		HttpEntity<MultiValueMap<String, String>> entity
				= new HttpEntity<>(formData, headers);
		String result = rt.postForEntity(url, entity, String.class).getBody();

		System.out.println(result);
		return result;
	}

}