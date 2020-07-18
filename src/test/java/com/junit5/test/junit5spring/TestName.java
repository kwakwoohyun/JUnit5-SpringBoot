package com.junit5.test.junit5spring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TestName {

    @Test
    void create_new_study() {
        Study study = new Study();
        assertNotNull(study);
    }

    @Test
    @DisplayName("스터디 함수")
    void create_new_study2() {
        Study study = new Study();
        assertNotNull(study);
    }

}