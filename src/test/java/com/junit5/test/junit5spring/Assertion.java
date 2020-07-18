package com.junit5.test.junit5spring;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class Assertion {

    @Test
    void create() {
        Study study = new Study(0);

//        만약 두개의 assert가 에러이면 첫번째거에서 먼저 에러가 나므로 두번째거는 에러인지 알 수 없다.
//        그러므로 assertAll()로 묶어준다.

//        assertNotNull(study);
//        assertEquals(StudyStatus.ENDED, study.getStatus(), () -> "실패시 메세지입니다.");
//        assertTrue(study.getLimit() > 0, () -> "스터디 참석 인원은 최대 0명 이상이어야 한다.");

        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.ENDED, study.getStatus(), () -> "실패시 메세지입니다."),
                () -> assertTrue(study.getLimit() > 0, () -> "스터디 참석 인원은 최대 0명 이상이어야 한다.")
        );
    }

    @Test
    void create2() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        String msg = exception.getMessage();
        assertEquals("limit은 0보다 커야한다.", msg);
    }

    @Test
    void create3() {
        assertTimeout(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });
    }

}