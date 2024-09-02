package com;

public class Main {
    public static void main(String[] args){
        ReadFile readFile = new ReadFile();
        String string1 = readFile.Read(args[0]);
        String string2 = readFile.Read(args[1]);
    }
}