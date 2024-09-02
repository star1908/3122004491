package com;

public class Main {
    public static void main(String[] args) throws Exception {
        if(args.length < 3){
            throw new Exception("绝对路径不足三个，自动结束");
        }

        ReadFile readFile = new ReadFile();
        String string1 = readFile.Read(args[0]);
        String string2 = readFile.Read(args[1]);

        PlagiarismChecker plagiarismChecker = new PlagiarismChecker();
        Number ratio = plagiarismChecker.checker(string1,string2);

        OutputFile outputFile = new OutputFile();
        outputFile.Output(args[2],ratio);
    }
}