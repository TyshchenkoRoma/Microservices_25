package com.gd.inventoryapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory")
@Entity
public class Inventory {

    @Id
    @Column(name = "uniq_id")
    private String uniqId;

    @Column
    private Boolean available;
}

