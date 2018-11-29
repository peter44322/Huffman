package com.company;

import java.util.PriorityQueue;

public class HuffmanTree {

    int[] frequencyTable;
    Node root;

    HuffmanTree(int[] frequencyTable){
        this.frequencyTable = frequencyTable;
        build();
    }

    private void build(){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (char i = 0;i<Huffman.ALPHABET_SIZE;i++){
            if(frequencyTable[i] > 0){
                Node node = new Node(i,frequencyTable[i],null,null);
                queue.add(node);
            }
        }

        while (queue.size() > 1){
            Node left = queue.poll();
            Node right = queue.poll();
            Node parant = new Node('\0',left.frequency+right.frequency,right,left);
            queue.add(parant);
        }

        root =  queue.poll();
    }
}
