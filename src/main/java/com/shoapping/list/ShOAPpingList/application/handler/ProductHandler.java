package com.shoapping.list.ShOAPpingList.application.handler;

import com.shoapping.list.ShOAPpingList.application.dto.request.ProductRequest;
import com.shoapping.list.ShOAPpingList.application.dto.response.ProductResponse;
import com.shoapping.list.ShOAPpingList.application.mapper.ProductRequestMapper;
import com.shoapping.list.ShOAPpingList.application.mapper.ProductResponseMapper;
import com.shoapping.list.ShOAPpingList.domain.api.IProductServicePort;
import com.shoapping.list.ShOAPpingList.domain.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductHandler implements IProductHandler{
    private final ProductRequestMapper productRequestMapper;
    private final IProductServicePort productServicePort;
    private final ProductResponseMapper productResponseMapper;
    @Override
    public void saveProduct(ProductRequest productRequest) {
        Product product = productRequestMapper.toProduct(productRequest);
        productServicePort.saveProduct(product);
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        return productResponseMapper.toResponseList(productServicePort.getAllProducts());
    }

    @Override
    public ProductResponse getProduct(Long productNumber) {
        Product product = productServicePort.getProduct((productNumber));
        return productResponseMapper.toResponse(product);
    }

    @Override
    public void updateProduct(ProductRequest productRequest) {
        Product oldProduct = productServicePort.getProduct(productRequest.getId());
        Product newProduct = productRequestMapper.toProduct(productRequest);
        newProduct.setId(oldProduct.getId());
        productServicePort.saveProduct(newProduct);
    }

    @Override
    public void deleteProduct(Long productNumber) {
        Product product = productServicePort.getProduct(productNumber);
        productServicePort.deleteProduct(productNumber);
    }
}
