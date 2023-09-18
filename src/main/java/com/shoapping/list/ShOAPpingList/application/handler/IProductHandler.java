package com.shoapping.list.ShOAPpingList.application.handler;

import com.shoapping.list.ShOAPpingList.application.dto.request.ProductRequest;
import com.shoapping.list.ShOAPpingList.application.dto.response.ProductResponse;
import localhost._8080.soap.product.SaveProductRequest;

import java.util.List;

public interface IProductHandler  {
    void saveProduct(ProductRequest productRequest);
    void saveProduct(SaveProductRequest productRequest);

    List<ProductResponse> getAllProduct();

    ProductResponse getProduct(Long productId);

    void updateProduct(ProductRequest productRequest);

    void deleteProduct(Long productId);
}
