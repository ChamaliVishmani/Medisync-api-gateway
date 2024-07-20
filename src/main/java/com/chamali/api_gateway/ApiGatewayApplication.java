package com.chamali.api_gateway;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {
	private static final Logger logger = LoggerFactory.getLogger(ApiGatewayApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
		logger.info("API Gateway Application Started!!!");
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder){
		return builder.routes().route("servicea-route",r->{
			logger.info("Routing to servicea");
			return r.path("/servicea/**").filters(f -> f.stripPrefix(1)).uri("lb://servicea");
		}).route("serviceb-route",r->{
			logger.info("Routing to serviceb");
			return r.path("/serviceb/**").filters(f -> f.stripPrefix(1)).uri("lb://serviceb");
		}).route("drug-interaction-checker-route",r->{
			logger.info("Routing to drug-interaction-checker");
			return r.path("/drug-interaction-checker/**").filters(f -> f.stripPrefix(1)).uri("lb://drug-interaction-checker");
		}).route("disease-prediction-service-route",r->{
			logger.info("Routing to disease-prediction-service");
			return r.path("/disease-prediction-service/**").filters(f -> f.stripPrefix(1)).uri("lb://disease-prediction-service");
		}).build();
	}

}
