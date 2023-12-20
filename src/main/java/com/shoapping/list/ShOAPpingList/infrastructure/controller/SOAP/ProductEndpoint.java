package com.shoapping.list.ShOAPpingList.infrastructure.controller.SOAP;

import com.shoapping.list.ShOAPpingList.application.dto.response.ProductResponse;
import localhost._8080.soap.product.GetProductRequest;
import localhost._8080.soap.product.SaveProductRequest;
import localhost._8080.soap.product.SoapProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.shoapping.list.ShOAPpingList.application.handler.IProductHandler;

@Endpoint
public class ProductEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8080/soap/product";

    private final IProductHandler productHandler;

    @Autowired
    public ProductEndpoint(IProductHandler productHandler) {
        this.productHandler = productHandler;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SaveProductRequest")
    @ResponsePayload
    public SoapProduct saveProduct(@RequestPayload SaveProductRequest request) {
        productHandler.saveProduct(request);
        SoapProduct response = new SoapProduct();
        response.setId(request.getId());
        response.setName(request.getName());
        response.setNote(request.getNote());
        response.setPrice(request.getPrice());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetProductRequest")
    @ResponsePayload
    public ProductResponse getProduct(@RequestPayload GetProductRequest request) {
        return productHandler.getProduct(request.getId());

    }
}
