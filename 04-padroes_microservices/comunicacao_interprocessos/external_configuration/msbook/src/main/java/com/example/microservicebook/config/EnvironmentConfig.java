package com.example.microservicebook.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class EnvironmentConfig {

    private String url;
    private Long porta;
    private String nomeApp;

    public String getUrl() {
        return url + ":" + porta + "/" + nomeApp;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getPorta() {
        return porta;
    }

    public void setPorta(Long porta) {
        this.porta = porta;
    }

    public String getNomeApp() {
        return nomeApp;
    }

    public void setNomeApp(String nomeApp) {
        this.nomeApp = nomeApp;
    }
}