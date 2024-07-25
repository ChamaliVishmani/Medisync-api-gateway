# API Gateway Application

This API Gateway application acts as a central entry point for routing requests to various microservices in Medisync. Built using Spring Cloud Gateway, it integrates with Eureka Discovery Server for dynamic routing and load balancing.

## Features

- **Service Discovery:** Integrates with Eureka for dynamic service discovery.
- **Routing:** Routes requests to various microservices based on predefined paths.
- **Load Balancing:** Distributes requests across available instances of services.
- **Logging:** Logs routing information for monitoring and debugging purposes.

### Configuration

The routes are configured in the `ApiGatewayApplication` class. Here are the default routes:

- `/servicea/**` -> Routes to `servicea` (Test service)
- `/serviceb/**` -> Routes to `serviceb` (Test service)
- `/drug-interaction-checker/**` -> Routes to `drug-interaction-checker`
- `/disease-prediction-service/**` -> Routes to `disease-prediction-service`
- `/ml-backend/**` -> Routes to `ml-backend`
