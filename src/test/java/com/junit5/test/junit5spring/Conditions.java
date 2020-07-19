package com.junit5.test.junit5spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class Conditions {

    //    코드로 사용하는 방법
    @Test
    void create() {
        System.out.println(System.getenv("TEST_ENV"));

//        assumeTrue의 조건을 만족하면 아래 코드를 실행한다.
//        assumeTrue("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")));

        Study study = new Study(10);
        assertNotNull(study);

        assumingThat("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")), () -> {
            System.out.println("(코드 방식)LOCAL 환경일때 실행하는 테스트");
        });

        assumingThat("kwak".equalsIgnoreCase(System.getenv("TEST_ENV")), () -> {
            System.out.println("(코드 방식)kwak 환경일때 실행하는 테스트");
        });
    }

    //    어노테이션으로 사용하는 방법
    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void create1_1() {
        System.out.println("(어노테이션 방식)LOCAL 환경일때 실행하는 테스트");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "kwak")
    void create1_2() {
        System.out.println("(어노테이션 방식)kwak 환경일때 실행하는 테스트");
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.LINUX})
    void create2() {
        System.out.println("MAC 환경일때 실행되는 테스트");
    }

    @Test
    @DisabledOnOs(OS.MAC)
    void create3() {
        System.out.println("MAC 환경일때 비활성화되는 테스트");
    }

    @Test
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9})
    void create4() {
        System.out.println("JRE8, 9 버전일때만 실행");
    }

    @Test
    @DisabledOnJre({JRE.JAVA_8, JRE.JAVA_9})
    void create5() {
        System.out.println("JRE8, 9 버전일때만 실행안됨");
    }
}