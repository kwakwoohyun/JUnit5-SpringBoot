package com.junit5.test.junit5spring;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TagFilter {

    @Test
    @Tag("fast")
    void fast() {
        System.out.println("Tag fast");
    }

    @Test
    @Tag("slow")
    void slow(){
        System.out.println("Tag slow");
    }

}