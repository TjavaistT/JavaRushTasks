package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes imageType){
        ImageReader reader = null;

        // ты здесь логично спросишь - почему не switch?
        // а я логично отвечу - это Java, Детка!
        // поймаешь NullPointerException
        if (imageType == ImageTypes.BMP) {
            reader = new BmpReader();
        } else if (imageType == ImageTypes.JPG) {
            reader = new JpgReader();
        } else if (imageType == ImageTypes.PNG) {
            reader = new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }

        return reader;
    }
}
