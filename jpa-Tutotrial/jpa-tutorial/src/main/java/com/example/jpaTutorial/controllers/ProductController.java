package com.example.jpaTutorial.controllers;

import com.example.jpaTutorial.Service.ProductService;
import com.example.jpaTutorial.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/getAllProducts")
    List<ProductEntity> getAllProducts(@RequestParam(name = "sort",defaultValue = "id") String sortBy){
        System.out.println("field -> "+sortBy);
        return productService.
                getAllProducts(sortBy);

    }

    @GetMapping(path = "/getAllProductsWithPrice")
    List<ProductEntity> getAllProductsWithPrice(@RequestParam(name = "price",defaultValue = "100") String value){
        System.out.println("value -> "+value);
        return productService.
                getAllProductsWithPrice(value);

    }

    @GetMapping(path = "/getProductsOnPage")
    List<ProductEntity> getProductsOnPage(@RequestParam(name = "pageNo",defaultValue = "0") String pageNum){
        System.out.println("pageNum -> "+pageNum);
        return productService.
                getProductsOnPage(pageNum);

    }







}
