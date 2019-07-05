package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream component;

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public AmigoOutputStream(FileOutputStream component) throws FileNotFoundException {
        super(fileName);
        this.component = component;
    }


    public static String getFileName() {
        return fileName;
    }

    public FileOutputStream getComponent() {
        return component;
    }

    @Override
    public void close() throws IOException {
        component.flush();
        byte[] copiright = ("JavaRush © All rights reserved.").getBytes();
        component.write(copiright);
        component.close();
    }

    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }
}
