package com.example.jpaTutorial.repositories;

import com.example.jpaTutorial.dto.*;
import com.example.jpaTutorial.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findBySku(String sku);

    List<ProductEntity> findByPriceLessThan(BigDecimal price);

    List<ProductEntity> findByPriceLessThan(BigDecimal price,Pageable page);

    List<ProductEntity> findByTitleContaining(String title);

    List<ProductEntity> findByTitleContaining(String title , Pageable page);

    List<ProductEntity> findByQuantity(int quantity);

    Boolean existsByTitle(String title);

    List<ProductEntity> findByTitleContainingAndQuantityGreaterThan(String title ,int quantity);

    List<ProductEntity> findByPriceBetween(int minPrice, int maxPrice);

    List<ProductEntity> findBySkuAndPrice(String sku, int price);

    List<ProductEntity> findByQuantityLessThanAndPriceGreaterThan(int quantity, int price);

    Integer countByQuantityGreaterThan(int quantity);

    List<ProductEntity> OrderByPriceDesc();




    List<ProductEntity> findTop3ByOrderByPriceAsc();

    List<ProductEntity> findTop5ByOrderByQuantityDesc();

    List<ProductEntity> findByTitleStartingWithOrderByPriceAsc(String title);

    List<ProductEntity> findByQuantityGreaterThanOrderByQuantityDesc(int quantity);

    int deleteByPriceLessThan(int i);

    int deleteByQuantity(int quantity);

    int deleteBySku(String s);

    Boolean existsByQuantityBetween(int lowerBound, int upperBound);

    Boolean existsByTitleEndsWith(String titleEnding);

    List<ProductEntity> findByTitleStartsWithAndPriceLessThan(String startingChar, int maxPrice);

    ProductEntity findTopByOrderByPriceDesc();

    List<ProductEntity> findByPriceIn(int[] range);

    List<ProductEntity> findByTitleNotLike(String titleStr);

    List<ProductEntity> findByTitleLike(String regex);

    List<ProductEntity> findByPrice(BigDecimal value, Sort sort);

    List<ProductEntity> findByQuantityGreaterThan(int minQuantity, Sort sort);

    List<ProductEntity> findByQuantityBetween(int minQuantity, int maxQuantity, Pageable page);

    //List<IProductEntityTitlePrice> findBy();

    List<IProductEntityDtoSkuQuantity> findBy();

    List<IProductEntityDtoTitlePrice> findByQuantityGreaterThan(int quantity);

    @Query("Select new com.example.jpaTutorial.dto.CProductEntityDtoTitleQuantity(p.title,p.quantity) FROM ProductEntity as p WHERE p.price > :price")
    List<CProductEntityDtoTitleQuantity> findProductWithPriceMoreThan(@Param("price") BigDecimal price);

    @Query("Select new com.example.jpaTutorial.dto.CProductEntityDtoTitleQuantity(p.title,p.quantity) from ProductEntity as p Order by p.price desc Limit 5")
    List<CProductEntityDtoTitleQuantity> topNMostExpensiveProducts(@RequestParam int topNProducts);

    @Query("Select new com.example.jpaTutorial.dto.CProductEntityDtoTitleCount(p.title,COUNT(p)) From ProductEntity p Group by p.title Order by Count(p)")
    List<CProductEntityDtoTitleCount> findProductsGroupByTitle();

    @Query("SELECT new com.example.jpaTutorial.dto.CProductEntityDtoPriceCount(p.price,COUNT(p)) FROM ProductEntity p GROUP BY p.price ORDER BY p.price desc")
    List<CProductEntityDtoPriceCount> findProductsGroupByPrice();

    @Query("SELECT SUM(p.quantity) FROM ProductEntity p")
    Integer sumOfAllQuantity();

    @Query("SELECT new com.example.jpaTutorial.dto.CProductEntityDtoPriceCount(p.price,COUNT(p)) FROM ProductEntity p WHERE p.quantity > :quantity GROUP BY p.price ORDER BY p.price desc")
    List<CProductEntityDtoPriceCount> findProductsWithLeastQuantityGroupByPrice(int quantity);

}
