package com.company;

public class Main {

    public static void main(String[] args) {

        IOFile file = new IOFile("text.txt",true);
        file.writeOrCreate("DDDD");

        System.out.println(file.readFile());

    }
}
