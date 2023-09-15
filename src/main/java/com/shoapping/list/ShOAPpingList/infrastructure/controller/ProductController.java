package com.shoapping.list.ShOAPpingList.infrastructure.controller;

import com.shoapping.list.ShOAPpingList.application.dto.request.ProductRequest;
import com.shoapping.list.ShOAPpingList.application.dto.response.ProductResponse;
import com.shoapping.list.ShOAPpingList.application.handler.IProductHandler;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final IProductHandler productHandler;

    @ApiOperation(value = "Add a new product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Product created"),
            @ApiResponse(code = 409, message = "Product already exists")
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveProduct(@RequestBody ProductRequest productRequest) {
        productHandler.saveProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Get all the products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All products returned"),
            @ApiResponse(code = 404, message = "No data found")
    })
    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> getAllProduct() {
        return ResponseEntity.ok(productHandler.getAllProduct());
    }

    @ApiOperation(value = "Get a product by their Number")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product found"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @GetMapping("/{number}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable(value = "number") Long productNumber) {
        return ResponseEntity.ok(productHandler.getProduct(productNumber));
    }

    @ApiOperation(value = "Update an existing product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product updated"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @PutMapping("/")
    public ResponseEntity<Void> updateProduct(@RequestBody ProductRequest productRequest) {
        productHandler.updateProduct(productRequest);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete a product by their Number")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product deleted"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @DeleteMapping("/{productNumber}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productNumber) {
        productHandler.deleteProduct(productNumber);
        return ResponseEntity.noContent().build();
    }
}
