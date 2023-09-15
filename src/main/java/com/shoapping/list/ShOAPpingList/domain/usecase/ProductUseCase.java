package com.shoapping.list.ShOAPpingList.domain.usecase;

import com.shoapping.list.ShOAPpingList.domain.api.IProductServicePort;
import com.shoapping.list.ShOAPpingList.domain.models.Product;
import com.shoapping.list.ShOAPpingList.domain.spi.IProductPersistencePort;

import java.util.List;

public class ProductUseCase implements IProductServicePort {
    private final IProductPersistencePort productPersistencePort;

    public ProductUseCase(IProductPersistencePort productPersistencePort){
        this.productPersistencePort = productPersistencePort;
    }
                          @Override
    public void saveProduct(Product product) {
        productPersistencePort.saveProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productPersistencePort.getAllProducts();
    }

    @Override
    public Product getProduct(Long id) {
        return productPersistencePort.getProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
        productPersistencePort.updateProduct(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productPersistencePort.deleteProduct(id);
    }
}
