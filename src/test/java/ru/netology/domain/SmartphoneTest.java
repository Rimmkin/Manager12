package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    public void matchesTrue() {
        Product one = new Smartphone(1, "iPhone", 50000, "China");
        boolean expected = true;
        boolean actual = one.matches("iPhone");
        assertTrue(actual);
    }

    @Test
    public void matchesFalse() {
        Product one = new Smartphone(1, "iPhone", 50000, "China");
        boolean expected = false;
        boolean actual = one.matches("Samsung");
        assertFalse(actual);
    }
}
