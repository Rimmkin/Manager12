package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void matchesTrue() {
        Product one = new Book(1, "Java", 500, "Kulikov");
        boolean expected = true;
        boolean actual = one.matches("Java");
        assertTrue(actual);
    }

    @Test
    public void matchesFalse() {
        Product one = new Book(1, "QA", 300, "Kulikov");
        boolean expected = false;
        boolean actual = one.matches("Java");
        assertFalse(actual);
    }
}