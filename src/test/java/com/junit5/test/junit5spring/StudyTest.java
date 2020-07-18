package com.junit5.test.junit5spring;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class StudyTest {

    @Test
    void create() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create1");
    }

    @Test
    @Disabled
    void create2() {
        Study study2 = new Study();
        assertNotNull(study2);
        System.out.println("create2");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("@beforeAll");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("@afterAll");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("@beforeEach");
    }

    @AfterEach
    void afterEach(){
        System.out.println("@afterEach");
    }
}