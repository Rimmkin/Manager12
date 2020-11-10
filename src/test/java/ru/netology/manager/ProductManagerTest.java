package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class ProductManagerTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    ProductManager productManager;

    Product one = new Smartphone(1, "Samsung", 20000, "Korea");
    Product two = new Book(2, "detective", 500,  "Agatha Christie");
    Product three = new Book(3, "fairytale", 400, "Pushkin");
    Product four = new Product(4, "TV", 10000);
    Product five = new Book(5, "detective", 500, "Doyle");

    @BeforeEach
    public void setUp() {
        productManager.add(one);
        productManager.add(two);
        productManager.add(three);
        productManager.add(four);
        productManager.add(five);
    }

    @Test
    public void checkSearchBookName() {
        Product[] returned = new Product[] {one, two, three, four, five};
        doReturn(returned).when(productRepository).findAll();
        Product[] expected = new Product[]{two};
        Product[] actual = productManager.searchBy("Agatha Christie");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkSearchSmartphoneProducer() {
        Product[] returned = new Product[] {one, two, three, four, five};
        doReturn(returned).when(productRepository).findAll();
        Product[] expected = new Product[]{one};
        Product[] actual = productManager.searchBy("Korea");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkSearchSmartphoneName() {
        Product[] returned = new Product[] {one, two, three, four, five};
        doReturn(returned).when(productRepository).findAll();
        Product[] expected = new Product[]{one};
        Product[] actual = productManager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkSearchBookAuthor() {
        Product[] returned = new Product[] {one, two, three, four, five};
        doReturn(returned).when(productRepository).findAll();
        Product[] expected = new Product[]{three};
        Product[] actual = productManager.searchBy("Pushkin");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkSearchEmpty() {
        Product[] returned = new Product[] {one, two, three, four, five};
        doReturn(returned).when(productRepository).findAll();
        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy("iPhone");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkSearchProduct() {
        Product[] returned = new Product[] {one, two, three, four, five};
        doReturn(returned).when(productRepository).findAll();
        Product[] expected = new Product[]{four};
        Product[] actual = productManager.searchBy("TV");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkSearchTwo() {
        Product[] returned = new Product[] {one, two, three, four, five};
        doReturn(returned).when(productRepository).findAll();
        Product[] expected = new Product[]{two, five};
        Product[] actual = productManager.searchBy("detective");
        assertArrayEquals(expected, actual);
    }
}