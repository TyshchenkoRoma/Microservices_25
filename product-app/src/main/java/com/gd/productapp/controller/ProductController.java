package com.gd.productapp.controller;

import com.gd.productapp.client.CatalogClient;
import com.gd.productapp.client.InventoryClient;
import com.gd.productapp.dto.Inventory;
import com.gd.productapp.dto.Product;
import com.gd.productapp.service.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("product")

public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CatalogClient catalogClient;

    @Autowired
    InventoryClient inventoryClient;

    @GetMapping("/cat")
    public Product getById(@RequestParam("uniqId") String uniqId) {
        return catalogClient.getByUniqId(uniqId);
    }

    @GetMapping("/catbysku")
    public List<Product> getBySku(@RequestParam("sku") String sku) {
        return catalogClient.getBySku(sku);
    }

    @GetMapping("/inv")
    public List<Inventory> getInventoryById() {
        return inventoryClient.getAvailability();
    }

    @GetMapping("/listinv")
    public List<Inventory> getInventoryById(@RequestParam("uniqIdList") List<String> uniqIdList) {
        return inventoryClient.getListAvailability(uniqIdList);
    }

    @GetMapping("/avprodbyid")
    public List<Product> getAvByListId(@RequestParam("idList") List<String> idList) {
        List<Product> products = new ArrayList<>();
        List<String> avList = productService.getAvailId(idList);
        for (String id : avList) {
            products.add(catalogClient.getByUniqId(id));
        }
        return products;
    }

    @GetMapping("/avprodbysku")
    @CircuitBreaker(name = "circuitBreakerGetAvBySku", fallbackMethod = "fallback")
    public List<Product> getAvBySku(@RequestParam("sku") String sku) {
        List<Product> products = new ArrayList<>();
        List<String> avList = productService.getAvailId(productService.getAvailId(sku));
        for (String id : avList) {
            products.add(catalogClient.getByUniqId(id));
        }
        return products;
    }

    public List<Product> fallback(String sku, Throwable t) {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,
                "503 : Service is temporarily unavailable. Please try again later.");
    }

}

