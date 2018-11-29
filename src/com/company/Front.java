package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Front extends Frame implements ActionListener {
    private Label lbl;
    private TextField text;
    private Button encodeBtn;
    private TextArea commpressedData;
    private Button saveFileBtn;
    private Button loadFileBtn;

    private JLabel Br = new JLabel("<html><br/></html>", SwingConstants.CENTER);
    Huffman encoding;

    public Front () {
        setLayout(new FlowLayout());


        lbl = new Label("Text");
        add(lbl);

        text = new TextField(  10);
        text.setEditable(true);
        add(text);

        encodeBtn = new Button("encode");
        add(encodeBtn);
        add(Br);
        encodeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String myText = text.getText();
                if (myText.length() == 0){
                    infoBox("You Should Type Somthing First ","Error");
                    return;
                }

                encoding = new Huffman(myText);
                commpressedData.setText(encoding.compress().toString());
                add(saveFileBtn);
                pack();
            }
        });

        saveFileBtn = new Button("save Compressed Data");
        saveFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                final FileDialog fileDialog = new FileDialog(new Front(),"Save file",FileDialog.SAVE);
                fileDialog.setVisible(true);
                String fileName=fileDialog.getDirectory() + fileDialog.getFile();


                IOFile commpressedDataFile = new IOFile(fileName);
                commpressedDataFile.writeHuffmanCommpressedData(encoding.compress());
                infoBox("Saved To "+fileName,"Done");


            }
        });

        loadFileBtn = new Button("load Compressed Data");
        add(loadFileBtn);
        loadFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                Front app = new Front();
                final FileDialog fileDialog = new FileDialog(app,"Save file",FileDialog.LOAD);
                fileDialog.setVisible(true);
                String fileName=fileDialog.getDirectory() + fileDialog.getFile();

                IOFile commpressedDataFile = new IOFile(fileName);

                CommpressedData data = commpressedDataFile.readHuffmanCommpressedData();
                app.commpressedData.setText(Huffman.decompress(data));
                System.out.println(Huffman.decompress(data));

                infoBox("Loaded"+fileName,"Done");


            }
        });



        commpressedData = new TextArea(5,40);
        commpressedData.setEditable(false);
        add(commpressedData);

        setTitle("Huffman Encoding/Decoding");
        setSize(400, 600);
        setVisible(true);


    }

    public static void main(String[] args) {
        Front app = new Front();
    }

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    private void showFileDialogDemo(){

        final FileDialog fileDialog = new FileDialog(this,"Select file");
        Button showFileDialogButton = new Button("Open File");
        showFileDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileDialog.setVisible(true);
//                    statusLabel.setText("File Selected :"
//                            + fileDialog.getDirectory() + fileDialog.getFile());
            }
        });

        add(showFileDialogButton);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent evt) {

    }
}