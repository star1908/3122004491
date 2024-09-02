package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    // 读取指定路径的文件内容并返回其内容的字符串表示
    public String Read(String url) {
        // 接收文件路径获取文件
        File file = new File(url);

        try {
            // 使用Scanner类读取文件内容
            Scanner scanner = new Scanner(file);
            StringBuilder content = new StringBuilder();

            // 逐行读取文件内容并追加到StringBuilder对象中
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
                // 添加系统行分隔符来保持文件的原始格式
                content.append(System.lineSeparator());
            }

            // 关闭Scanner对象以释放资源
            scanner.close();

            // 输出文件内容到控制台
            System.out.println(content.toString());
            // 返回文件内容作为字符串
            return content.toString();

        } catch (FileNotFoundException e) {
            // 如果文件未找到，抛出运行时异常并附带详细错误信息
            throw new RuntimeException("文件未找到", e);
        }

    }
}
