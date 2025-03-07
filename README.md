# Microservices_25
Objective:

Getting practical skills in development of a microservices application using Spring Boot and Netflix OSS.

Prerequisites:
Spring Boot, Spring Cloud
Java
Netflix OSS (basic)

Scope of the project:
1 Download sample product data set https://www.kaggle.com/PromptCloudHQ/all-jc-penny-products   (opens in a new tab)
2 Create the following Spring Boot applications:

-Catalog application: holds online store product data in-memory from the product data set above.
The application exposes REST API for retrieving products by ‘uniq_id’ and list of products by ‘sku’.

-Inventory application: holds online store product availability data.
Generate random availability status for each product from the product data set above and keep it in an in-memory data structure.
The application exposes REST API for retrieving product availability by a list of ‘uniq_id’.

-Product application: returns product data to end-clients. The application exposes REST API
for retrieving available products data by ‘uniq_id’ and by ‘sku’ (multiple products are returned).
The REST service makes REST call to catalog application to get product data by ‘uniq_id’ or by ‘sku’,
and make a call to the inventory application to get product availability and filter out only available product before returning.

-Configuration server: contains all services configurations

-Gateway service: all call to service from user pass through it (calls between services don’t use gateway)

-Registry service: reg istering services.

3 Use Openfeign for calls between services.
4 Use resilience4j for protecting inter-component REST calls from the product application.
The fallback behavior is supposed to result in ‘503 service unavailable’ in case of unavailability of any dependant services.
Use synthetic delays (sleep time) in the inventory and catalog applications to increase response latency.
Play with ‘failureRateThreshold’, ‘recordExceptions’, ‘minimumNumberOfCalls’ and other configurations to simulate circuit breaker behavior.

Project assessment
Walk through application testing scenario and make sure they pass correctly (items #3-5).
Make code review to ensure implementation quality within the scope of the project.
Questions on implementation to make sure that trainee understands how Gateway,
Configuration server and registration service work in the capstone application.


- add OPENFEIN куди додати ?
- add interface
- @FeignClient(value = "product-service", url = "http://localhost:8080/")
  public interface ProductServiceClient {

  @GetMapping("/products")
  List<Products> getProducts();
  }

