package com.company;

import java.io.Serializable;

public  class CommpressedData implements Serializable {
    private String encodedData;
    private Node root;

    CommpressedData(String encodedData,Node root){
        this.encodedData=encodedData;
        this.root=root;
    }

    public String toString(){
        return encodedData;
    }

    public Node getRoot() {
        return root;
    }
}
