package com.company;

import java.io.Serializable;

public class Node implements Comparable<Node> ,Serializable {
    public char character;
    public Node leftNode;
    public Node rightNode;
    public int frequency;

    Node(char character,int frequency,Node rightNode,Node leftNode){
        this.character = character;
        this.frequency = frequency;
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }

    @Override
    public int compareTo(Node o) {
        return this.frequency - o.frequency;
    }

    boolean isLeaf(){
        return this.leftNode == null && this.rightNode == null;
    }
}
