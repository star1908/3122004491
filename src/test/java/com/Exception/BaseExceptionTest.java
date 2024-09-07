package com.Exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseExceptionTest {

    @Test
    void test(){
         new BaseException("报错基类");
    }
}