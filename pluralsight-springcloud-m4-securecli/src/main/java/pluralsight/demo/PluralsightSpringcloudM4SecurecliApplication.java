package pluralsight.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import static org.springframework.security.oauth2.common.AuthenticationScheme.header;

import java.util.Arrays;

@SpringBootApplication
public class PluralsightSpringcloudM4SecurecliApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PluralsightSpringcloudM4SecurecliApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting con jorb");
		String urlOauthToken = "http://localhost:9000/services/oauth/token";
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setClientAuthenticationScheme(header);
		resourceDetails.setAccessTokenUri(urlOauthToken);
		
		resourceDetails.setScope(Arrays.asList("toll_read"));
		resourceDetails.setClientId("pluralsight");
		resourceDetails.setClientSecret("pluralsight");
		resourceDetails.setUsername("agoldberg");
		resourceDetails.setPassword("pass1");
		
		OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails);
		
		String token = template.getAccessToken().toString();
		String urlTollData = "http://localhost:9001/services/tolldata";
		System.out.println("Token: " + token);
		String s = template.getForObject(urlTollData, String.class);
		
		System.out.print("Result: " + s);
	}
}
