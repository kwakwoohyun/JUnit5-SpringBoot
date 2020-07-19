package com.junit5.test.junit5spring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LoopTest2 {

    //    int 인자를 Study 클래스르 받고싶을때 Convert 해주어야 한다.
    @DisplayName("하나의 인자값을 Study 클래스로 받을때 Convert")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(ints = {10, 20, 30})
    void parameterized_test1(@ConvertWith(StudyConvert.class) Study study) {
        System.out.println(study.getLimit());
    }

    static class StudyConvert extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
//            기대한 값과 실제값이 같은지 확인
            assertEquals(Study.class, aClass, "Can only convert to Study");
//            같으면 넘어온 값을 Integer로 파싱하여 리턴해준다.
            return new Study(Integer.parseInt(o.toString()));
        }
    }

    //---------------------------------------------------------------------------------------------------------

    @DisplayName("반복 파라미터 테스트, 여러개의 파라미터법1 기본 방법")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"10, '자바 스터디'", "20, '스프링 스터디'"})
    void parameterized_test2(int limit, String name) {
        Study study = new Study(limit, name);
        System.out.println(study);
    }

    //---------------------------------------------------------------------------------------------------------

    @DisplayName("반복 파라미터 테스트, 여러개의 파라미터2 ArgumentsAccessor 사용")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"10, '자바 스터디'", "20, '스프링 스터디'"})
    void parameterized_test3(ArgumentsAccessor argumentsAccessor) {
        Study study = new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        System.out.println(study);
    }

    //---------------------------------------------------------------------------------------------------------

    @DisplayName("반복 파라미터 테스트, 여러개의 파라미터3 ArgumentsAggregator 사용")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"10, '자바 스터디'", "20, '스프링 스터디'"})
    void parameterized_test4(@AggregateWith(StudyAggregator.class) Study study) {
        System.out.println(study);
    }

    static class StudyAggregator implements ArgumentsAggregator {
        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        }
    }

}