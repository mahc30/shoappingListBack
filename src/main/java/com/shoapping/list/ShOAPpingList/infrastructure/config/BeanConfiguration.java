package com.shoapping.list.ShOAPpingList.infrastructure.config;

import com.shoapping.list.ShOAPpingList.domain.api.IProductServicePort;
import com.shoapping.list.ShOAPpingList.domain.spi.IProductPersistencePort;
import com.shoapping.list.ShOAPpingList.domain.usecase.ProductUseCase;
import com.shoapping.list.ShOAPpingList.infrastructure.out.jpa.adapter.ProductJpaAdapter;
import com.shoapping.list.ShOAPpingList.infrastructure.out.jpa.mapper.ProductEntityMapper;
import com.shoapping.list.ShOAPpingList.infrastructure.out.jpa.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper;

    @Bean
    public IProductPersistencePort productPersistencePort(){
        return new ProductJpaAdapter(productRepository, productEntityMapper);
    }

    @Bean
    public IProductServicePort productServicePort(){
        return new ProductUseCase(productPersistencePort());
    }
}
