package com.samoy;
import org.springframework.boot.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication {
    public static void main(String[] args) {
       SpringBootApplication.run(ProviderApplication.class, args);
    }
}