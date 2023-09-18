package com.shoapping.list.ShOAPpingList.application.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
public class ProductRequest {
    @XmlElement(required = true)
    private Long id;
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String note;
    @XmlElement(required = true)
    private int price;
}
