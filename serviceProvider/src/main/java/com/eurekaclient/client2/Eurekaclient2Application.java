package com.eurekaclient.client2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author TaoGeZou
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Eurekaclient2Application {

	public static void main(String[] args) {
		SpringApplication.run(Eurekaclient2Application.class, args);
	}

}
