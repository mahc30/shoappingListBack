package com.shoapping.list.ShOAPpingList.infrastructure.out.jpa.adapter;

import com.shoapping.list.ShOAPpingList.domain.models.Product;
import com.shoapping.list.ShOAPpingList.domain.spi.IProductPersistencePort;
import com.shoapping.list.ShOAPpingList.infrastructure.exception.NoDataFoundException;
import com.shoapping.list.ShOAPpingList.infrastructure.exception.ProductAlreadyExistsException;
import com.shoapping.list.ShOAPpingList.infrastructure.exception.ProductNotFoundException;
import com.shoapping.list.ShOAPpingList.infrastructure.out.jpa.entity.ProductEntity;
import com.shoapping.list.ShOAPpingList.infrastructure.out.jpa.mapper.ProductEntityMapper;
import com.shoapping.list.ShOAPpingList.infrastructure.out.jpa.repository.IProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductJpaAdapter implements IProductPersistencePort {
    private final IProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public void saveProduct(Product product){
        System.out.println("JPAaDapter:");
        System.out.println(product.getPrice());
        System.out.println(product.getId());
        System.out.println(product.getName());
        if(productRepository.findById(product.getId()).isPresent()){
            throw new ProductAlreadyExistsException();
        }

        ProductEntity entity = productEntityMapper.toEntity(product);
        productRepository.save(entity);
    }

    @Override
    public List<Product> getAllProducts() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        if (productEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return productEntityMapper.toProductList(productEntityList);
    }

    @Override
    public Product getProduct(Long productNumber) {
        return productEntityMapper.toProduct(productRepository.findById(productNumber)
                .orElseThrow(ProductNotFoundException::new));
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(productEntityMapper.toEntity(product));
    }

    @Override
    public void deleteProduct(Long productNumber) {
        productRepository.deleteById(productNumber);
    }
}
