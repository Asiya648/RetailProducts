# JohnLewisProducts


Create a Restful webservice to request products in category 600001506 that have a price reduction.
Use this API to obtain a list of products: https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma

configuration -> configurations

controller -> api process for client

converter -> converter models to entities or entities to models

domain -> entities for category api

model -> entities for api

repository -> category api process

service -> repository process for controller

JohnlewisApplication.java -> You can start project with this class.

resources 
application.yaml -> project configuration


Running the application locally:
One way is to execute the main method in the com.johnlewis.JohnlewisApplication class from your IDE.
You should install to Lombokinto ide.
Alternatively you can use the Spring Boot Maven plugin as below:
mvn spring-boot:run

Requirements
For building and running the application you need:
JDK 1.8
Maven 3
Spring Boot
