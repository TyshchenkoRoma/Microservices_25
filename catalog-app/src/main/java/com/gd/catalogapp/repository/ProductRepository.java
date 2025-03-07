package com.gd.catalogapp.repository;

import com.gd.catalogapp.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

     @Query(value = "select * from product where uniq_id = :uniqId", nativeQuery = true)
    Product findByUniq_id(@Param("uniqId") String uniqId);

    List<Product> findBySku(String sku);

}
