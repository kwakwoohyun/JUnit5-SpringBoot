package com.junit5.test.junit5spring;

import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JUnit5Properties {

    int number = 1;

    @Order(1)
    @Test
    @Disabled
    void number1() {
        System.out.println(number++);
    }

    @Order(2)
    @Test
    void number2() {
        System.out.println(number++);
    }

}