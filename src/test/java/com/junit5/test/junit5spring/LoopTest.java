package com.junit5.test.junit5spring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class LoopTest {

    @DisplayName("반복 테스트")
    @RepeatedTest(value = 5, name = "{displayName}, {currentRepetition} / {totalRepetitions}")
    void repeat_test(RepetitionInfo repetitionInfo) {
        System.out.println("repeat test " + repetitionInfo.getCurrentRepetition() + " / " + repetitionInfo.getTotalRepetitions());
    }

    //    반복적인 테스트를 다른 값을 이용해서 테스트를 해야 할 경우
    @DisplayName("반복 파라미터 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"주말에", "카페에서", "공부라니", "ㅎㅎㅎ좋"})
    @NullSource
    @EmptySource
//    @NullAndEmptySource
    void parameterized_test(String message) {
        System.out.println(message);
    }
}