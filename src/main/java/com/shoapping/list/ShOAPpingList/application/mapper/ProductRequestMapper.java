package com.shoapping.list.ShOAPpingList.application.mapper;

import com.shoapping.list.ShOAPpingList.application.dto.request.ProductRequest;
import com.shoapping.list.ShOAPpingList.domain.models.Product;
import localhost._8080.soap.product.SaveProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductRequestMapper {
    Product toProduct(ProductRequest productRequest);
    Product toProduct(SaveProductRequest productRequest);

}
