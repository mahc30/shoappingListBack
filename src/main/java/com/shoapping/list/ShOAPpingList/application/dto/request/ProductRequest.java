package com.shoapping.list.ShOAPpingList.application.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private Long id;
    private String name;
    private String note;
    private int price;
}
