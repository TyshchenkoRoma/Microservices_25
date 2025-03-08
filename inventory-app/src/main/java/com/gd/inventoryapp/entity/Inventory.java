package com.gd.inventoryapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory")
@Entity
public class Inventory {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
//   // @GenericGenerator(name = "native", strategy = "native")
//    private Long id;
    @Id
    @Column(name = "uniq_id")
    private String uniqId;
//    @Column
//    private String sku;
    @Column
    private Boolean available;
}

