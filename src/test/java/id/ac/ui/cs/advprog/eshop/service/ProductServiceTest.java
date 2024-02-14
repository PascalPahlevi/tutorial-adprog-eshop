package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateProduct() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);

        assertNotNull(createdProduct);
        assertEquals(product, createdProduct);

        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testFindAllProducts() {
        List<Product> productList = List.of(new Product(), new Product());
        when(productRepository.findAll()).thenReturn(productList.iterator());

        List<Product> retrievedProducts = productService.findAll();

        assertEquals(productList, retrievedProducts);

        verify(productRepository, times(1)).findAll();
    }


    @Test
    void testFindProductById() {
        String productId = "a0f9de46-90b1-437d-a0bf-d0821dde9096";
        Product product = new Product();
        when(productRepository.findById(productId)).thenReturn(product);

        Product retrievedProduct = productService.findById(productId);

        assertNotNull(retrievedProduct);
        assertEquals(product, retrievedProduct);

        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();
        when(productRepository.update(product)).thenReturn(product);

        Product updatedProduct = productService.update(product);

        assertNotNull(updatedProduct);
        assertEquals(product, updatedProduct);

        verify(productRepository, times(1)).update(product);
    }

    @Test
    void testDeleteProduct() {
        String productId = "a0f9de46-90b1-437d-a0bf-d0821dde9096";

        productService.delete(productId);

        verify(productRepository, times(1)).delete(productId);
    }
}

