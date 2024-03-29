package com.javarush.task.task34.task3409;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/*
Настраиваем логгер
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String logProperties = "4.JavaCollections/src/" + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/log4j.properties";
        Path path = Paths.get(logProperties).toAbsolutePath();
        try (InputStream is = new FileInputStream(path.toFile())) {
            Properties properties = new Properties();
            properties.load(is);
            properties.setProperty("log4j.appender.file", "org.apache.log4j.RollingFileAppender");
            properties.setProperty("log4j.rollingAppender.file.MaxFileSize", "5MB");
            properties.setProperty("log4j.appender.file.File", "D:\\log\\runApp.log");

            properties.setProperty("log4j.appender.file.MaxFileSize", "5MB");
            properties.setProperty("log4j.appender.file.MaxBackupIndex", "6");

            properties.setProperty("log4j.rootLogger", "WARN, file, stdout");
            properties.setProperty("log4j.appender.file.threshold", "WARN");
            properties.setProperty("log4j.appender.stdout.threshold", "ERROR");
            FileOutputStream fos = new FileOutputStream(path.toFile());
            properties.store(fos, "");
        }
    }
}
