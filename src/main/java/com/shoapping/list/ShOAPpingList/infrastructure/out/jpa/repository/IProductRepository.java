package com.shoapping.list.ShOAPpingList.infrastructure.out.jpa.repository;

import com.shoapping.list.ShOAPpingList.infrastructure.out.jpa.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findById(Long id);
    void deleteById(Long id);
}
