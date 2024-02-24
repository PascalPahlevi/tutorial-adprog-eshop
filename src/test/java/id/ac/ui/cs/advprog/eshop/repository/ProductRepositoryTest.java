package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setUp() {
    }
    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setName("Sampo Cap Bambang");
        product.setQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getId(), savedProduct.getId());
        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getQuantity(), savedProduct.getQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }
    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setName("Sampo Cap Bambang");
        product1.setQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setName("Sampo Cap Usep");
        product2.setQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getId(), savedProduct.getId());
        savedProduct = productIterator.next();
        assertEquals(product2.getId(), savedProduct.getId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditProduct() {
        Product product1 = new Product();
        product1.setId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product1.setId("Sampo Cap Usep");
        product1.setQuantity(50);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setId(product1.getId());
        product2.setName("Apple Vision Pro");
        product2.setQuantity(100);
        productRepository.update(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();

        assertEquals(product1.getId(), savedProduct.getId());
        assertEquals(product2.getId(), savedProduct.getId());
        assertEquals(product2.getName(), savedProduct.getName());
        assertEquals(product2.getQuantity(), savedProduct.getQuantity());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product1.setName("Sampo Cap Usep");
        product1.setQuantity(50);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setId(product1.getId());
        product2.setName("Playstation 5");
        product2.setQuantity(80);
        productRepository.update(product2);

        Product product3 = new Product();
        product3.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product3.setName("Apple Vision Pro");
        product3.setQuantity(100);
        productRepository.create(product3);

        Product product4 = new Product();
        product4.setId(product3.getId());
        product4.setName("Metaquest 3");
        product4.setQuantity(100);
        productRepository.update(product4);

        Iterator<Product> productIterator = productRepository.findAll();

        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();

        assertEquals(product1.getId(), savedProduct.getId());
        assertEquals(product2.getId(), savedProduct.getId());
        assertEquals(product2.getName(), savedProduct.getName());
        assertEquals(product2.getQuantity(), savedProduct.getQuantity());

        assertTrue(productIterator.hasNext());
        savedProduct = productIterator.next();

        assertEquals(product3.getId(), savedProduct.getId());
        assertEquals(product4.getId(), savedProduct.getId());
        assertEquals(product4.getName(), savedProduct.getName());
        assertEquals(product4.getQuantity(), savedProduct.getQuantity());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteProduct() {
        Product product1 = new Product();
        product1.setId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product1.setName("Sampo Cap Usep");
        product1.setQuantity(50);
        productRepository.create(product1);

        productRepository.delete(product1.getId());

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteWithMultipleProducts() {
        Product product1 = new Product();
        product1.setId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product1.setName("Sampo Cap Usep");
        product1.setQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product2.setName("Playstation 5");
        product2.setQuantity(30);
        productRepository.create(product2);

        Product product3 = new Product();
        product3.setId("a1f8e34-2bc5-547f-82de54fb4f75");
        product3.setName("Metaquest 3");
        product3.setQuantity(23);
        productRepository.create(product3);

        Product product4 = new Product();
        product4.setId(product2.getId());
        product4.setName("Apple Vision Pro");
        product4.setQuantity(999);
        productRepository.create(product4);

        productRepository.delete(product1.getId());
        productRepository.delete(product3.getId());
        Iterator<Product> productIterator = productRepository.findAll();

        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();

        assertEquals(product2.getId(), savedProduct.getId());
        assertEquals(product2.getName(), savedProduct.getName());
        assertEquals(product2.getQuantity(), savedProduct.getQuantity());

        assertTrue(productIterator.hasNext());
        savedProduct = productIterator.next();
        assertEquals(product4.getId(), savedProduct.getId());
        assertEquals(product4.getName(), savedProduct.getName());
        assertEquals(product4.getQuantity(), savedProduct.getQuantity());

        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindByIdWhenProductExists() {
        Product product = new Product();
        product.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setName("Apple Vision Pro");
        product.setQuantity(50);
        productRepository.create(product);

        Product foundProduct = productRepository.findById("eb558e9f-1c39-460e-8860-71af6af63bd6");

        assertEquals(product, foundProduct);
    }

    @Test
    void testFindByIdWhenProductDoesNotExist() {
        Product foundProduct = productRepository.findById("ef649b34-6c54-5473-87f4-82fb90f6e943");

        assertNull(foundProduct);
    }
}