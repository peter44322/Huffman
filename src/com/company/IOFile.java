package com.company;
import java.io.*;

public class IOFile {
    private String filePath ;
    private Boolean append = false;

    IOFile(String filePath){
        setFilePath(filePath);
    }
    IOFile(String filePath,Boolean append){
        setFilePath(filePath);
        this.append = append;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void writeOrCreate(String content)  {
        try {
            FileWriter file = new FileWriter(this.filePath,this.append);
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.printf("%s"+"%n",content);
            printWriter.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String readFile(){
        String content = null;
        File file = new File(this.filePath); // For example, foo.txt
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }



}
