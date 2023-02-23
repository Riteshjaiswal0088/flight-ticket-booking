package com.ritesh.flightticketbooking;

import org.junit.jupiter.api.*;

public class ControlFlow {

    @Test
    void test(){
        System.out.println("test");
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("beforeEach");
    }
    @AfterEach
    void afterEach(){
        System.out.println("afterEach");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("beforeAll");
    }
    @AfterAll
   static void afterAll(){
        System.out.println("afterAll");
    }

}
