package com.lpu.bank_profileDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("dev")
@RestController
public class DevController {

	@Value("${server.port}")
	private String port;
	
	@Value("${user.name2}")
	private String name;
	
	@GetMapping("/hi")
	public String sayHii() {
		System.out.println(name);
		return name + "   " + port;
	}
}
