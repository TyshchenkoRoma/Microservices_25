package com.gd.productapp.client;

import com.gd.productapp.dto.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "http://localhost:8084", name = "inventory")
public interface InventoryClient {

    @GetMapping("/inventory/getinv")
    List<Inventory> getAvailability();

    @GetMapping("/inventory/getinvbyid")
    List<Inventory> getListAvailability(@RequestParam("uniqIdList") List <String> uniqIdList);
}