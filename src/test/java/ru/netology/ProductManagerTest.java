package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.*;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(11, "Всадник без головы", 450, "Томас Майн Рид");
    Book book2 = new Book(14, "Оцеола, вождь семинолов", 450, "Томас Майн Рид");
    Book book3 = new Book(23, "Квартеронка", 230, "Томас Майн Рид");
    Book book4 = new Book(24, "Морской волчонок", 223, "Томас Майн Рид");

    Book book5 = new Book(11, "Всадник без головы", 350, "Томас Майн Рид");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
    }

    @Test
    public void testsMatchesT() {
        boolean expected = true;
        boolean actual = manager.matches(book1, "Всадник без головы");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesF() {
        boolean expected = false;
        boolean actual = manager.matches(book2, "Квартеронка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchBy() {
        Product[] expected = {book1, book5};
        Product[] actual = manager.searchBy("Всадник без головы");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindAll() {
        Product[] expected = {book1, book2, book3, book4, book5};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveById() {
        Product[] expected = {book1, book3, book4, book5};
        Product[] actual = repo.removeById(14);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByZero() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Пупс");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearchByOne() {
        Product[] expected = {book4};
        Product[] actual = manager.searchBy("Морской волчонок");
        Assertions.assertArrayEquals(expected, actual);
    }

}
