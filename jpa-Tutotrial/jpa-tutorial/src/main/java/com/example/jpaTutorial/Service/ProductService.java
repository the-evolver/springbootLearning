package com.example.jpaTutorial.Service;

import com.example.jpaTutorial.entities.ProductEntity;
import com.example.jpaTutorial.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final Integer PAGE_SIZE = 10;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> getAllProducts(String sortBy) {
//           Sort sort = Sort.by(Sort.Order.asc(sortBy),Sort.Order.desc("id"));
           Sort sort = Sort.by(Sort.Order.asc(sortBy));
           List<ProductEntity> allProducts = productRepository.findAll(sort);
           System.out.println("All Products ========= \n"+allProducts);
           return allProducts;
    }

    public List<ProductEntity> getAllProductsWithPrice(String value) {
        Sort sort =Sort.by(Sort.Order.asc("sku"));
        List<ProductEntity> allProducts = productRepository.
                findByPrice(BigDecimal.valueOf(Long.parseLong(value)),sort);
        System.out.println("All Products ========= \n"+allProducts);
        return allProducts;
    }

    public List<ProductEntity> getProductsOnPage(String pageNum) {
        Pageable page = PageRequest.of(Integer.parseInt(pageNum),PAGE_SIZE,Sort.by(Sort.Order.asc("id")));
        return productRepository.findAll(page).getContent();
    }
}
