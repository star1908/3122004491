package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public void Read(String url) {
        // 接收文件路径获取文件
        File file = new File(url);

        try {
            Scanner scanner = new Scanner(file);
            StringBuilder content = new StringBuilder();

            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
                content.append(System.lineSeparator());
            }

            scanner.close();
            System.out.println(content.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException("文件未找到",e);
        }

    }
}
