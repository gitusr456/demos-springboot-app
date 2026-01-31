package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.stereotype.Service;

@SpringBootApplication
@RestController
public class SpringTestAppApplication {
	@GetMapping("/health")
	public String health() {
		System.out.println("Testing..." );
		displayHostInfo();
		return "OK + host details : " + displayHostInfo() ;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringTestAppApplication.class, args);
	}

	public String displayHostInfo() {
		String result = "" ;
		try {
			InetAddress ip = InetAddress.getLocalHost();
			String hostname = ip.getHostName();
			String hostAddress = ip.getHostAddress();

			result = hostname + " - IP :  " + hostAddress ;
			
			System.out.println("Current Hostname : " + hostname);
			System.out.println("Current IP address : " + hostAddress);

		} catch (UnknownHostException e) {
			System.err.println("Could not determine host information: " + e.getMessage());
		}
		
		return result ;
	}
}
