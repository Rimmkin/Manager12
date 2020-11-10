package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    public void matchesTrue() {
        Product one = new Product(1, "TV", 20000);
        boolean expected = true;
        boolean actual = one.matches("TV");
        assertTrue(actual);
    }

    @Test
    public void matchesFalse() {
        Product one = new Product(1, "TV", 20000);
        boolean expected = false;
        boolean actual = one.matches("Car");
        assertFalse(actual);
    }
}
