package com;

import com.ComputeUtils.HammingUtils;
import com.ComputeUtils.SimHashUtils;
import com.Exception.InsufficientParametersException;
import com.ReadWriteUtils.OutputFile;
import com.ReadWriteUtils.ReadFile;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() throws IOException {
        // Main.main(["D:/test/test.txt","D:/test/test0.txt","D:/test/out.txt"]);

        String[] args = {"D:/test/test.txt","D:/test/test0.txt","D:/test/out.txt"};

        // 判断命令行参数是否有三个
        if(args.length < 3) throw new InsufficientParametersException("绝对路径不足三个，自动结束");


        // 读取两个文件的文本
        String string1 = ReadFile.Read(args[0]);
        String string2 = ReadFile.Read(args[1]);

        // 将文本转换simhash值
        String simhash1 = SimHashUtils.getSimHash(string1);
        String simhash2 = SimHashUtils.getSimHash(string2);

        // 计算海明距离并输出相似度
        double ratio = HammingUtils.getSimilarity(simhash1,simhash2);

        // 将相似度写入文件
        OutputFile.Output(args[2],ratio);
    }
}