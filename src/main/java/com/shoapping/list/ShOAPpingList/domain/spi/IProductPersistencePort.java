package com.shoapping.list.ShOAPpingList.domain.spi;

import com.shoapping.list.ShOAPpingList.domain.models.Product;

import java.util.List;

public interface IProductPersistencePort {
    void saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProduct(Long id);
    void updateProduct(Product product);
    void deleteProduct(Long id);
}
