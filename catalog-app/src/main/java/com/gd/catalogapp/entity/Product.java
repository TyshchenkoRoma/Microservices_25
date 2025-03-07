package com.gd.catalogapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@Entity
public class Product {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
//   // @GenericGenerator(name = "native", strategy = "native")
//    private Long id;
    @Id
    @Column
    private String uniq_id;
    @Column
    private String sku;
    @Column
    private String name_title;
    @Column
    private String description;
    @Column
    private Double list_price;
    @Column
    private Double sale_price;
    @Column
    private String category;
    @Column
    private String category_tree;
    @Column
    private String average_product_rating;
    @Column
    private String product_url;
    @Column
    private String product_image_urls;
    @Column
    private String brand;
    @Column
    private Integer total_number_reviews;
    @Column
    private String reviews;
//    @Column
//    private Boolean available;
}

