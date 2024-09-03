package com.ReadWriteUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OutputFileTest {

    @Test
    void output() throws IOException {
        OutputFile.Output("D:/test/out.txt",50);
    }
}