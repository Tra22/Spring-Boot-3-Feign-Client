package com.tra21.feign_client.controllers;

import com.tra21.feign_client.dtos.requests.FilterListDto;
import com.tra21.feign_client.dtos.requests.products.CreateProductRequestDto;
import com.tra21.feign_client.dtos.requests.products.UpdateProductRequestDto;
import com.tra21.feign_client.dtos.responses.products.ProductResponseDto;
import com.tra21.feign_client.configurations.feigns.ProductFakeAPIStoreFeignClient;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductAPIController {
    private final ProductFakeAPIStoreFeignClient productFakeAPIStoreFeignClient;
    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getProducts(FilterListDto filterListDto){
        return ResponseEntity.ok(this.productFakeAPIStoreFeignClient.getProducts(filterListDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.productFakeAPIStoreFeignClient.getProductById(id));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getCategories(){
        return ResponseEntity.ok(this.productFakeAPIStoreFeignClient.getCategories());
    }

    @GetMapping("/categories/{name}")
    public ResponseEntity<String> getCategoryByName(@PathVariable("name") String name){
        return ResponseEntity.ok(this.productFakeAPIStoreFeignClient.getCategoryByName(name));
    }
    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productFakeAPIStoreFeignClient.createProduct(createProductRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable("id") Long id, @RequestBody UpdateProductRequestDto updateProductRequestDto){
        return ResponseEntity.ok(this.productFakeAPIStoreFeignClient.updateProduct(id, updateProductRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseDto> deleteProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.productFakeAPIStoreFeignClient.deleteProduct(id));
    }
}
