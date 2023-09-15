package com.shoapping.list.ShOAPpingList.application.mapper;

import com.shoapping.list.ShOAPpingList.application.dto.response.ProductResponse;
import com.shoapping.list.ShOAPpingList.domain.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductResponseMapper {

    ProductResponse toResponse(Product product);
    default List<ProductResponse> toResponseList(List<Product> productList) {
        return productList.stream()
                .map(product -> {
                    ProductResponse productResponse = new ProductResponse();
                    productResponse.setId(product.getId());
                    productResponse.setName(product.getName());
                    productResponse.setNote(product.getNote());
                    productResponse.setPrice(product.getPrice());
                    return productResponse;
                }).collect(Collectors.toList());
    }
}
