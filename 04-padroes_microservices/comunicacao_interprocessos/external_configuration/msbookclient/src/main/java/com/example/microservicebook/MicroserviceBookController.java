package com.example.microservicebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicebook.config.EnvironmentConfig;

@RestController
public class MicroserviceBookController {

	@Autowired
	private EnvironmentConfig configuration;
	
    @Value("${appName}")
    private String appName;

	@GetMapping("/url")
	public String getConfiguracion()
	{
		return "URL: http://" + configuration.getHost() + ":" + appName + "/" + configuration.getPort();
	}
}
