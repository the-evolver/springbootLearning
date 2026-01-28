package com.example.jpaTutorial;

import com.example.jpaTutorial.dto.CProductEntityDtoPriceCount;
import com.example.jpaTutorial.dto.CProductEntityDtoTitleCount;
import com.example.jpaTutorial.dto.CProductEntityDtoTitleQuantity;
import com.example.jpaTutorial.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProjectionTest {

     @Autowired
     private ProductRepository productRepository;

     @Test
     void ak(){
//        Create an interface projection returning only title and price.
//         List<IProductEntityDtoTitlePrice> iProductEntityTitlePriceList = productRepository.findBy();
//         int count = 0;
//         for(IProductEntityDtoTitlePrice iP : iProductEntityTitlePriceList) {
//             System.out.println(iP+"\n");
//             count++;
//         }
//         System.out.println("total projected data => "+count);

//         Write a method to fetch all products with quantity > 50 using that projection.
//         List<IProductEntityDtoTitlePrice> iProductEntityTitlePriceList = productRepository.findByQuantityGreaterThan(50);
//         print(iProductEntityTitlePriceList);

//         Add one more: projection for sku + quantity.
//         List<IProductEntityDtoSkuQuantity> iProductEntitySkuQuantityList = productRepository.findBy();
//         print(iProductEntitySkuQuantityList);

// Create a DTO: ProductInfoDto(title, quantity).Write a JPQL query that returns products where price > 30.

//         List<CProductEntityDtoTitleQuantity> cProductEntityTitleQuantityList = productRepository.
//                 findProductWithPriceMoreThan(BigDecimal.valueOf(260));
//         print(cProductEntityTitleQuantityList);

//    Write a JPQL query that returns top 5 most expensive products using DTO.
//      List<CProductEntityDtoTitleQuantity> cProductEntityTitleQuantityList = productRepository.topNMostExpensiveProducts(5);
//      print(cProductEntityTitleQuantityList);

//     Count products grouped by title.

//       List<CProductEntityDtoTitleCount> cProductEntityDtoTitleCountList = productRepository.findProductsGroupByTitle();
//       print(cProductEntityDtoTitleCountList);

//         Count products grouped by price.

//         List<CProductEntityDtoPriceCount> cProductEntityDtoPriceCountList = productRepository.findProductsGroupByPrice();
//         print(cProductEntityDtoPriceCountList);

//         Sum all quantities for entire table.

//          Integer sumOfAllQuantity = productRepository.sumOfAllQuantity();
 //         System.out.println("Sum all quantities for entire table -> "+sumOfAllQuantity);

 //        List<CProductEntityDtoPriceCount> cProductEntityDtoPriceCountList = productRepository.findProductsWithLeastQuantityGroupByPrice(50);
  //       print(cProductEntityDtoPriceCountList);

         List<CProductEntityDtoTitleQuantity> cProductEntityTitleQuantityList = productRepository.
                findProductWithPriceMoreThan(BigDecimal.valueOf(50));
         print(cProductEntityTitleQuantityList);






     }
     <E> void print(List<E> currList){
            int count = 0;
         for(E iP : currList) {
             System.out.println(iP+"\n");
             count++;
         }
         System.out.println("total projected data => "+count);
     }
}
