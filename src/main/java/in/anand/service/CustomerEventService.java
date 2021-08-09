package in.anand.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

@Service
public class CustomerEventService {
	String URL1="http://localhost:9090/event";
	String URL2="http://localhost:9090/events";
	
	
	public void invokeCustomerEvent()
	{
		Builder builder = WebClient.builder();
		WebClient build = builder.build();
		build.get()
			 .uri(URL1)
			 .header("Content-Type", "application/xml")
			 .retrieve()
			 .bodyToMono(String.class)
			 .block();
		
		
	}
	
	public void invokeCustomerEvents()
	{
		Builder builder = WebClient.builder();
		WebClient build = builder.build();
		build.get()
			 .uri(URL1)
			 .header("Content-Type", "application/xml")
			 .retrieve()
			 .bodyToFlux(String.class)
			 .subscribe(System.out::println);
	}

}
