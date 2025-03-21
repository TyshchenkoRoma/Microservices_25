package com.gd.productapp.client;

import com.gd.productapp.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "http://localhost:8082", name = "catalog") // service name
public interface CatalogClient {

    @GetMapping("/catalog")
    Product getByUniqId(@RequestParam("uniqId") String uniqId);

    @GetMapping("/catalog/getbysku")
    List<Product> getBySku(@RequestParam("sku") String sku);
}
