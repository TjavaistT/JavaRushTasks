package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.ZipFile;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) throws IOException {
        Properties properties;
        try {
            properties = new Properties();
            if (fileName.endsWith(".xml")) {
                properties.loadFromXML(new FileInputStream(fileName));
            } else {
                properties.load(new FileReader(fileName));
            }
        } catch (IOException e) {
            properties = new Properties();
        }
        new ZipFile(new File("dsff"));
        return properties;
    }
}
