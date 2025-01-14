package com.ReadWriteUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputFile {
    /**
     * 写出相似度到答案文件
     * @param url 写出文本文件绝对路径
     * @param ratio 相似度
     * @throws IOException I/O读写异常
     */
    public static void Output(String url,Number ratio) throws IOException {
        try {
            // 创建FileOutputStream对象，用于将数据写入指定路径的文件
            FileOutputStream fileOutputStream = new FileOutputStream(url);

            // 使用OutputStreamWriter将字符流写入文件输出流
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

            // 将指定的字符串写入文件
            System.out.println("论文查重率为 " + String.format("%.2f",ratio) + "%");
            outputStreamWriter.write("论文查重率为 " + String.format("%.2f",ratio) + "%");

            // 关闭OutputStreamWriter以确保数据正确写入并释放资源
            outputStreamWriter.close();

        } catch (IOException e) {
            // 如果发生I/O错误，抛出运行时异常并附带详细错误信息
            throw new IOException("文件写入失败" + e);
        }

    }
}
