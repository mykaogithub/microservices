# microservices
Repository for microservices demo projects
Feign
The Feign is a declarative web service (HTTP client) developed by Netflix. Its aim is to simplify the HTTP API clients. It is a Java to HTTP client binder. If you want to use Feign, create an interface, and annotate it. It provides pluggable annotation support, including Feign annotations and JAX-RS annotations.

It is a library for creating REST API clients. It makes web service clients easier. The developers can use declarative annotations to call the REST services instead of writing representative boilerplate code.

Spring Cloud OpenFeign
Spring Cloud OpenFeign provides OpenFeign integrations for Spring Boot apps through auto-configuration and binding to the Spring Environment. Without Feign, in Spring Boot application, we use RestTemplate to call the User service. To use the Feign, we need to add spring-cloud-starter-openfeign dependency in the pom.xml file.
