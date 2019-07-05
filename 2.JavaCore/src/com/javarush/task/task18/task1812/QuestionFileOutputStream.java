package com.javarush.task.task18.task1812;

import java.io.*;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream outputStream;

    public QuestionFileOutputStream(AmigoOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void flush() throws IOException {
        getOutputStream().flush();
    }

    @Override
    public void write(int b) throws IOException {
        getOutputStream().write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        getOutputStream().write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
getOutputStream().write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        try (Scanner scan = new Scanner(System.in)){
            String answer = null;
            while ((answer = scan.nextLine()) != null) {
                if(answer.equals("Д")){
                    getOutputStream().close();
                    break;
                } else if(answer.equals("Н")){
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AmigoOutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(AmigoOutputStream outputStream) {
        this.outputStream = outputStream;
    }
}

