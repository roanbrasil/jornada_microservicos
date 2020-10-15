package com.example.msbookserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * https://emmanuelneri.com.br/2018/07/09/configuracoes-distribuidas-com-spring-cloud-config/
 * 
 * @author cpereira7
 *
 */

@EnableConfigServer
@SpringBootApplication
public class MsBookServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBookServerApplication.class, args);
	}
}
