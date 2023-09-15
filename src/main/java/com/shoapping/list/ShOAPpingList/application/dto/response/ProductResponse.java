package com.shoapping.list.ShOAPpingList.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private String note;
    private int price;
}
