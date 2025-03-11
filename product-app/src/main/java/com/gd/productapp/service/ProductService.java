package com.gd.productapp.service;

import java.util.List;

public interface ProductService {

    List<String> getAvailId(List<String> id);

    List<String> getAvailId(String sku);
}
