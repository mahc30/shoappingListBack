package com.shoapping.list.ShOAPpingList.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private Long id;
    private String name;
    private String note;
    private int price;

    @Override
    public String toString(){
        return String.format("%d %s %s %d", id, name, note, price);
    }
}
