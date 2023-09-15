package com.shoapping.list.ShOAPpingList.infrastructure.out.jpa.mapper;

import com.shoapping.list.ShOAPpingList.domain.models.Product;
import com.shoapping.list.ShOAPpingList.infrastructure.out.jpa.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductEntityMapper {
    ProductEntity toEntity(Product product);
    Product toProduct(ProductEntity productEntity);
    List<Product> toProductList(List<ProductEntity> productEntities);
}
