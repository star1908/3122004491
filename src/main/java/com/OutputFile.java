package com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputFile {
    public void Output(String url,Number ratio) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(url);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

            outputStreamWriter.write("论文查重率为 " + ratio);
            outputStreamWriter.close();

        } catch (IOException e) {
            throw new RuntimeException("文件写入失败", e);
        }
    }
}
