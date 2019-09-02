package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args)  {

        try(BufferedOutputStream resultWriteStream = new BufferedOutputStream(new FileOutputStream(args[0])))
        {
            List<FileInputStream> archivedStreams =
                    Arrays.stream(args)
                    .skip(1)
                    .sorted()
                    .map(Solution::toInputSream)
                    .collect(Collectors.toList());

            SequenceInputStream unitedStreams = new SequenceInputStream(Collections.enumeration(archivedStreams));

            ZipInputStream deArchivedStream = new ZipInputStream(unitedStreams);

            while (deArchivedStream.getNextEntry() != null) {
                streamTransfer(deArchivedStream, resultWriteStream);
            }

            resultWriteStream.flush();
            deArchivedStream.close();
            unitedStreams.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static FileInputStream toInputSream(String nameZipPart) {
            try {
                return new FileInputStream(nameZipPart);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return null;
        }

    private static void streamTransfer(ZipInputStream deArchivedStream, OutputStream writeStream) throws IOException {
        byte[] buffer = new byte[1024*1024];
        int length;
        while ((length = deArchivedStream.read(buffer)) > 0){
            writeStream.write(buffer, 0, length);
        }
    }
}
