package com.gd.catalogapp.service;

import com.gd.catalogapp.entity.Product;

import java.util.List;

public interface CatalogService {

    Product getByUniqId(String uniqId);

    List<Product> getBySku(String sku);

}
