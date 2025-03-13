package com.gd.productapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Inventory {
    private String uniqId;
    private String sku;
    private Boolean available;
}
