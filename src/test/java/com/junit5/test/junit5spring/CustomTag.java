package com.junit5.test.junit5spring;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CustomTag {

    @Test
    @Tag("fast")
    void tag_test(){
        System.out.println("@Test, @Tag 둘다 사용하는 테스트 (fast)");
    }

    @FastTest
    void custom_fast_test(){
        System.out.println("@Test, @Tag를 둘다 포함하는 @FaastTest 커스텀 어노테이션을 사용하는 테스트");
    }

    @Test
    @Tag("slow")
    void tag_test2(){
        System.out.println("@Test, @Tag 둘다 사용하는 테스트 (slow)");
    }

    @SlowTest
    void custom_slow_test(){
        System.out.println("@Test, @Tag를 둘다 포함하는 @SlowTest 커스텀 어노테이션을 사용하는 테스트");
    }
}