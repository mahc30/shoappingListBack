package com.shoapping.list.ShOAPpingList.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Product {

    private Long id;
    private String name;
    private String note;
    private int price;

    @Override
    public String toString(){
        return String.format("Id:%d Nombre: %s Desc:%s Price:%d", id, name, note, price);
    }
}


