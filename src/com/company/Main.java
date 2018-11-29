package com.company;

public class Main {

    public static void main(String[] args) {
        IOFile text = new IOFile("text.txt");
        Huffman encoding = new Huffman(text.readFile());

        System.out.println(encoding.compress().toString());

        IOFile commpressedDataFile = new IOFile("compressedData.txt");
        commpressedDataFile.writeHuffmanCommpressedData(encoding.compress());

        CommpressedData data = commpressedDataFile.readHuffmanCommpressedData();

        System.out.println(Huffman.decompress(data));


    }
}
