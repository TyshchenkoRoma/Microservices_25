package com.gd.inventoryapp.service;

import com.gd.inventoryapp.entity.Inventory;

import java.util.List;

public interface InventoryService {

    List<Inventory> getByUniqId();

    void fillRandomAvailability();

    List<Inventory> getListInventory(List<String> idList);
}