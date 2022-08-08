package com.micro.product.services.imp;

import com.micro.product.model.Category;
import com.micro.product.model.Product;
import com.micro.product.repository.ProductRepository;
import com.micro.product.services.IProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private IProductService productService;


    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductService(productRepository);
        Product product = Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder()
                        .id(1l)
                        .name("computacion")
                        .build())
                .price(Double.parseDouble("22.3"))
                .stock(Double.parseDouble("5"))
                .build();
        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));
        Mockito.when(productRepository.save(product))
                .thenReturn(product);
    }


    @Test
    public void getById(){
        Product productFound = productService.getById(1l);
        Product product = Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder()
                        .id(1l)
                        .name("computacion")
                        .build())
                .price(Double.parseDouble("22.3"))
                .stock(Double.parseDouble("5"))
                .build();
        Assertions.assertEquals(productFound, product );
    }

    @Test
    public void save(){
        Product product = Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder()
                        .id(1l)
                        .name("computacion")
                        .build())
                .price(Double.parseDouble("22.3"))
                .stock(Double.parseDouble("5"))
                .build();
        Product productSave = productService.save(product);
        Assertions.assertEquals(productSave, product);
    }

}