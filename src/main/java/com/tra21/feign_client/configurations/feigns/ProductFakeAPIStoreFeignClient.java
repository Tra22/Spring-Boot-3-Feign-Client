package com.tra21.feign_client.configurations.feigns;

import com.tra21.feign_client.dtos.requests.FilterListDto;
import com.tra21.feign_client.dtos.requests.products.CreateProductRequestDto;
import com.tra21.feign_client.dtos.requests.products.UpdateProductRequestDto;
import com.tra21.feign_client.dtos.responses.products.ProductResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "fakestoreapi-products", url = "https://fakestoreapi.com", path = "/products")
public interface ProductFakeAPIStoreFeignClient {
    @GetMapping
    List<ProductResponseDto> getProducts(FilterListDto filterListDto);

    @GetMapping("/{id}")
    ProductResponseDto getProductById(@PathVariable("id") Long id);

    @GetMapping("/categories")
    List<String> getCategories();

    @GetMapping("/categories/{name}")
    String getCategoryByName(@PathVariable("name") String name);

    @PostMapping
    ProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto);

    @PutMapping("/{id}")
    ProductResponseDto updateProduct(@PathVariable("id") Long id, @RequestBody UpdateProductRequestDto updateProductRequestDto);

    @DeleteMapping("/{id}")
    ProductResponseDto deleteProduct(@PathVariable("id") Long id);

}
