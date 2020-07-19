package com.junit5.test.junit5spring;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestOrder {

    @Order(2)
    @Test
    @DisplayName("order1")
    void order1() {
        System.out.println("order1 테스트");
    }

    @Order(3)
    @Test
    @DisplayName("order2")
    void order2() {
        System.out.println("order2 테스트");
    }

    @Order(1)
    @Test
    @DisplayName("order3")
    void order3() {
        System.out.println("order3 테스트");
    }

}