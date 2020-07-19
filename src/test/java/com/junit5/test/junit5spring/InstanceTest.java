package com.junit5.test.junit5spring;

import org.junit.jupiter.api.*;


//  테스트마다 인스턴스를 생성하지 않고 한개의 인스턴스로
//  한개의 클래스의 테스트 코드를 책임지는 어노테이션
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InstanceTest {

    int num = 1;

    //    @BeforeAll, @AfterAll 어노테이션은 항상 static으로 만들어야 하는데
    //    @TestInstance를 사용하여 인스턴스를 공유할 때는 static으로 만들어주지 않아도 된다.
    @BeforeAll
    void before_all() {
        System.out.println("@BeforeAll");
    }

    @AfterAll
    void after_all() {
        System.out.println("@AfterAll");
    }

    @DisplayName("반복 파라미터 테스트")
    @RepeatedTest(value = 3, name = "{displayName}, {currentRepetition} / {totalRepetitions}")
    void parameterized_test() {
        System.out.println(num++);
        System.out.println(this);
    }

    @DisplayName("반복 파라미터 테스트")
    @RepeatedTest(value = 3, name = "{displayName}, {currentRepetition} / {totalRepetitions}")
    void parameterized_test2() {
        System.out.println(num++);
        System.out.println(this);
    }

}