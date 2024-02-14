package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.List;

import  static  org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    ProductRepository productRepository;
    @Mock
    private Model model;
    @Mock
    private ProductService productService;
    @InjectMocks
    private ProductController productController;


    @BeforeEach
    void setUp(){MockitoAnnotations.openMocks(this);}

    @Test
    void TestCreateProductPage() {
        String expectedViewName = "createProduct";
        String actualViewName = productController.createProductPage(model);

        assertEquals(expectedViewName, actualViewName);
        verify(model, times(1)).addAttribute(eq("product"), any(Product.class));
    }

    @Test
    void TestProductListPage() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("PS5");
        product1.setProductQuantity(300);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Apple Vision Pro");
        product2.setProductQuantity(250);
        productRepository.create(product2);

        List<Product> productList = List.of(product1, product2);

        when(productService.findAll()).thenReturn(productList);

        String viewName = productController.productListPage(model);

        assertEquals("productList", viewName);
        verify(model, times(1)).addAttribute("products", productList);

        verify(productService, times(1)).findAll();
    }
}
