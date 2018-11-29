package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Huffman {
    private String text ;
    public static final int ALPHABET_SIZE = 265;
    Map<Character,String> encodeTable = new HashMap<>();
    int[] frequencyTable =  new int[ALPHABET_SIZE] ;
    HuffmanTree tree;

    Huffman(String text){
        this.text=text;

    }


    private void buildEncodeTable(Node node,String code){
        if (! node.isLeaf()){
            buildEncodeTable(node.leftNode,code +'0');
            buildEncodeTable(node.rightNode,code+'1');
        }else {
            encodeTable.put(node.character,code);
        }

    }

    private void buildFrequencyTable(){
        for (char character:text.toCharArray()) {
            frequencyTable[character]++;
        }
    }

    public CommpressedData compress(){
        buildFrequencyTable();
        tree = new HuffmanTree(frequencyTable);
        buildEncodeTable(tree.root,"");

        String comprission = "";
        for (char character:text.toCharArray()) {
            comprission += encodeTable.get(character) ;
        }
        CommpressedData commpressedData = new CommpressedData(comprission,tree.root);
        return commpressedData;
    }

    public static String decompress(CommpressedData encodedData){
        String result = "";
        Node current = encodedData.getRoot();
        int i = 0;
        while(i < encodedData.toString().length()){
            while (!current.isLeaf()){
                char bit = encodedData.toString().charAt(i);
                if (bit == '1'){
                    current = current.rightNode;
                }
                else if (bit == '0'){
                    current = current.leftNode;
                }
                i++;
            }
            result += current.character;
            current = encodedData.getRoot();
        }
        return result;
    }





}
