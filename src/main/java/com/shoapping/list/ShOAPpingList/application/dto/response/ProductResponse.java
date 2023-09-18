package com.shoapping.list.ShOAPpingList.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement(name = "ProductResponse")
public class ProductResponse {
    private Long id;
    private String name;
    private String note;
    private int price;
}
