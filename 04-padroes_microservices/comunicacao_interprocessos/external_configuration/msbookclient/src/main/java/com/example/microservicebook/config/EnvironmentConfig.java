package com.example.microservicebook.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class EnvironmentConfig {

    private Long port;
    private String host;
	
    public Long getPort() {
        return port;
    }

    public void setPort(Long port) {
        this.port = port;
    }

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
}