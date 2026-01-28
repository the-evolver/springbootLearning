package com.example.jpaTutorial;

import com.example.jpaTutorial.entities.ProductEntity;
import com.example.jpaTutorial.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class JpaTutotrialApplicationTests {


    @Autowired
    private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void FetchProduct(){
//        List<ProductEntity> allProducts = productRepository.findAll();
//        for(ProductEntity productEntity : allProducts){
//            System.out.println("Product data ================\n"+ productEntity);
//        }

    }

    @Test
    void saveProduct(){

//        for(int i = 1 ; i <= 5 ; i++){
//            ProductEntity productEntity = ProductEntity.builder()
//                               .sku("loco-choco-pie-"+ i)
//                               .title("loco-choco-pie-"+i)
//                               .price(BigDecimal.valueOf(200.0000 + i))
//                               .quantity(i*i)
//                               .build();
//
//            ProductEntity savedProduct = productRepository.save(productEntity);
//            System.out.println("========== \n"+savedProduct);
//
//        }

    }
   // @Rollback(false) only needed if we want to persist the transaction because in test env sb by default rolls back
    @Transactional
    @Test
    void getCustomQueryData(){
 /*
Q1: Find a product by its SKU.

         List <ProductEntity> findBySku = productRepository.findBySku("loco-choco-pie-1");
         for(ProductEntity p : findBySku) System.out.println(p);

Q2: Find all products that have price less than 20.

        List<ProductEntity> allProductTillPrice20 = productRepository.findByPriceLessThan(BigDecimal.valueOf(20));
        for(ProductEntity p : allProductTillPrice20) System.out.println(p);


Q3: Find all products with title containing “Milk”.

        List<ProductEntity> ans = productRepository.findByTitleContaining("Milk");
        for(ProductEntity p : ans) System.out.println(p);


Q4: Find products whose quantity is exactly 0 (out of stock).

        List<ProductEntity> ans = productRepository.findByQuantity(0);
        for(ProductEntity p : ans) System.out.println(p);


Q5: Check if a product exists with title “Kitkat”.

        Boolean exists = productRepository.existsByTitle("Kitkat");
        System.out.println("Product with title kitkat exists => "+exists);

Q6: Find products where title contains “Snickers” AND quantity > 10.

        List<ProductEntity> ans = productRepository
                                          .findByTitleContainingAndQuantityGreaterThan("Snickers",10);
        for(ProductEntity p : ans) System.out.println(p);

Q7: Find products where price is between 10 and 50.

         List<ProductEntity> ans = productRepository.findByPriceBetween(10,50);
         for(ProductEntity pE : ans) System.out.println(pE);

Q8: Find the product where SKU equals “SKU-101” AND price equals 120.

        List<ProductEntity> ans = productRepository.findBySkuAndPrice("SKU-101",120);
        for(ProductEntity pE : ans) System.out.println(pE);

Q9: Find all products where quantity is less than 5 OR price is greater than 100.

          List<ProductEntity> ans = productRepository.findByQuantityLessThanOrPriceGreaterThan(5,100);
          for(ProductEntity pE : ans) System.out.println(pE);

Q10: Count number of products with quantity > 50.

           Integer ans = productRepository.countByQuantityGreaterThan(50);
           System.out.println("Number of Products with quantity greater than 50 is "+ans);

Q11: Find all products ordered by price (highest first).

           List<ProductEntity> ans = productRepository.OrderByPriceDesc();
           for(ProductEntity pE : ans) System.out.println(pE);

Q12: Find top 3 cheapest products.

           List<ProductEntity> ans = productRepository.findTop3ByOrderByPriceAsc();
           for(ProductEntity pE : ans) System.out.println(pE);

Q13: Find top 5 products with the highest quantity.

           List<ProductEntity> ans = productRepository.findTop5ByOrderByQuantityDesc();
           for(ProductEntity pE : ans) System.out.println(pE);

Q14: Find products with title starting with “Dairy” sorted by price ascending.

          List<ProductEntity> pr = productRepository.findByTitleStartingWithOrderByPriceAsc("Dairy");
          for(ProductEntity p : pr) System.out.println(p);

Q15: Find products with quantity > 10 sorted by quantity descending.

          List<ProductEntity> pr = productRepository.findByQuantityGreaterThanOrderByQuantityDesc(10);
          for(ProductEntity p : pr) System.out.println(p);


Q16: Delete all products with price < 10.

      int deleted = productRepository.deleteByPriceLessThan(10);
      System.out.println("Deleted rows: " + deleted);

Q17: Delete products that have quantity = 0.

       int deleted = productRepository.deleteByQuantity(0);
       System.out.println("Deleted rows: " + deleted);

Q18: Remove product with SKU = “SKU-108”.

     int deleted = productRepository.deleteBySku("SKU-109");
     System.out.println("Deleted rows: " + deleted);

Q19: Check if any product exists with quantity between 100 and 200.

      Boolean productExists = productRepository.existsByQuantityBetween(100,200);
      System.out.println("if any product exists with quantity between 100 and 200."+productExists);

Q20: Check if any product exists with title ending with “bar”.

     Boolean productExists = productRepository.existsByTitleEndsWith("bar");
     System.out.println("if any product exists with title ending with bar " +productExists);

Q21: Find products where (title starts with “S”) AND (price < 50).

     List<ProductEntity> products = productRepository
                        .findByTitleStartsWithAndPriceLessThan("S",50);
     for(ProductEntity p : products) System.out.println(p);

Q22: Find the first product ordered by price descending.

      ProductEntity product = productRepository
                .findTopByOrderByPriceDesc();
      System.out.println(product);

Q23: Find products where price is in the list [10, 20, 30].

     List<ProductEntity> product = productRepository
                .findByPriceIn(new int[]{10, 20, 30});
     for(ProductEntity p : product) System.out.println(p);

Q24: Find products where title NOT containing “Milk”.

     List<ProductEntity> product = productRepository
                .findByTitleNotLike("%Milk%");
     for(ProductEntity p : product) System.out.println(p);


Q25: Find products where title matches regex “^K.*k$” (starts with K, ends with k).

     List<ProductEntity> product = productRepository
                .findByTitleLike("^K.*k$");
     for(ProductEntity p : product) System.out.println(p);


       practice sort + pagination ....
       LEVEL 1 — Sorting

       Get all products sorted by title ascending.


        Sort sort = Sort.by(Sort.Order.asc("title"));
        List<ProductEntity> allProducts = productRepository.findAll(sort);
        for(ProductEntity p : allProducts) System.out.println(p);


        Get all products sorted by quantity descending.

        Sort sort = Sort.by(Sort.Order.desc("quantity"));
        List<ProductEntity> allProducts = productRepository.findAll(sort);
        for(ProductEntity p : allProducts) System.out.println(p);

        Get all products sorted by price ascending AND quantity descending.

        Sort sort = Sort.by(Sort.Order.asc("price"),Sort.Order.desc("quantity"));
        List<ProductEntity> allProducts = productRepository.findAll(sort);
        for(ProductEntity p : allProducts) System.out.println(p);

        Find all products with quantity > 50 sorted by title descending.

        Sort sort = Sort.by(Sort.Order.desc("title"));
        List<ProductEntity> allProducts = productRepository.findByQuantityGreaterThan(50,sort);
        for(ProductEntity p : allProducts) System.out.println(p);

        LEVEL 2 — Pagination

        Get first page of products with page size 5.

        Pageable page = PageRequest.of(0,5);
        List<ProductEntity> allProducts = productRepository.findAll(page).getContent();
        for(ProductEntity p : allProducts) System.out.println(p);

        Get second page of products with page size 3.

        Pageable page = PageRequest.of(1,3);
        List<ProductEntity> allProducts = productRepository.findAll(page).getContent();
        for(ProductEntity p : allProducts) System.out.println(p);

        Get first 10 “Kitkat” products (title contains Kitkat).
        Pageable page = PageRequest.of(0,10);
        List<ProductEntity> allProducts = productRepository.findByTitleContaining("Kitkat",page);
        for(ProductEntity p : allProducts) System.out.println(p);

        Get page 0 size 5 sorted by price descending.

        Pageable page = PageRequest.of(0,5,Sort.by(Sort.Order.desc("price")));
        List<ProductEntity> allProducts = productRepository.findAll(page).getContent();
        for(ProductEntity p : allProducts) System.out.println(p);

        LEVEL 3 — Pagination + Filtering + Sorting

        Find products with price < 50, second page  of size 4 sorted by quantity descending.

        Pageable page = PageRequest.of(1,4,Sort.by(Sort.Order.desc("quantity")));
        List<ProductEntity> allProducts = productRepository.findByPriceLessThan(BigDecimal.valueOf(50),page);
        for(ProductEntity p : allProducts) System.out.println(p);

        Find products containing “Milk” in title, first page  size 3 sorted by price ascending.

        Pageable page = PageRequest.of(0,3,Sort.by(Sort.Order.asc("price")));
        List<ProductEntity> allProducts = productRepository.findByTitleContaining("Milk",page);
        for(ProductEntity p : allProducts) System.out.println(p);

        Get top 5 most expensive products using pagination.

        Pageable page = PageRequest.of(0,5,Sort.by(Sort.Order.desc("price")));
        List<ProductEntity> allProducts = productRepository.findAll(page).getContent();
        for(ProductEntity p : allProducts) System.out.println(p);

        Find products with quantity between 10 and 100, second page size 5 sorting by title.

        Pageable page = PageRequest.of(1,5,Sort.by(Sort.Order.asc("title")));
        List<ProductEntity> allProducts = productRepository.findByQuantityBetween(10,100,page);
        for(ProductEntity p : allProducts) System.out.println(p);


*/



    }



}
