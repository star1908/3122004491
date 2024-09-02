package com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputFile {
    public void Output(String url,Number ratio) {
        try {
            // 创建FileOutputStream对象，用于将数据写入指定路径的文件
            FileOutputStream fileOutputStream = new FileOutputStream(url);

            // 使用OutputStreamWriter将字符流写入文件输出流
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

            // 将指定的字符串写入文件
            outputStreamWriter.write("论文查重率为 " + ratio);

            // 关闭OutputStreamWriter以确保数据正确写入并释放资源
            outputStreamWriter.close();

        } catch (IOException e) {
            // 如果发生I/O错误，抛出运行时异常并附带详细错误信息
            throw new RuntimeException("文件写入失败", e);
        }

    }
}
